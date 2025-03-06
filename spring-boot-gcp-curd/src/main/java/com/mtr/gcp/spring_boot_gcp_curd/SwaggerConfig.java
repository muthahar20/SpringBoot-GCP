package com.mtr.gcp.spring_boot_gcp_curd;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Swagger Example")
                        .version("1.0")
                        .description("API documentation for Spring Boot Application")
                        .contact(new Contact()
                                .name("Muthahar Shaik")
                                .email("muthahar20@gmail.com")
                        )
                );
    }
}
