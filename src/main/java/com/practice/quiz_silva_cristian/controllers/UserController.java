package com.practice.quiz_silva_cristian.controllers;

import com.practice.quiz_silva_cristian.entities.UserEntity;
import com.practice.quiz_silva_cristian.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/crear")
    public UserEntity crear(@RequestBody UserEntity user) {
        return repository.save(user);
    }

    @GetMapping("/listar")
    public List<UserEntity> listar() {
        return repository.findAll();
    }
}
