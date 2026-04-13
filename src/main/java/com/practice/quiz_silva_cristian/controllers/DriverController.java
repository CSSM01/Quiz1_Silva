package com.practice.quiz_silva_cristian.controllers;

import com.practice.quiz_silva_cristian.entities.Driver;
import com.practice.quiz_silva_cristian.repositories.DriverRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverRepository repository;

    public DriverController(DriverRepository repository) {
        this.repository = repository;
    }

    // ADMIN: Crear
    @PostMapping("/crear")
    public Driver crear(@RequestBody Driver driver) {
        return repository.save(driver);
    }

    // DRIVER: Ver todos
    @GetMapping("/listar")
    public List<Driver> listar() {
        return repository.findAll();
    }

    // DRIVER: Ver uno
    @GetMapping("/{id}")
    public Driver ver(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
}