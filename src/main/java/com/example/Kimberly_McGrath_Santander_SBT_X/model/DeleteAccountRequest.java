package com.example.Kimberly_McGrath_Santander_SBT_X.model;


import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="account")
public class DeleteAccountRequest {

    @Id
    private Long accountId;

}
