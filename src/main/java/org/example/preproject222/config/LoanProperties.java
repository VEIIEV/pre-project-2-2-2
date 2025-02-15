package org.example.preproject222.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "loan")
public class LoanProperties {

    private int minRevenue;

    private int minCarValue;

}
