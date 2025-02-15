package org.example.preproject222.dao;

import org.example.preproject222.dao.criteria.CriteriaCarsDAO;
import org.example.preproject222.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarDao extends CrudRepository<Car, UUID>, CriteriaCarsDAO {


}
