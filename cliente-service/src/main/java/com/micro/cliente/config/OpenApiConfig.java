package com.micro.cliente.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI clienteOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Cliente Service API")
                        .description("API responsável pelo gerenciamento de clientes")
                        .version("v1.0.0"));
    }
}
