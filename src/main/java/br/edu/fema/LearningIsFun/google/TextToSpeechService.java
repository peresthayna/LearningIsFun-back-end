package br.edu.fema.LearningIsFun.google;

import br.edu.fema.LearningIsFun.token.TokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class TextToSpeechService {
    @Autowired
    TokenGenerator tokenGenerator;

    private final String apiUrl = "https://texttospeech.googleapis.com/v1/text:synthesize";

    public ResponseEntity<Map> synthesizeSpeech(String text, String language) {
        String token = this.tokenGenerator.getCurrentToken();
        String languageCode = "";
        String languageName = "";
        switch (language) {
            case "pt-br": {
                languageCode = "pt-BR";
                languageName = "pt-BR-Standard-C";
                break;
            } case "en-us": {
                languageCode = "en-US";
                languageName = "en-US-Standard-C";
                break;
            } case "es-es": {
                languageCode = "es-ES";
                languageName = "es-ES-Standard-C";
                break;
            } default: {
                languageCode = "pt-BR";
                languageName = "pt-BR-Standard-C";
            }
        }
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        headers.set("Content-Type", "application/json");

        Map<String, Object> body = new HashMap<>();
        body.put("input", Map.of("text", text));
        body.put("voice", Map.of("languageCode", languageCode, "name", languageName, "ssmlGender", "FEMALE"));
        body.put("audioConfig", Map.of("audioEncoding", "MP3"));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        return restTemplate.exchange(apiUrl, HttpMethod.POST, entity, Map.class);
    }


}
