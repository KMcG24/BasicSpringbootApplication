package com.example.Kimberly_McGrath_Santander_SBT_X.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="accounts")
public class Account {
    @Id
    @JsonProperty("accountId")
    private String accountId;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    protected Account() {}

    @Override
    public String toString() {
        return String.format(
                "Account[accountId='%s', lastName='%s', phoneNumber='%s']",
                accountId, lastName, phoneNumber);
    }

}