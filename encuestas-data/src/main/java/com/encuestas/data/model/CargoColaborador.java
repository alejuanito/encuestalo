package com.encuestas.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ectm_cargo_colaborador")
public class CargoColaborador {
    private String coCargoColaborador;
    private String deCargoColaborador;

    @Id
    @Column(name="co_cargo_colaborador")
    public String getCoCargoColaborador() {
        return coCargoColaborador;
    }

    public void setCoCargoColaborador(String coCargoColaborador) {
        this.coCargoColaborador = coCargoColaborador;
    }

    @Column(name="de_cargo_colaborador")
    public String getDeCargoColaborador() {
        return deCargoColaborador;
    }

    public void setDeCargoColaborador(String deCargoColaborador) {
        this.deCargoColaborador = deCargoColaborador;
    }

}
