package com.Bankaccount.controller;




import com.Bankaccount.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("accounts", accountService.getAllAccounts());
        return "home";
    }
}
