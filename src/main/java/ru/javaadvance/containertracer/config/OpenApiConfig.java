package ru.javaadvance.containertracer.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info= @Info(
                title = "CNTR tracker API",
                description="API системы отслеживания контейнеров",
                version = "1.0",
                contact = @Contact(
                        name = "Владимир Манита",
                        email= "v.manita@bk.ru"
                )
        )
)
public class OpenApiConfig {

}
