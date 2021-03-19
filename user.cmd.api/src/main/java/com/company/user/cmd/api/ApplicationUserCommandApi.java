package com.company.user.cmd.api;

import com.company.user.core.configuration.ConfigurationAxon;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ConfigurationAxon.class})
public class ApplicationUserCommandApi {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationUserCommandApi.class, args);
	}

}
