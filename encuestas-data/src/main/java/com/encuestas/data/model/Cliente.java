package com.encuestas.data.model;

import javax.persistence.*;


@Entity
@Table(name = "ectm_cliente")
public class Cliente {
	private Integer idCliente;
	private Persona persona;
	private Empresa empresa;
        private Boolean inPromocion;

	

	@Id
	@Column(name = "id_cliente")
	@SequenceGenerator(name="ectm_cliente_id_cliente_seq", sequenceName="ectm_cliente_id_cliente_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectm_cliente_id_cliente_seq")
	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	@ManyToOne
	@JoinColumn(name = "id_persona")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

        @Column(name = "in_promocion")
        public Boolean getInPromocion() {
            return inPromocion;
        }

        public void setInPromocion(Boolean inPromocion) {
            this.inPromocion = inPromocion;
        }
        
        
	
}
