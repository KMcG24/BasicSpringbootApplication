package com.example.Kimberly_McGrath_Santander_SBT_X.service;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    public Account getAccountById(String accountId) throws Exception {

        final Account account = getAccountById(accountId);
        if (account != null) {
            return account;
        } else {
            throw new Exception ("Account not found");
        }
//        return new Account();
   }
}
