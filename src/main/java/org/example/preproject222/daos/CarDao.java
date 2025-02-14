package org.example.preproject222.daos;

import org.example.preproject222.daos.criteria.CriteriaCarsDAO;
import org.example.preproject222.entities.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CarDao extends CrudRepository<Car, UUID>, CriteriaCarsDAO {


}
