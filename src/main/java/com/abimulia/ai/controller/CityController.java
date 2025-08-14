/**
 * CityController.java
 * 13-Aug-2025
 */
package com.abimulia.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

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
@RequestMapping("/city")
@Slf4j
public class CityController {
	
	private final ChatClient chatClient;
	
	public CityController(ChatClient.Builder builder,ToolCallback currentWeatherTool ) {
		log.debug("CityController(): {}", builder, currentWeatherTool);
        this.chatClient = builder
                .defaultSystem("""
                		You are a helpful AI Assistant answering questions about cities around the world.
                        If the user asks about current weather in a city, call the tool 'currentWeatherFunction'
                        with the JSON shape: { "city": "<city name>" } and then summarize result nicely.
                		""")
                .defaultToolCallbacks(currentWeatherTool)
                .build();
    }
	
	@GetMapping("/ask")
	public String askCityQuestion(@RequestParam String message) {
		log.debug("askCityQuestion(): {} ", message);
		return chatClient.prompt()
				.user(message)
				.call()
				.content();
	}

}
