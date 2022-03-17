package spring.api.externalapi.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("google-api")
public class GoogleApiProperties {
    private String clientId;
    private String clientSecret;
}
