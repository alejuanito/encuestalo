package com.encuestas.data.model;

import java.util.Date;
import javax.persistence.*;


@Entity
@Table(name = "ectr_cliente_local")
public class ClienteLocal {
	private Integer idClienteLocal;
	private Local local;
	private Cliente cliente;
        private Date feCreaRegistro;

    @Id
    @Column(name = "id_cliente_local")
    @SequenceGenerator(name="ectr_cliente_local_seq", sequenceName="ectr_cliente_local_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectr_cliente_local_seq")
    public Integer getIdClienteLocal() {
        return idClienteLocal;
    }

    public void setIdClienteLocal(Integer idClienteLocal) {
        this.idClienteLocal = idClienteLocal;
    }

    @ManyToOne
    @JoinColumn(name = "id_local")
    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(name = "fe_crea_registro")
    public Date getFeCreaRegistro() {
        return feCreaRegistro;
    }

    public void setFeCreaRegistro(Date feCreaRegistro) {
        this.feCreaRegistro = feCreaRegistro;
    }
      
	
}
