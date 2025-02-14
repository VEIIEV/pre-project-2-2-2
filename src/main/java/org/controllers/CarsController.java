package org.controllers;


import org.entities.Car;
import org.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarsController {

    CarService carService;

    @Autowired
    public CarsController(CarService carService){
        this.carService = carService;
    }

    @GetMapping()
    public String showCars(Car car, Model model){
        return "";
    }


}
