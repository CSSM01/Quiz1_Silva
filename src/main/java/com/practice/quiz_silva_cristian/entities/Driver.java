package com.practice.quiz_silva_cristian.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trucks;
    private String brand;
    private int capacity;
    private String color;
    private String plate;
    private String user_driver; // referencia al usuario asignado
}
