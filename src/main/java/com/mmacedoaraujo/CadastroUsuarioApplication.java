package com.mmacedoaraujo;

import com.mmacedoaraujo.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class CadastroUsuarioApplication {
    public static void main(String[] args) {
        SpringApplication.run(CadastroUsuarioApplication.class, args);
    }
}