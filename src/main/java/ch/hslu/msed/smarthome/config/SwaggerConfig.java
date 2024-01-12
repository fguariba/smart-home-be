package ch.hslu.msed.smarthome.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Smart Home Service API",
        version = "1.0.0",
        description = "Service for accessing Smart Home Backend",
        termsOfService = "http://swagger.io/terms/",
        license = @License(
                url = "http://springdoc.org",
                name = "Apache 2.0"
        )
))
public class SwaggerConfig {

}