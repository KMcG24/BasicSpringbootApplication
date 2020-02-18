package com.example.Kimberly_McGrath_Santander_SBT_X.controller;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.DeleteAccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Component

public class AccountController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    AccountService accountService;


    /**
     * Getting account with accountId
     * @param accountId
     * @return
     */


    @GetMapping(path = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Object> getAccountById(@Valid @PathVariable String accountId) throws Exception {

        return new ResponseEntity<Object>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @GetMapping(path = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List> getAllAccounts() throws Exception {

        return new ResponseEntity<List>(accountService.getAccounts(), HttpStatus.OK);
    }

    @PatchMapping (path = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Account> updateAcctById(@PathVariable String accountId,
                                                  @Valid @RequestBody AccountRequest accountRequest) throws Exception {
        accountService.updateAccountbyId(accountId, accountRequest);
        return new ResponseEntity<Account>(HttpStatus.OK);
    }

//    @DeleteMapping(path = "/account/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> deleteAccountById (@Valid @PathVariable String accountId,
//                                                     @Valid @RequestBody DeleteAccountRequest deleteAccountRequest) throws Exception {
//        accountService.deleteAccountById(accountId, deleteAccountRequest);
//        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
//    }
}
