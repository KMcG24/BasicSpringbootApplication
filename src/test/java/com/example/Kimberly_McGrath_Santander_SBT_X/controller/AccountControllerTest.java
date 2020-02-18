package com.example.Kimberly_McGrath_Santander_SBT_X.controller;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;



@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

//    @InjectMocksectMocks
//    private AccountController accountController;

    @Mock
    private AccountService accountService;

    @Mock
    private Account account;
    private Object List;

    @Test
    public void getAcctById_shouldReturnAccount() throws Exception {

        Account account = new Account();

        String accountId = "1";
        String lastName = "Jones";
        String phoneNumber = "07785746345";

        when(accountService.getAccountById(accountId)).thenReturn(account);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/account/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
    }

//    @Test
//    public void getAllAccts_shouldReturnAllAccounts() throws Exception {
//
//        final List<Account> accountList = (List<Account>
//        .getObjectList("api/account/accounts", Account.class));
//
//        final String response = "[{\"accounts\:\"accoundId"
//    }
//
//    @Test
//    public void updateAcctById_shouldUpdateAccount() throws Exception {
//
//        Account account = new Account();
//
//        String accountId = "1";
//        AccountRequest accountRequest = null;
//
//        when(accountService.updateAccountbyId(accountId, accountRequest)).thenReturn(account);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/account/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//    }
}
