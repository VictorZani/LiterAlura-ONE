package com.literalura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // Já inclui o ComponentScan automaticamente
public class LiteraluraApplication {
    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }
}
