package com.example.Kimberly_McGrath_Santander_SBT_X.controller;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.DeleteAccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import com.example.Kimberly_McGrath_Santander_SBT_X.service.AccountService;
import org.hibernate.sql.Delete;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.TestAnnotationUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import import com.santanderuk.levelup.unitTests.utils.TestUtils;

import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;


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
    private AccountRepository accountRepository;

    @Mock
    private Account account;
    private List accountList;

//    @Spy
//    private List<Object> accountList = new List<>();
//
//    @Test
//    public void getAcctById_shouldReturnAccount() throws Exception {
//
//        Account account = new Account();
//
//        Long accountId = 1l;
//        String lastName = "Jones";
//        String phoneNumber = "07785746345";

//        when(accountService.getAccountById(accountId)).thenReturn(account);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/account/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void getAllAccts_shouldReturnAllAccounts() throws Exception {
//
//        List accountList = Mockito.mock(List.class);
//
//        when(accountService.getAccounts().thenReturn(accountList));
//
//        MockMvc.perform(
//        .contentTypeMedia(APPLICATION_JSON)
//                .accept("application/json")
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//
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
//        when(accountService.updateAccountbyId(accountId)).thenReturn(account);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/account/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//    }
//
//    @Test
//    public void whenDeleteAllById_ShouldDeleteAccount(String accountId) {
//        accountRepository.deleteById(accountId);
//    }
}
