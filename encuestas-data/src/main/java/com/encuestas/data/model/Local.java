package com.encuestas.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.encuestas.data.bean.LocalBean;


@Entity
@Table(name = "ectm_local")
public class Local {
	private Integer idLocal;
	private Empresa empresa;
	private String noLocal;
        private Integer nuLocal;
        private String coLocal;
	 public Local(){
	    }
	    
	    public Local (LocalBean localBean) {
	    	this.idLocal = localBean.getIdLocal();
	    	this.noLocal = localBean.getNoLocal();
	    	this.nuLocal = localBean.getNuLocal();
	    }
	
	@Id
	@Column(name = "id_local")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getIdLocal() {
		return idLocal;
	}

	@ManyToOne
	@JoinColumn(name = "id_empresa")
	public Empresa getEmpresa() {
		return empresa;
	}



	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	@Column(name = "no_local")
	public String getNoLocal() {
		return noLocal;
	}

	public void setNoLocal(String noLocal) {
		this.noLocal = noLocal;
	}
        @Column(name = "nu_local")
        public Integer getNuLocal() {
            return nuLocal;
        }

        public void setNuLocal(Integer nuLocal) {
            this.nuLocal = nuLocal;
        }
        
        @Column(name = "co_local")
    public String getCoLocal() {
        return coLocal;
    }

    public void setCoLocal(String coLocal) {
        this.coLocal = coLocal;
    }
	
	
	
}
