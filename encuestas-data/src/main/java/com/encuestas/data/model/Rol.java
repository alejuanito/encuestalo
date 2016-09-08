package com.encuestas.data.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ectm_rol")
public class Rol {
    private Integer idRol;
    private String nombre;
    private String estado;
    private List<RolOpcion> rolOpciones;

    @Id
    @Column(name = "id_rol")
    @SequenceGenerator(name="ectm_rol_id_rol_seq", sequenceName="ectm_rol_id_rol_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectm_rol_id_rol_seq")
    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
    
    @Column(name = "no_rol")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "es_rol")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @OneToMany(mappedBy = "rol")
    public List<RolOpcion> getRolOpciones() {
        return rolOpciones;
    }

    public void setRolOpciones(List<RolOpcion> rolOpciones) {
        this.rolOpciones = rolOpciones;
    }
}
