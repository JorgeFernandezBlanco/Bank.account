package com.Bankaccount.controller;


import com.Bankaccount.model.Account;
import com.Bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    public String createAccount(@RequestParam String owner) {
        accountService.createAccount(owner);
        return "redirect:/";
    }

    @PostMapping("/{accountId}/deposit")
    public String deposit(@PathVariable Long accountId, @RequestParam double amount) {
        accountService.deposit(accountId, amount);
        return "redirect:/accounts/" + accountId;
    }

    @PostMapping("/{accountId}/withdraw")
    public String withdraw(@PathVariable Long accountId, @RequestParam double amount) {
        accountService.withdraw(accountId, amount);
        return "redirect:/accounts/" + accountId;
    }

    @GetMapping("/{accountId}")
    public String getAccount(@PathVariable Long accountId, Model model) {
        Account account = accountService.getAccount(accountId);
        double balance = accountService.getBalance(accountId);
        model.addAttribute("account", account);
        model.addAttribute("balance", balance);
        model.addAttribute("transactions", accountService.getTransactions(accountId));
        return "account";
    }
}
