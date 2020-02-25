package com.example.Kimberly_McGrath_Santander_SBT_X.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class AccountRequest {

    @Id
    private String accountId;

    private String lastName;

    private String phoneNumber;

    public AccountRequest (String accountId, String lastName, String phoneNumber) {

    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId (String accountId) {
        this.accountId = accountId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
