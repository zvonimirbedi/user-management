package com.company.user.query.api;

import com.company.user.core.configuration.ConfigurationAxon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ConfigurationAxon.class})
public class ApplicationUserQueryApi {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationUserQueryApi.class, args);
	}

}
