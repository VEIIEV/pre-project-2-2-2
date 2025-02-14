package org.example.preproject222.daos.criteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
import jakarta.persistence.criteria.Root;
import org.example.preproject222.entities.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Repository
public class CriteriaCarsDAOImpl implements CriteriaCarsDAO {


    @Value("${cars.max-car}")
    private Integer maxAmount;

    @PersistenceContext
    private EntityManager entityManager;

    public CriteriaCarsDAOImpl() {
    }

    @Override
    public List<Car> getSpecifiedCarAmount(Integer amount, List<String> sortBy) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> root = criteriaQuery.from(Car.class);

        criteriaQuery.select(root);

        if (sortBy != null) {
            List<Order> orders = new ArrayList<>();
            for (String sortByName : sortBy) {
                orders.add(criteriaBuilder.desc(root.get(sortByName)));
            }
            criteriaQuery.orderBy(orders);
        }


        TypedQuery<Car> query = entityManager.createQuery(criteriaQuery);
        if (amount != null && amount < maxAmount) {
            query.setMaxResults(amount);
        }
        return query.getResultList();
    }


}
