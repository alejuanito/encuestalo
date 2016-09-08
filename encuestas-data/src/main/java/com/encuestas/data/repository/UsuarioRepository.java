package com.encuestas.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.encuestas.data.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByUsernameIgnoreCase (String username);
    public Usuario findByUsername (String username);

}
