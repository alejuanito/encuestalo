package com.encuestas.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.Opcion;

public interface OpcionRepository extends JpaRepository<Opcion, Integer> {

}
