package com.galvanize.apibank;

import org.springframework.web.bind.annotation.*;
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

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BankAccount> addBankAccount(@RequestBody BankAccount newAccount) {
        accounts.add(newAccount);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAccount);
    }

    @PutMapping("/update")
    public void updateAccount(@RequestBody BankAccount account){
        for(BankAccount acct : accounts){
            if (acct.getId() == account.getId()){
                acct.setBalance(account.getBalance());
            }
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable int id){
        for(BankAccount acct : accounts){
            if (acct.getId() == id){
                accounts.remove(acct);
            }
        }
    }
}
