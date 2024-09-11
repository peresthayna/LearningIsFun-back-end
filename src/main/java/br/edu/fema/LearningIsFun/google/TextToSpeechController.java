package br.edu.fema.LearningIsFun.google;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/texttospeech")
public class TextToSpeechController {
    @Autowired
    private TextToSpeechService textToSpeechService;

    @PostMapping()
    public ResponseEntity<Map> synthesizeSpeech(@RequestBody TextToSpeechRequest request) {
        return textToSpeechService.synthesizeSpeech(request.getText(), request.getLanguage());
    }
}

@Getter
class TextToSpeechRequest {
    private String text;
    private String language;
}
