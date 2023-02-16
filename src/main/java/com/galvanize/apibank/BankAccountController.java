package com.galvanize.apibank;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountController {

    List<BankAccount> accounts = new ArrayList<>();

    public BankAccountController(){
        accounts.add(new BankAccount(1, "Nmuta", 10000.00));
        accounts.add(new BankAccount(2, "Rob", 10000.00));
        accounts.add(new BankAccount(3, "Zach", 9.99));
    }

    @GetMapping("/{id}")
    public BankAccount getBankAccountById(@PathVariable int id){
        BankAccount bankAccount = null;
        for (BankAccount acct : accounts){
            if (acct.getId() == id){
                bankAccount = acct;
            }
        }
        return bankAccount;
    }

}
