/**
 * WeatherService.java
 * 13-Aug-2025
 */
package com.abimulia.ai.service;

import java.util.function.Function;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.abimulia.ai.function.WeatherConfigProperties;

import lombok.extern.slf4j.Slf4j;



/**
 * @author abimu
 *
 * @version 1.0 (13-Aug-2025)
 * @since 13-Aug-2025 9:04:00 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

/**
 * Service untuk memanggil WeatherAPI dan mengembalikan data cuaca.
 * Mengimplementasikan Function<Request, Response> agar bisa digunakan di ToolCallback.
 */
@Service
@Slf4j
public class WeatherService implements Function<WeatherService.Request, WeatherService.Response>{
	
	
	private final WebClient webClient;
	private final WeatherConfigProperties weatherProps;
	
	public WeatherService(WeatherConfigProperties props) {
		this.weatherProps = props;
		log.info("Weather API URL: {}", weatherProps.apiUrl());
        log.info("Weather API Key: {}", weatherProps.apiKey());
        this.webClient = WebClient.builder()
        		.baseUrl(weatherProps.apiUrl())
        		.build();
	}
	
	@Override
    public Response apply(Request weatherRequest) {
        log.info("Weather Request: {}",weatherRequest);
        Response response = webClient.get()
        		.uri(uriBuilder -> uriBuilder
                		.path("/current.json")
                        .queryParam("key", weatherProps.apiKey())
                        .queryParam("q", weatherRequest.city())
                        .build())
        		.accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Response.class)
                .doOnNext(r -> log.info("Weather API Response: {}", r))
                .block(); // HTTP non-blocking
        return response;
    }

	
	 	public record Request(String city) {}
	    public record Response(Location location,Current current) {}
	    public record Location(String name, String region, String country, Double lat, Double lon){}
	    public record Current(String temp_f, Condition condition, String wind_mph, String humidity) {}
	    public record Condition(String text){}

}
