package org.example.preproject222.dao.criteria;

import org.example.preproject222.entitie.Car;


import java.util.List;

public interface CriteriaCarsDAO {

    List<Car> getSpecifiedCarAmount(Integer amount, List<String> sortBy);

}
