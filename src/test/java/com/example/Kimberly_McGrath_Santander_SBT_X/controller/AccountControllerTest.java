package com.example.Kimberly_McGrath_Santander_SBT_X.controller;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.DeleteAccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import com.example.Kimberly_McGrath_Santander_SBT_X.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
//import import com.santanderuk.levelup.unitTests.utils.TestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.hamcrest.Matchers.*;


@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private RestTemplate restTemplate;

    @Mock
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private Account account;
    private DeleteAccountRequest deleteAccountRequest;
    private List accountList;

    @InjectMocks
    private AccountController accountController;

    @Mock
    List<String> mockedAccountList;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).setControllerAdvice(new Exception()).build();
    }

    @Test
    public void getAcctById_shouldReturnAccount() throws Exception {

        Account account = new Account();

        String url = "http://localhost:8090/api/account/1";

        when(accountService.getAccountById(1L)).thenReturn(account);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(url)
                .accept(MediaType.parseMediaType("application/json")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void getAllAccts_shouldReturnAllAccounts() throws Exception {

        String url = "http://localhost:8090/api/account";

        List accountList = new ArrayList();

        Mockito.doReturn(accountList).when(accountService).getAccounts();

        this.mockMvc.perform(
                MockMvcRequestBuilders.get(url)
                        .accept(MediaType.parseMediaType("application/json")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }

    @Test
    public void updateAcctById_shouldUpdateAccount() throws Exception {

        String url = "http://localhost:8090/api/account/update/1";

        Account account = new Account();
        //mimic object in postman
        account.setAccountId(1L);
        account.setLastName("Smith");
        account.setPhoneNumber("07943437564");

        Account updatedAccount = new Account();
        updatedAccount.setAccountId(1L);
        updatedAccount.setLastName("Jones");
        updatedAccount.setPhoneNumber("33048039");
        System.out.println(updatedAccount);

          when(accountService.getAccountById(1L)).thenReturn(updatedAccount);

        this.mockMvc.perform(
                MockMvcRequestBuilders.patch(url)
                        .accept(MediaType.parseMediaType("application/json"))
        .contentType(MediaType.APPLICATION_JSON)
        .content(String.valueOf(account)))
                //convert to string and pass mimicked object
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
    }



    @Test
    public void whenDeleteAllById_ShouldDeleteAccount() throws Exception{

        String url = "http://localhost:8090/api/account/delete/1";

//        DeleteAccountRequest deleteAccountRequest = new DeleteAccountRequest();
        this.mockMvc.perform(MockMvcRequestBuilders
        .delete(url)
        .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        mockMvc.perform(
                MockMvcRequestBuilders.delete(url)
                .accept(MediaType.parseMediaType("application/json")))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        Mockito.verify(accountService, times(1)).deleteAccountById(1L, deleteAccountRequest);
    }
}

