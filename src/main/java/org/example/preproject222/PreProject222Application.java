package org.example.preproject222;

import org.example.incomespringbootstarter.integration.IncomeClientAutoConfiguration;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@Import(IncomeClientAutoConfiguration.class)
@SpringBootApplication
public class PreProject222Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(PreProject222Application.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        ConfigurableApplicationContext context = springApplication.run(args);
        System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
    }
}
