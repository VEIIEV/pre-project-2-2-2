package org.services;

import org.daos.CarDao;
import org.entities.Car;
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


    public List<Car> getSpecifiedCarsAmount(int n) {
        return carDao.find
    }
}
