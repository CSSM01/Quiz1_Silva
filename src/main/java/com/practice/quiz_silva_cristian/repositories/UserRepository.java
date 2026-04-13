package com.practice.quiz_silva_cristian.repositories;

import com.practice.quiz_silva_cristian.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
