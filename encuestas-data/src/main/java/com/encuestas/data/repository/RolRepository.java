package com.encuestas.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer> {

}
