package org.example.preproject222.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "loan")
public class LoanProperties {

    private int minRevenue;

    private int minCarValue;

    public int getMinCarValue() {
        return minCarValue;
    }

    public void setMinCarValue(int minCarValue) {
        this.minCarValue = minCarValue;
    }

    public int getMinRevenue() {
        return minRevenue;
    }

    public void setMinRevenue(int minRevenue) {
        this.minRevenue = minRevenue;
    }
}
