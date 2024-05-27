package com.Bankaccount.service;




import com.Bankaccount.model.Account;
import com.Bankaccount.model.Transaction;
import com.Bankaccount.repository.AccountRepository;
import com.Bankaccount.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount(String owner) {
        Account account = new Account();
        account.setOwner(owner);
        account.setBalance(0.0);
        return accountRepository.save(account);
    }

    @Transactional
    public Account deposit(Long accountId, double amount) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() + amount);

            Transaction transaction = new Transaction();
            transaction.setDate(LocalDateTime.now());
            transaction.setType("DEPOSIT");
            transaction.setAmount(amount);
            transaction.setAccount(account);
            transactionRepository.save(transaction);

            return account;
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    @Transactional
    public Account withdraw(Long accountId, double amount) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);

                Transaction transaction = new Transaction();
                transaction.setDate(LocalDateTime.now());
                transaction.setType("WITHDRAWAL");
                transaction.setAmount(amount);
                transaction.setAccount(account);
                transactionRepository.save(transaction);

                return account;
            } else {
                throw new RuntimeException("Insufficient funds");
            }
        } else {
            throw new RuntimeException("Account not found");
        }
    }

    public double getBalance(Long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        return optionalAccount.map(Account::getBalance).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    public List<Transaction> getTransactions(Long accountId) {
        return transactionRepository.findByAccountId(accountId);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
    public Account getAccount(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }


}
