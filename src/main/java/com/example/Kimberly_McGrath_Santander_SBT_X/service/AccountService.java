package com.example.Kimberly_McGrath_Santander_SBT_X.service;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


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
            throw new Exception("Account not found");
        }
    }

    public List getAccounts() throws Exception {

        List<Account> accountList = (List<Account>) accountRepository.findAll();
        if (!accountList.isEmpty()) {
            return (List) accountList;

        } else {
            throw new Exception("There are no existing accounts");
        }
    }

    public Account updateAccountbyId(Account accountId, AccountRequest accountRequest) throws Exception {

        ArrayList<Account> accountArrayList = (ArrayList<Account>) accountRepository.findAll();
        for (Account accounts : accountArrayList) {
            System.out.println(getAccounts());
        }

        Account updatedAccount = accountRepository.save(accountId);

        if (updatedAccount != null && !accountArrayList.contains(updatedAccount)) {
            accountRepository.save(accountId);
            return updatedAccount;

        } else {
            throw new Exception("No account to update");
        }


//    public void deleteAccountById(String accountId) throws Exception {
//        Account deleteAccount = accountRepository.deleteById(String accountId);
//        if (deleteAccount.isPresent()) {
//
//        } else {
//            throw new Exception("Account not found");
//        }
//    }
    }
}

