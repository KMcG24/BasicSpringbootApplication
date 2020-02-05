package com.example.Kimberly_McGrath_Santander_SBT_X.repository;


import com.example.Kimberly_McGrath_Santander_SBT_X.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
@EnableJpaRepositories
public class AccountRepository {

    //JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/accounts";

    //Database credentials
    static final String USER = "sa";
    static final String PASS = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountRepository.class);

    //    @Override
    public Account getAccountById(final String accountId) {

        Connection conn = null;
        Statement stmt = null;

        try {

            //STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            System.out.println("Connected to database successfully");
            stmt = conn.createStatement();
            String sql = "SELECT id, last_name, phone_number FROM accounts";
            ResultSet rs = stmt.executeQuery(sql);

            //Step 4: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                String id = rs.getString("accountId");
                String last_name = rs.getString("lastName");
                String phone_number = rs.getString("phoneNumber");
            }

            //STEP 5: Clean-up environment
            rs.close();
        } catch (SQLException se) {
            //Handle errors fro JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } //nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        } //end try
    }
}






