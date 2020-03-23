package com.example.Kimberly_McGrath_Santander_SBT_X.service;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.DeleteAccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import javafx.util.Builder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)

public class AccountServiceTest {

    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    private Account account;

    private List accountList;

    @Test
    public void findById_ShouldFindAccountById() throws Exception {

        Account account = new Account();
        account.setAccountId(1L);
        account.setLastName("Frank");
        account.setPhoneNumber("99999999999");

        Mockito.lenient().when(accountRepository.findById(1L)).thenReturn(java.util.Optional.of(account));

        final Account expected = accountService.getAccountById(1L);

        Assert.assertEquals(expected, account);
        Mockito.verify(accountRepository, times(1)).findById(1L);
    }

    @Test
    public void getAccounts_shouldGetAllAccounts() throws Exception {

        Account account1 = new Account();
        account1.setAccountId(1L);
        account1.setLastName("Gomez");
        account1.setPhoneNumber("86384368");

        Account account2 = new Account();
        account2.setAccountId(2L);
        account2.setLastName("Johnson");
        account2.setPhoneNumber("2222222222");

        Account account3 = new Account();
        account3.setAccountId(3L);
        account3.setLastName("Martin");
        account3.setPhoneNumber("33333333");


        final List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        Mockito.lenient().when(accountRepository.findAll()).thenReturn(accountList);

        final List<Account> result = accountService.getAccounts();
        Assert.assertEquals(accountList, result);
    }

        @Test
        public void updateAccount_ShouldUpdateAccount() throws Exception {

        Account account = new Account();
        account.setAccountId(1L);
        account.setLastName("Smith");
        account.setPhoneNumber("0000000");

        Account updatedAccount = new Account();
        updatedAccount.setAccountId(1L);
        updatedAccount.setLastName("Jones");
        updatedAccount.setPhoneNumber("9999900000");

        Mockito.lenient().when(accountRepository.save(account)).thenReturn(updatedAccount);
        }

        @Test
        public void deleteAccount_ShouldDeleteAccount() throws Exception {
            Account account = new Account();
            account.setAccountId(1L);
            account.setLastName("Frank");
            account.setPhoneNumber("99999999999");

            DeleteAccountRequest deleteAccountRequest = new DeleteAccountRequest();
//            DeleteAccountRequest.setAccountId(1L);
            //give this object the accountId?

            accountService.deleteAccountById(1L, deleteAccountRequest);
            Assert.assertEquals(1L, 1L);
            verify(accountRepository, times (1)).deleteById(1L);
//
//            Mockito.lenient().when(accountRepository.deleteById(1L)).thenReturn(null);
//
//            final Account expected = accountService.deleteAccountById(1L, deleteAccountRequest);
////
//            Assert.assertEquals(expected, account);
//            Mockito.verify(accountRepository, times(1)).deleteById(1L);

//        }
        }

    }

