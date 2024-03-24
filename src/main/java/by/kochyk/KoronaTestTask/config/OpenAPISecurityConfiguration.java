package by.kochyk.KoronaTestTask.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "KORONA TEAM TEST API",
                version = "1.0"
        )
)
public class OpenAPISecurityConfiguration {

    @Bean
    public OpenAPI myAPI() {
        return new OpenAPI();
    }

}
