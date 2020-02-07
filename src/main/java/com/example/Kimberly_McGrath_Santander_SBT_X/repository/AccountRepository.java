package com.example.Kimberly_McGrath_Santander_SBT_X.repository;


import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountRepository extends CrudRepository<Account, String > {
    //don't have to write sql query string or any methods for findById because CrudRepository already contains the logic
    //don't need an implementation class

}






