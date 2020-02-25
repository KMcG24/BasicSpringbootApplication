package com.example.Kimberly_McGrath_Santander_SBT_X.model;


import lombok.Data;

@Data
public class AccountRequest {

    private String accountId;

    private String lastName;

    private String phoneNumber;

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
