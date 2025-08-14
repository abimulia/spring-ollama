/**
 * WeatherConfigProperties.java
 * 13-Aug-2025
 */
package com.abimulia.ai.function;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author abimu
 *
 * @version 1.0 (13-Aug-2025)
 * @since 13-Aug-2025 8:58:10 PM
 * 
 * 
 * Copyright(c) 2025 Abi Mulia
 */

/**
 * Membaca konfigurasi prefix "weather" dari application.properties.
 * Contoh:
 * weather.api-key=...
 * weather.api-url=...
 */
@ConfigurationProperties(prefix="weather")
public record WeatherConfigProperties(String apiKey,String apiUrl) {

}
