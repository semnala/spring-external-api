package spring.api.externalapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.api.externalapi.support.RestApiConstants;

import java.net.URI;
import java.util.Collections;

/**
 * 공공데이터 포털 OPEN API 연동 컨트롤러
 * - 공공데이터 API URL: https://www.data.go.kr
 */
@Slf4j
@RestController
public class ApiExtraPublicController {

    /**
     * 전국 약국목록 데이터 수집하는 API
     */
    @GetMapping("/api/extra/pharmacy")
    public String pharmacy(){

        String url = "%s/B552657/ErmctInsttInfoInqireService/getParmacyFullDown?serviceKey=%s";

        String apiResult = "";

        try {
            URI uri = new URI(String.format(url, RestApiConstants.PublicData.BASE_URL, RestApiConstants.PublicData.API_KEY));
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            String result = restTemplate.getForObject(uri, String.class);

            apiResult = result;

        } catch (Exception e){

        } finally {
            return apiResult;
        }
    }
}
