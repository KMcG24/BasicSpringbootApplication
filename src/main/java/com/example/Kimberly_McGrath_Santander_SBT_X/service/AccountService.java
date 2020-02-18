package com.example.Kimberly_McGrath_Santander_SBT_X.service;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;


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

//        Account existingAccount = getAccountById(accountId);
//        if (existingAccount == null) {
//            LOGGER.error("account {} does not exist");
//            throw new Exception("account {} does not exist");
//
//        }if (existingAccount != null) {
////                final Account updatedAccount = accountRepository.save(accountId);
////                System.out.println("updated Account:" + updatedAccount);
//                return accountRepository.save(accountId);
        Account existingAccount = accountRepository.save(accountId);
        if (existingAccount !=null) {
            final Account updatedAccount = accountRepository.save(accountId);
            return updatedAccount;

            } else {
                throw new Exception("Error updating account");
            }
        }


//
//    public void deleteAccountById(String accountId, DeleteAccountRequest deleteAccountRequest) throws Exception {
//         final Account deleteAccount = accountRepository.deleteById(accountId);
//        if (deleteAccount.()) {
//
//        } else {
//            throw new Exception("Account not found");
//        }
//    }

    }


