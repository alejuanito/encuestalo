package com.encuestas.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.RolOpcion;
import com.encuestas.data.model.RolOpcionPK;

public interface RolOpcionRepository extends JpaRepository<RolOpcion, RolOpcionPK> {

}
