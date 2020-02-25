package com.example.Kimberly_McGrath_Santander_SBT_X.service;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.DeleteAccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Component
@Transactional
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

    public Account updateAccountbyId(String accountId, String lastName, String phoneNumber, AccountRequest accountRequest) throws Exception {


        //get account being passed
        Account existingAccount = getAccountById(accountId);
        System.out.println("I am getting the account :" + existingAccount);

        //check to make sure it is not null
        if (existingAccount != null) {
            System.out.println("I am checking the correct accountId " + accountId);

            Account account = new Account();
//            account.getLastName();
//            account.getPhoneNumber();

//            account.setAccountId(accountId);
            account.setLastName(lastName);
            account.setPhoneNumber(phoneNumber);

            Account updatedAccount = accountRepository.save(existingAccount);
            System.out.println("I am hitting updatedAccount " + updatedAccount);

            return updatedAccount;


        } else {
            throw new Exception("Error updating account");
        }
    }


    public void deleteAccountById(String accountId, DeleteAccountRequest deleteAccountRequest) throws Exception {

        Account existingAccount = getAccountById(accountId);

        if (existingAccount != null) ;
        accountRepository.deleteById(accountId);
    }


}


