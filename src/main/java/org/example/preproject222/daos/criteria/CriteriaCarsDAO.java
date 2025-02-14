package org.example.preproject222.daos.criteria;

import org.example.preproject222.entities.Car;


import java.util.List;

public interface CriteriaCarsDAO {

    List<Car> getSpecifiedCarAmount(Integer amount, String[] sortBy);

}
