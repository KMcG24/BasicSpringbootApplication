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
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.*;

@Service
@Component
@Transactional
public class AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Long accountId) throws Exception {

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

    public Account updateAccountbyId(Long accountId, Account account) throws Exception {

        Account existingAccount = getAccountById(accountId);
        existingAccount.getAccountId();
        existingAccount.getLastName();
        existingAccount.getPhoneNumber();

        if (existingAccount.getAccountId() != null) {

        } if (existingAccount.getLastName() != null) {
            existingAccount.setLastName(account.getLastName());

        } if (existingAccount.getPhoneNumber() != null ) {
            existingAccount.setPhoneNumber(account.getPhoneNumber());
        }
        return accountRepository.save(existingAccount);
    }

    public void deleteAccountById(@Valid Long accountId, DeleteAccountRequest deleteAccountRequest) throws Exception {

        Account existingAccount = getAccountById(accountId);

        if (existingAccount != null) ;
        accountRepository.deleteById(accountId);
    }

}


