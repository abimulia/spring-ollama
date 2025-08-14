/**
 * CurrentWeatherFunction.java
 * 13-Aug-2025
 */
package com.abimulia.ai.function;

import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.function.FunctionToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abimulia.ai.service.WeatherService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author abimu
 *
 * @version 1.0 (13-Aug-2025)
 * @since 13-Aug-2025 10:19:45 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

/**
 * Konfigurasi ToolCallback untuk Spring AI.
 * Tool ini akan dipanggil otomatis jika AI mendeteksi perlu data cuaca.
 */
@Configuration
@Slf4j
public class CurrentWeatherToolConfig {
	@Bean
	public ToolCallback currentWeatherTool(WeatherService service) {
		log.debug("currentWeatherTool(): {} ", service);
		return FunctionToolCallback.builder("currentWeatherFunction", service)
				.description("Get current weather information for a given city")
				.inputType(WeatherService.Request.class)
				.build();
	}
}