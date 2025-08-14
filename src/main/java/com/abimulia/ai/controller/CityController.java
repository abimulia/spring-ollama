/**
 * CityController.java
 * 13-Aug-2025
 */
package com.abimulia.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Function;
/**
 * @author abimu
 *
 * @version 1.0 (13-Aug-2025)
 * @since 13-Aug-2025 8:36:20 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

@RestController
public class CityController {
	
	private final ChatClient chatClient;
	
	public CityController(ChatClient.Builder builder,Function currentWeatherFunction ) {
        this.chatClient = builder
                .defaultSystem("You are a helpful AI Assistant answering questions about cities around the world.")
                .defaultFunctions(currentWeatherFunction)
                .build();
    }
	
	@GetMapping("/cities")
	public String cityFaq(@RequestParam String message) {
		return chatClient.prompt()
				.user(message)
				.call()
				.content();
	}

}
