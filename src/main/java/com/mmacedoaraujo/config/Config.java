package com.mmacedoaraujo.config;

import com.mmacedoaraujo.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final DbService dbService;

    @Bean
    public boolean instantiateMethod(String... args) throws Exception {
        dbService.populateDatabaseMethod();
        return true;
    }
}
