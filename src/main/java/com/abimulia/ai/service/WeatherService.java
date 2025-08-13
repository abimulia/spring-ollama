/**
 * WeatherService.java
 * 13-Aug-2025
 */
package com.abimulia.ai.service;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClient;

import com.abimulia.ai.function.WeatherConfigProperties;

/**
 * @author abimu
 *
 * @version 1.0 (13-Aug-2025)
 * @since 13-Aug-2025 9:04:00 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */
public class WeatherService implements Function<WeatherService.Request, WeatherService.Response>{
	
	private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
	private final RestClient restClient;
	private final WeatherConfigProperties weatherProps;
	
	public WeatherService(WeatherConfigProperties props) {
		this.weatherProps = props;
		log.info("Weather API URL: {}", weatherProps.apiUrl());
        log.info("Weather API Key: {}", weatherProps.apiKey());
        this.restClient = RestClient.create(weatherProps.apiUrl());
	}
	
	@Override
    public Response apply(Request weatherRequest) {
        log.info("Weather Request: {}",weatherRequest);
        Response response = restClient.get()
                .uri("/current.json?key={key}&q={q}", weatherProps.apiKey(), weatherRequest.city())
                .retrieve()
                .body(Response.class);
        log.info("Weather API Response: {}", response);
        return response;
    }

	
	 public record Request(String city) {}
	    public record Response(Location location,Current current) {}
	    public record Location(String name, String region, String country, Long lat, Long lon){}
	    public record Current(String temp_f, Condition condition, String wind_mph, String humidity) {}
	    public record Condition(String text){}

}
