package org.daos;

import org.daos.criteria.CriteriaCarsDAO;
import org.entities.Car;
import org.hibernate.annotations.processing.HQL;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarDao extends CrudRepository<Car, UUID>, CriteriaCarsDAO {


}
