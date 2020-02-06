package com.example.Kimberly_McGrath_Santander_SBT_X.service;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccountById(String accountId) throws Exception {

        final Optional<Account> account = getAccountById(accountId);
        if (account != null) {
            return accountRepository.findById(accountId);
        } else {
            throw new Exception ("Account not found");
        }

   }
}
