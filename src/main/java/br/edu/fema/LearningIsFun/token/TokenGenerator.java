package br.edu.fema.LearningIsFun.token;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Service
public class TokenGenerator {
    private static String currentToken = "";

    @Scheduled(fixedRate = 3599999)
    public void generateToken() {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("C:/Users/tppte/AppData/Local/Google/Cloud SDK/google-cloud-sdk/bin/gcloud.cmd", "auth", "print-access-token");
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            currentToken = reader.readLine();
            System.out.println("Current token: " + currentToken);
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getCurrentToken() {
        return currentToken;
    }

}
