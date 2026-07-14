package com.devops.springboot_app.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productionDevOpsAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Production DevOps Pipeline API")

                        .description(
                                "Enterprise Employee Management API built with Spring Boot, Docker, Jenkins, SonarQube and Trivy."
                        )

                        .version("2.0.0")

                        .contact(
                                new Contact()
                                        .name("Dandu Rama Siva Naga Raju")
                                        .email("dramarajudramaraju59@gmail.com")
                                        .url("https://github.com/Nagaraju-209")
                        )

                        .license(
                                new License()
                                        .name("MIT")
                        ))

                .externalDocs(
                        new ExternalDocumentation()
                                .description("GitHub Repository")
                                .url("https://github.com/Nagaraju-209/production-devops-pipeline")
                );
    }
}