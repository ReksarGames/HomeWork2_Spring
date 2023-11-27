package com.danit.springrest.resources;

import com.danit.springrest.enums.Currency;
import com.danit.springrest.model.Account;
import com.danit.springrest.model.Customer;
import com.danit.springrest.service.AccountService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
@Slf4j
public class AccountRestController {
    private final AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable String accountId) {
        Account account = accountService.getAccountById(accountId);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/createAccount")
    public ResponseEntity<Account> createAccount(
            @ApiParam(value = "Customer details", required = true) @RequestBody Customer customer) {
        System.out.println("Received Customer: " + customer);
        Account createdAccount = accountService.createAccountForCustomer(customer,Currency.UAH);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdAccount.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdAccount);
    }
//    @PostMapping("/createAccount")
//    public ResponseEntity<Account> createAccount(@RequestBody Customer customer) {
//        System.out.println("Received Customer: " + customer); // Вивід для відлагодження
//        Account createdAccount = new Account(Currency.UAH,customer);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(createdAccount.getId())
//                .toUri();
//        return ResponseEntity.ok().body(createdAccount);
//    }

    @PutMapping("/{accountId}")
    public ResponseEntity<Void> updateAccount(@PathVariable String accountId, @RequestBody Account updatedAccount) {
        accountService.updateAccount(accountId, updatedAccount);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String accountId) {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/deposit/{accountId}")
    public ResponseEntity<Void> depositMoney(@PathVariable String accountId, @RequestParam double amount) {
        accountService.depositMoney(accountId, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/withdraw/{accountId}")
    public ResponseEntity<Void> withdrawMoney(@PathVariable String accountId, @RequestParam double amount) {
        accountService.withdrawMoney(accountId, amount);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/transfer")
    public ResponseEntity<Void> transferMoney(@RequestParam String fromAccountId, @RequestParam String toAccountId, @RequestParam double amount) {
        accountService.transferMoney(fromAccountId, toAccountId, amount);
        return ResponseEntity.ok().build();
    }

}
