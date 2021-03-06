package com.example.Kimberly_McGrath_Santander_SBT_X.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;
import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="account_id", unique = true, nullable = false)
    private Long accountId;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phoneNumber;

//    public Account() {}

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId (Long accountId) {
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



    @Override
    public String toString() {
        return String.format(
                "Account[accountId='%s', lastName='%s', phoneNumber='%s']",
                accountId, lastName, phoneNumber);
    }

}