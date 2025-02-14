package org.example.preproject222.controllers;


import jakarta.annotation.Nullable;
import org.example.preproject222.entities.Car;
import org.example.preproject222.exceptions.UnsupportedSortByException;
import org.example.preproject222.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    CarService carService;

    @Value("${cars.sort.allowed}")
    List<String> allowedSorts;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String showCars(@RequestParam(name = "count", required = false) Integer count,
                           @RequestParam(name = "sortBy", required = false) List<String> sortBy,
                           Model model) {

        validateSortBy(sortBy);


        List<Car> cars = carService.getSpecifiedCarsAmount(count, sortBy);
        model.addAttribute("cars", cars);

        return "car";
    }


    private void validateSortBy(List<String> sortBy) {
        List<String> unsupportedSorts = new ArrayList<>();
        for (String sortByName : sortBy) {
            if (!allowedSorts.contains(sortByName)) {
                unsupportedSorts.add(sortByName);
            }
        }
        if (!unsupportedSorts.isEmpty()) {
            throw new UnsupportedSortByException("Unsupported SortBy was used", unsupportedSorts);
        }
    }


}
