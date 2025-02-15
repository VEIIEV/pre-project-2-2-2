package org.example.preproject222.controller;


import org.example.preproject222.entity.Car;
import org.example.preproject222.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String showCars(@RequestParam(name = "count", required = false) Integer count,
                           @RequestParam(name = "sortBy", required = false) List<String> sortBy,
                           Model model) {
        List<Car> cars = carService.getSpecifiedCarsAmount(count, sortBy);
        model.addAttribute("cars", cars);

        return "car";
    }


}
