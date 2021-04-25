package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Genero;

public interface GenderRepository extends CrudRepository <Genero, Long> {

}
