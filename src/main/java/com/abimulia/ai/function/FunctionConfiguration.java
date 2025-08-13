/**
 * FunctionConfiguration.java
 * 13-Aug-2025
 */
package com.abimulia.ai.function;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import com.abimulia.ai.service.WeatherService;

/**
 * @author abimu
 *
 * @version 1.0 (13-Aug-2025)
 * @since 13-Aug-2025 8:56:54 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

@Configuration
public class FunctionConfiguration {
	
	private final WeatherConfigProperties props;

    public FunctionConfiguration(WeatherConfigProperties props) {
        this.props = props;
    }

    @Bean
    @Description("Get the current weather conditions for the given city.")
    public Function<WeatherService.Request,WeatherService.Response> currentWeatherFunction() {
        return new WeatherService(props);
    }
	
	

}
