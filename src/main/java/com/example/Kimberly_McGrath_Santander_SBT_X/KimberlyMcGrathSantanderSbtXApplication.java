package com.example.Kimberly_McGrath_Santander_SBT_X;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class KimberlyMcGrathSantanderSbtXApplication {

	public static void main(String[] args) {
		SpringApplication.run(KimberlyMcGrathSantanderSbtXApplication.class, args);
	}

}
