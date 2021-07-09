package ru.testassignment.vehicleservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public ObjectMapper jacksonObjectMapper() {
    return new ObjectMapper().setPropertyNamingStrategy(new SnakeCaseStrategy());
  }
}
