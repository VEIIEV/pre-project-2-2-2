package org.example.preproject222.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "cars")
public class CarProperties {

    private Limiter limiter;
    private Sort sort;

    public Limiter getLimiter() {
        return limiter;
    }

    public void setLimiter(Limiter limiter) {
        this.limiter = limiter;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    public static class Limiter {
        private int maxValue;

        public int getMaxValue() {
            return maxValue;
        }

        public void setMaxValue(int maxValue) {
            this.maxValue = maxValue;
        }
    }

    public static class Sort {
        private List<String> allowed;

        public List<String> getAllowed() {
            return allowed;
        }

        public void setAllowed(List<String> allowed) {
            this.allowed = allowed;
        }
    }
}
