package com.practice.quiz_silva_cristian.repositories;

import com.practice.quiz_silva_cristian.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}