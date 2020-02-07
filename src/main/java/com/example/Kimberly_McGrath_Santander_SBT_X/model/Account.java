package com.example.Kimberly_McGrath_Santander_SBT_X.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Id
    @Column(name="account_id")
    private String accountId;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone_number")
    private String phoneNumber;

//    public Account() {}

    @Override
    public String toString() {
        return String.format(
                "Account[accountId='%s', lastName='%s', phoneNumber='%s']",
                accountId, lastName, phoneNumber);
    }

}