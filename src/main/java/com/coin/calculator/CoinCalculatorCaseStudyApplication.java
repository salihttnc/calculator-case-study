package com.coin.calculator;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Currency API", version = "1.0", description = "Currency API Information"))
@EnableJpaAuditing
@EnableJpaRepositories
public class CoinCalculatorCaseStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinCalculatorCaseStudyApplication.class, args);
	}

}
