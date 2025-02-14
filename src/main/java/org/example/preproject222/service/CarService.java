package org.example.preproject222.service;

import org.example.preproject222.dao.CarDao;
import org.example.preproject222.entitie.Car;
import org.example.preproject222.exception.UnsupportedSortByException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarDao carDao;

    @Value("${cars.sort.allowed}")
    private List<String> allowedSorts;

    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }


    public List<Car> getSpecifiedCarsAmount(Integer amount, List<String> sortBy) {
        if (sortBy != null) {
            validateSortBy(sortBy);
        }

        return carDao.getSpecifiedCarAmount(amount, sortBy);
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
