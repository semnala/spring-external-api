package spring.api.externalapi.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("kakao-api")
public class KakaoApiProperties {
    private String clientId;
    private String clientSecret;
}
