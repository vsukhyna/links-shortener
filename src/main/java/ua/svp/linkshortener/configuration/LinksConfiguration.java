package ua.svp.linkshortener.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.Queue;

@Configuration
public class LinksConfiguration {

    private static String base = "abcd123";

    private Queue<String> result = new LinkedList<>();

    @Bean
    Queue<String> linksQueue() {
        initBase();
        return result;
    }

    private void initBase() {

        for (int a = 0; a < base.length(); a++) {
            for (int b = 0; b < base.length(); b++) {
                for (int c = 0; c < base.length(); c++) {
                    result.add(String.valueOf(base.charAt(a)) + base.charAt(b) + base.charAt(c));
                }
            }
        }
    }
}
