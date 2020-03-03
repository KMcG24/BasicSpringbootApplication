package com.example.Kimberly_McGrath_Santander_SBT_X.controller;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import com.example.Kimberly_McGrath_Santander_SBT_X.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import import com.santanderuk.levelup.unitTests.utils.TestUtils;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private Account account;
    private List accountList;

    @InjectMocks
    private AccountController accountController;

//    @Spy
//    private List<Object> accountList = new List<>();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

//    @Test
//    public void getAcctById_shouldReturnAccount() throws Exception {
//
//    Mockito.when(accountService.getAccountById(accountId)).thenReturn(1l);
//    assertEquals(accountId, getAcctById);


//        this.mockMvc.perform(accountService.getAccountById(accountId).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString())));

//        Account account = new Account();
//
//        Long accountId = 1l;

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
////
//    @Test
//    public void updateAcctById_shouldUpdateAccount() throws Exception {
//
//        Account account = new Account();
//
//        long accountId = 1;
//
//        when(accountService.updateAccountbyId(accountId)).thenReturn(account);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/account/update/1")
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
