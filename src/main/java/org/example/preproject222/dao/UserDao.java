package org.example.preproject222.dao;

import org.example.preproject222.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
}
