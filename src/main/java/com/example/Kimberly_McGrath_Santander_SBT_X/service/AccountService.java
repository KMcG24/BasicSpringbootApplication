package com.example.Kimberly_McGrath_Santander_SBT_X.service;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(String accountId) throws Exception {

        Optional<Account> accountOptional = accountRepository.findById(accountId);
        if (accountOptional.isPresent()) {
            return accountOptional.get();
        } else {
            throw new Exception ("Account not found");
        }
   }

    public List getAccounts() throws Exception{

        List<Account> accountList = (List<Account>) accountRepository.findAll();
        if (!accountList.isEmpty()) {
            return (List) accountList;

        } else {
            throw new Exception ("There are no existing accounts");
        }
    }

    public void updateAccountbyId(Account accountId) throws Exception {

        Account updatedAccount = accountRepository.save(accountId);

        if (updatedAccount != null) {
            accountRepository.save(accountId);
        } else {
            throw new Exception("No account to update");
        }
    }

//    public Account deleteAccountById(String accountId) throws Exception {
//
//        void <Account> account = accountRepository.deleteById(accountId);
//        if (account!=null) {
//            return account;
//        } else {
//            throw new Exception ("Account not found");
//        }
    }

