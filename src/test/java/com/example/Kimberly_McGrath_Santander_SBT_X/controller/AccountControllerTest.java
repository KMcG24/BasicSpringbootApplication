package com.example.Kimberly_McGrath_Santander_SBT_X.controller;

import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.AccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.model.DeleteAccountRequest;
import com.example.Kimberly_McGrath_Santander_SBT_X.repository.AccountRepository;
import com.example.Kimberly_McGrath_Santander_SBT_X.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
//import import com.santanderuk.levelup.unitTests.utils.TestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON;

import static org.hamcrest.MatcherAssert.assertThat;
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

//    @Test
//    public void updateAcctById_shouldUpdateAccount() throws Exception {
//
//        String url = "http://localhost:8090/api/account/update/1";
//
//        Account account = new Account();
//        //mimic object in postman
//        account.setLastName("Smith");
//        account.setPhoneNumber("07943437564");
//
//        Account updatedAccount = new Account();
//        updatedAccount.setAccountId(1L);
//        updatedAccount.setLastName("Jones");
//        updatedAccount.setPhoneNumber("33048039");
//        System.out.println(updatedAccount);
//
////        Mockito.doReturn(updatedAccount).when(accountService).getAccountById(1L);
//
//          when(accountService.getAccountById(1L)).thenReturn(updatedAccount);
//      //  when(accountService.updateAccountbyId(1L, account)).thenReturn(updatedAccount);
//
//        this.mockMvc.perform(
//                MockMvcRequestBuilders.patch(url)
//                        .accept(MediaType.parseMediaType("application/json"))
//        .contentType(MediaType.APPLICATION_JSON)
//        .content())
//                //convert to string and pass mimicked object
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
//    }


//    @Test
//    public void whenDeleteAllById_ShouldDeleteAccount() throws Exception{
//
//        String url = "http://localhost:8090/api/account/delete/1";
//
//        Account account = new Account();
//        DeleteAccountRequest deleteAccountRequest = new DeleteAccountRequest()
//                .getAsObject(url, DeleteAccountRequest.class);
//
//        when(accountService.deleteAccountById(1L, DeleteAccountRequest)).thenReturn(DeleteAccountRequest);
//
//        mockMvc.perform(
//                MockMvcRequestBuilders.delete(url)
//                .accept(MediaType.parseMediaType("application/json")))
//                .andDo(print())
//                .andExpect(MockMvcResultMatchers.status().isNoContent());

//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isNoContent());
               // .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)); //is this necessary as it is a no content return?

      //  accountRepository.deleteById(accountId);
//    }
}
