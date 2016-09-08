package com.encuestas.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.UsuarioRol;
import com.encuestas.data.model.UsuarioRolPK;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolPK> {

}
