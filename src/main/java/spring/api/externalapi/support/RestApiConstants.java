package spring.api.externalapi.support;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 서비스별 API 설정 정보(API key, Secret, URl 등)
 * - spring boot 설정파일(application.yml)에 등록된 값을 참조한다.
 */
@Component
public class RestApiConstants {

    public static String naverKey;

    public static String kakaoKey;

    public static String googleKey;

    @Value("${api.client-key.naver}")
    public void setNaverKey(String value){
        naverKey = value;
    }

    @Value("${api.client-key.kakao}")
    public void setKakaoKey(String value){
        kakaoKey = value;
    }

    @Value("${api.client-key.google}")
    public void setGoogleKey(String value){
        googleKey = value;
    }

    public class PublicData {
        public static final String API_KEY = "uX9VqD%2BmefSNvnEiQxapBGyBNIc4OlH6TfRgvC7W2D7ziZCd4Rv8kaqzOtCnpxaMZ8yxDU2ENUDBKEEHjNFZ%2FA%3D%3D";

        public static final String BASE_URL = "http://apis.data.go.kr";
    }

    public class Naver {
        public static final String SECRET_CODE = "o4Ji18D03t";

        public static final String TRANSTLATE_URL = "https://openapi.naver.com/v1/papago/n2mt";
    }

    public class Kakao {
        public static final String SECRET_CODE = "";

        public static final String TRANSTLATE_URL = "https://dapi.kakao.com/v2/translation/translate";
    }

    public class Google {
        public static final String SECRET_CODE = "";

        public static final String TRANSTLATE_URL = "";
    }

}
