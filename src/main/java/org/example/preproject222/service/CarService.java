package org.example.preproject222.service;

import org.example.preproject222.config.CarProperties;
import org.example.preproject222.dao.CarDao;
import org.example.preproject222.entity.Car;
import org.example.preproject222.exception.UnsupportedSortByException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarDao carDao;


    private final CarProperties carProperties;

    @Autowired
    public CarService(CarDao carDao, CarProperties carProperties) {
        this.carDao = carDao;
        this.carProperties = carProperties;
    }


    public List<Car> getSpecifiedCarsAmount(Integer amount, List<String> sortBy) {
        if (sortBy != null) {
            validateSortBy(sortBy);
        }
        if (amount != null && amount > carProperties.getLimiter().getMaxValue()) {
            amount = null;
        }

        return carDao.getSpecifiedCarAmount(amount, sortBy);
    }


    private void validateSortBy(List<String> sortBy) {
        List<String> unsupportedSorts = new ArrayList<>();
        for (String sortByName : sortBy) {
            List<String> whiteList = carProperties.getSort().getAllowed();
            if (!whiteList.contains(sortByName)) {
                unsupportedSorts.add(sortByName);
            }
        }
        if (!unsupportedSorts.isEmpty()) {
            throw new UnsupportedSortByException("Unsupported SortBy was used", unsupportedSorts);
        }
    }
}
