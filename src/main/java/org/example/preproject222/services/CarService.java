package org.example.preproject222.services;

import org.example.preproject222.daos.CarDao;
import org.example.preproject222.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarDao carDao;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }


    public List<Car> getSpecifiedCarsAmount(Integer amount, String[] sortBy) {
        return carDao.getSpecifiedCarAmount(amount, sortBy);
    }
}
