package org.example.preproject222.integration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class IncomeClient {


    private final RestTemplate restTemplate;

    @Autowired
    public IncomeClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<IncomeDTO> getAllUsersIncome() {
        String url = "https://66055cd12ca9478ea1801f2e.mockapi.io/api/users/income";
        ResponseEntity<List<IncomeDTO>> response = restTemplate.
                exchange(url,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<>() {
                        });
        return response.getBody();
    }

    public IncomeDTO getUserIncome(Long id) {
        return getAllUsersIncome().stream().filter(incomeDTO -> incomeDTO.getId().equals(id)).findFirst().orElse(new IncomeDTO(-1L, 0));

    }


}
