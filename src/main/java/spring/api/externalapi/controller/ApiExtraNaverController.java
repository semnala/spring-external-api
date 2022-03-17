package spring.api.externalapi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.api.externalapi.controller.vo.NaverTranslateInputVO;
import spring.api.externalapi.properties.NaverApiProperties;
import spring.api.externalapi.support.RestApiConstants;

/**
 * 네이버 OPEN API 연동 컨트롤러
 * - 네이터 API 가이드 URL: https://developers.naver.com/docs/common/openapiguide/
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ApiExtraNaverController {

    private final NaverApiProperties naverApiProperties;

    @GetMapping("/api/extra/naver/translate")
    public String translate(@RequestBody NaverTranslateInputVO NaverTranslateInput){

        /**
         * POST 방식
         curl "https://openapi.naver.com/v1/papago/n2mt" \
         -H "Content-Type: application/x-www-form-urlencoded; charset=UTF-8" \
         -H "X-Naver-Client-Id: {REST API KEY}" \
         -H "X-Naver-Client-Secret: {REST_SECRET}" \
         -d "source=ko&target=en&text=만나서 반갑습니다." -v
         */

        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("source","kr");
        parameters.add("target","en");
        parameters.add("text", NaverTranslateInput.getText());

        log.info("text ={}", NaverTranslateInput.getText());

        HttpHeaders headers = new HttpHeaders();
        //headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.add("X-Naver-Client-Id", naverApiProperties.getClientId());
        headers.add("X-Naver-Client-Secret", naverApiProperties.getClientSecret());

        HttpEntity formEntity = new HttpEntity<>(parameters, headers);
        ResponseEntity<String> result = restTemplate.postForEntity(RestApiConstants.Naver.TRANSTLATE_URL, formEntity, String.class);

        return result.getBody();
    }
}
