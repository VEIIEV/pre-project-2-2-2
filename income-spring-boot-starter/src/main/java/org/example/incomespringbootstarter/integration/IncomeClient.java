package org.example.incomespringbootstarter.integration;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class IncomeClient {

    @Value("${income.url}")
    private String URL;
    private final RestTemplate restTemplate;

    @Autowired
    public IncomeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<IncomeDTO> getAllUsersIncome() {

        ResponseEntity<List<IncomeDTO>> response = restTemplate.
                exchange(URL,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        });
        return response.getBody();
    }

    public IncomeDTO getUserIncome(Long id) {
        return getAllUsersIncome()
                .stream()
                .filter(incomeDTO -> incomeDTO
                        .getId()
                        .equals(id))
                .findFirst()
                .orElse(new IncomeDTO(-1L, 0));
    }

    @PostConstruct
    public void init() {
        System.out.println("IncomeClient init...");
    }

}
