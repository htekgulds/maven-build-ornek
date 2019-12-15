package com.example.mavenbuildornek;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
