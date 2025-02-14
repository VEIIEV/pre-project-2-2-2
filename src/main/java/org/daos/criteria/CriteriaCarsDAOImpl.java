package org.daos.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.entities.Car;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CriteriaCarsDAOImpl implements CriteriaCarsDAO {


    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Car> getSpecifiedCarAmount(int amount) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> root = criteriaQuery.from(Car.class);
        criteriaQuery.select(root);
        TypedQuery<Car> query = entityManager.createQuery(criteriaQuery);
        query.setMaxResults(amount);
        return query.getResultList();
    }


}
