package com.encuestas.data.model;


import java.sql.Timestamp;

import java.util.Date;
import javax.persistence.*;



@Entity
@Table(name = "ectc_promocion_enviada")
public class PromocionEnviada {
	private Cliente cliente;
	private Integer idPromocionEnviada;
	private Promocion promocion;

	private Date feEnvio;

        private Empresa empresa;

    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Id
    @Column(name = "id_promocion_enviada")
    @SequenceGenerator(name="ectc_promocion_enviada_id_promocion_enviada_seq", sequenceName="ectc_promocion_enviada_id_promocion_enviada_seq", allocationSize=1)	
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectc_promocion_enviada_id_promocion_enviada_seq")
    public Integer getIdPromocionEnviada() {
        return idPromocionEnviada;
    }

    public void setIdPromocionEnviada(Integer idPromocionEnviada) {
        this.idPromocionEnviada = idPromocionEnviada;
    }
    
    @ManyToOne
    @JoinColumn(name = "id_promocion")
    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    @Column(name = "fe_envio")
    @Temporal(TemporalType.TIMESTAMP)    
    public Date getFeEnvio() {
        return feEnvio;
    }

    public void setFeEnvio(Date feEnvio) {

        this.feEnvio = feEnvio;
    }


	
	 @ManyToOne
	@JoinColumn(name = "id_empresa")
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

    @ManyToOne
    @JoinColumn(name = "id_usuario_registro_promo")
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
