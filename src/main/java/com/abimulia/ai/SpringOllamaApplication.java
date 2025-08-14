package com.abimulia.ai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = "com.abimulia.ai")

public class SpringOllamaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOllamaApplication.class, args);
	}

}