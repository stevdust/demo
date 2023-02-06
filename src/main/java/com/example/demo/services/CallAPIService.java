package com.example.demo.services;

import java.net.URI;
import java.util.Optional;

import com.example.demo.utils.CallAPIConstants;
import com.example.demo.utils.Encrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.external.CountResult;
import com.example.demo.external.MockarooResponse;
import com.example.demo.external.ResponseAPI;



@Service
public class CallAPIService {

    private Encrypter encrypter;

    @Autowired
    public CallAPIService(Encrypter encrypter) {
        this.encrypter = encrypter;
    }
    
    public Optional<ResponseAPI> reviewAPI(String param) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            //Punto B-b de la prueba tecnica
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set(CallAPIConstants.X_API_KEY_HEADER_NAME, CallAPIConstants.X_API_KEY_HEADER_VALUE);
            HttpEntity<String> entity = new HttpEntity<>(null, headers);

            String encryptedRut = encrypter.encrypt(param);

            URI uri = new URI(CallAPIConstants.MOCKAROO_CALL_URL + encryptedRut);
            long startTime = System.currentTimeMillis();
            ResponseEntity<MockarooResponse> response = restTemplate
                    .exchange(uri, HttpMethod.GET, entity, MockarooResponse.class);
            
            //Punto C de la prueba tecnica
            long totalCallTime = (System.currentTimeMillis() - startTime);
            return Optional.of(
                    ResponseAPI.builder()
                            .responseCode(0)
                            .result(CountResult
                                    .builder()
                                    .registerCount(
                                            response.getBody().getResult().getItems().size()
                                    )
                                    .build()
                            )
                            .description("OK")
                            .elapsedTime(totalCallTime)
                            .build()
            );

        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
