package org.example.preproject222.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "cars")
public class CarProperties {

    private Limiter limiter;

    private Sort sort;

    @Setter
    @Getter
    public static class Limiter {
        private int maxValue;

    }

    @Setter
    @Getter
    public static class Sort {
        private List<String> allowed;

    }
}
