package com.example.turkishsite;

import com.example.turkishsite.objects.Oceanarium;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TurkishSiteApplication {

    @Bean
    public Oceanarium getOceanarium() {
        Oceanarium oceanarium = new Oceanarium();
        oceanarium.addFish("Немо", "Кит", "Касатка", "Акула тигровая");
        return oceanarium;
    }

    public static void main(String[] args) {
        SpringApplication.run(TurkishSiteApplication.class, args);
    }

}
