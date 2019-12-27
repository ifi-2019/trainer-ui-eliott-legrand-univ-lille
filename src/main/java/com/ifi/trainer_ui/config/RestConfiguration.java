package com.ifi.trainer_ui.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {
    @Value("${trainer.service.username}")
    private String username;

    @Value("${trainer.service.password}")
    private String password;


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RestTemplate trainerApiRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        BasicAuthenticationInterceptor interceptor = new BasicAuthenticationInterceptor(username,password);
        restTemplate.getInterceptors().add(interceptor);
        return restTemplate;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
