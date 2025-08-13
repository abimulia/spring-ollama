/**
 * ChatController.java
 * 13-Aug-2025
 */
package com.abimulia.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author abimu
 *
 * @version 1.0 (13-Aug-2025)
 * @since 13-Aug-2025 8:24:52 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

@RestController
public class ChatController {
	
	private final ChatClient chatClient;
	

	public ChatController(ChatClient.Builder chatClient) {
		this.chatClient = chatClient.build();
	}
	
	@GetMapping("")
	public String joke() {
		return chatClient.prompt()
				.user("Please tell me a dad joke about computers")
				.call()
				.content();
	}

}
