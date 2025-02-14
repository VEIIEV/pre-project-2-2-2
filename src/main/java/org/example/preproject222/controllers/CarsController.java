package org.example.preproject222.controllers;


import jakarta.annotation.Nullable;
import org.example.preproject222.entities.Car;
import org.example.preproject222.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping()
    public String showCars(@RequestParam(name = "count", required = false) Integer count,
                           @RequestParam(name = "sortBy", required = false) String[] sortBy,
                           Model model) {
        List<Car> cars = carService.getSpecifiedCarsAmount(count, sortBy);
        model.addAttribute("cars", cars);
        return "car";
    }


}
