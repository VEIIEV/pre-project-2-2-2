package org.daos.criteria;

import org.entities.Car;
import org.example.telemedicinesystem.entity.Schedules;

import java.util.List;

public interface CriteriaCarsDAO {

    List<Car> getSpecifiedCarAmount(int amount);

}
