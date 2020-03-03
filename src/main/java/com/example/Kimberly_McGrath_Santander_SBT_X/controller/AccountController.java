package com.example.Kimberly_McGrath_Santander_SBT_X.controller;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.DeleteAccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import com.example.Kimberly_McGrath_Santander_SBT_X.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Component

public class AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;
    AccountRepository accountRepository;


    /**
     * Getting account with accountId
     * @param accountId
     * @return
     */


    @GetMapping(path = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getAccountById(@Valid @PathVariable Long accountId) throws Exception {

        return new ResponseEntity<Object>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List> getAllAccounts() throws Exception {

        return new ResponseEntity<List>(accountService.getAccounts(), HttpStatus.OK);
    }

    @PatchMapping (path = "/account/update/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> updateAcctById(@PathVariable Long accountId,
                                                  @Valid @RequestBody Account account) throws Exception {
        accountService.updateAccountbyId(accountId, account);
        return new ResponseEntity<Account>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/account/delete/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteAccountById (@Valid @PathVariable Long accountId,
                                                     @Valid @RequestBody DeleteAccountRequest deleteAccountRequest) throws Exception {
        accountService.deleteAccountById(accountId, deleteAccountRequest);
        LOGGER.info("Account " + accountId + " deleted successfully");
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
