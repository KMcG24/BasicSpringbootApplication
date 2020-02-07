package com.example.Kimberly_McGrath_Santander_SBT_X.model;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AccountRequest {

    @NotNull
    @NotBlank
    private String accountId;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    private String phoneNumber;

}
