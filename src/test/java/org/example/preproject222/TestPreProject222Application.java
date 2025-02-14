package org.example.preproject222;

import org.springframework.boot.SpringApplication;

public class TestPreProject222Application {

    public static void main(String[] args) {
        SpringApplication.from(PreProject222Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
