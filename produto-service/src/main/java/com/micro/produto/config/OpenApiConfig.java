package com.micro.produto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI produtoOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Produto Service API")
                        .description("API responsável pelo gerenciamento de produtos")
                        .version("v1.0.0"));
    }
}
