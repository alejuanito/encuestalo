package com.encuestas.data.model;

import javax.persistence.*;

import java.util.Date;


@Entity
@Table(name = "ectm_colaborador")
public class Colaborador {
	private Integer idColaborador;	
	private Persona persona;
	private Usuario usuario;
	private Local local;
	private CargoColaborador cargoColaborador;
	
	

	@Id
	@Column(name = "id_colaborador")
    @SequenceGenerator(name="ectm_colaborador_id_colaborador_seq", sequenceName="ectm_colaborador_id_colaborador_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectm_colaborador_id_colaborador_seq")
	public Integer getIdColaborador() {
		return idColaborador;
	}

	public void setIdColaborador(Integer idColaborador) {
		this.idColaborador = idColaborador;
	}

	@ManyToOne
	@JoinColumn(name = "id_persona")
	public Persona getPersona() {
		return persona;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	public Usuario getUsuario() {
		return usuario;
	}
	
	@ManyToOne
	@JoinColumn(name = "id_local")
	public Local getLocal() {
		return local;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

    @ManyToOne
    @JoinColumn(name = "co_cargo_colaborador")
    public CargoColaborador getCargoColaborador() {
        return cargoColaborador;
    }

    public void setCargoColaborador(CargoColaborador cargoColaborador) {
        this.cargoColaborador = cargoColaborador;
    }
}
