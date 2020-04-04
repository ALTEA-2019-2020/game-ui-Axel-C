package com.miage.altea.game_ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestConfiguration {

    @Value("${spring.security.user.name}")
    private String username;

    @Value("${spring.security.user.password}")
    private String password;

    void setUsername(String username) {
        this.username = username;
    }

    void setPassword(String password) {
        this.password = password;
    }

    @Bean
    RestTemplate trainerApiRestTemplate() {
        ClientHttpRequestInterceptor clientHttpRequestInterceptor = new BasicAuthenticationInterceptor(username, password);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(clientHttpRequestInterceptor));
        return restTemplate;
    }

    @Bean
    RestTemplate pokemonTypeApiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(
                Collections.singletonList(
                        (httpRequest, bytes, clientHttpRequestExecution) -> {
                            HttpHeaders headers = httpRequest.getHeaders();
                            headers.setAcceptLanguageAsLocales(Collections.singletonList(LocaleContextHolder.getLocale()));
                            return clientHttpRequestExecution.execute(httpRequest, bytes);
                        })
        );
        return restTemplate;
    }
}