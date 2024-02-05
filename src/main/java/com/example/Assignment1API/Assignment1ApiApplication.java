package com.example.Assignment1API;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Assignment1ApiApplication {

    public static void main(String[] args) {
	SpringApplication.run(Assignment1ApiApplication.class, args);
        getKanyeQuote();
        System.exit(0);
	}
        
    /**
     * Get a random dog fact and print to console
     */
    public static void getKanyeQuote() {
        try {
            String url = "https://api.kanye.rest";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            String quote = root.findValue("quote").asText();

            System.out.println("**********KANYE WEST QUOTE********");
            System.out.println("Quote: " + quote);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Assignment1ApiApplication.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getKanyeQuote");

        }
    }

}
