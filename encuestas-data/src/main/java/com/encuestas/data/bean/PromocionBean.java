package com.encuestas.data.bean;

import java.util.Date;



public class PromocionBean {
	private Integer idPromocion;
	private MotivoPromocionBean motivoPromocion;
	private TipoPromocionBean tipoPromocion;
	private LocalBean local;
	private String coPromocion;
	private String deTitulo;
	private String deDescripcion;
	private String noImagen;
	private String hrEnvio;
	private Date feInicio;
	private Date feFin;
        private String esPromocion;
        private UsuarioBean usuario;
        private String userRegister;
        private String feInicioString;
        private String feFinString;
	public Integer getIdPromocion() {
		return idPromocion;
	}
	public void setIdPromocion(Integer idPromocion) {
		this.idPromocion = idPromocion;
	}
	public MotivoPromocionBean getMotivoPromocion() {
		return motivoPromocion;
	}
	public void setMotivoPromocion(MotivoPromocionBean motivoPromocion) {
		this.motivoPromocion = motivoPromocion;
	}
	public TipoPromocionBean getTipoPromocion() {
		return tipoPromocion;
	}
	public void setTipoPromocion(TipoPromocionBean tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}
	public LocalBean getLocal() {
		return local;
	}
	public void setLocal(LocalBean local) {
		this.local = local;
	}
	public String getCoPromocion() {
		return coPromocion;
	}
	public void setCoPromocion(String coPromocion) {
		this.coPromocion = coPromocion;
	}
	public String getDeTitulo() {
		return deTitulo;
	}
	public void setDeTitulo(String deTitulo) {
		this.deTitulo = deTitulo;
	}
	public String getDeDescripcion() {
		return deDescripcion;
	}
	public void setDeDescripcion(String deDescripcion) {
		this.deDescripcion = deDescripcion;
	}
	public String getNoImagen() {
		return noImagen;
	}
	public void setNoImagen(String noImagen) {
		this.noImagen = noImagen;
	}
	public String getHrEnvio() {
		return hrEnvio;
	}
	public void setHrEnvio(String hrEnvio) {
		this.hrEnvio = hrEnvio;
	}
	public Date getFeInicio() {
		return feInicio;
	}
	public void setFeInicio(Date feInicio) {
		this.feInicio = feInicio;
	}
	public Date getFeFin() {
		return feFin;
	}
	public void setFeFin(Date feFin) {
		this.feFin = feFin;
	}

    public String getEsPromocion() {
        return esPromocion;
    }

    public void setEsPromocion(String esPromocion) {
        this.esPromocion = esPromocion;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }

    public String getUserRegister() {
        return userRegister;
    }

    public void setUserRegister(String userRegister) {
        this.userRegister = userRegister;
    }

    public String getFeInicioString() {
        return feInicioString;
    }

    public void setFeInicioString(String feInicioString) {
        this.feInicioString = feInicioString;
    }

    public String getFeFinString() {
        return feFinString;
    }

    public void setFeFinString(String feFinString) {
        this.feFinString = feFinString;
    }
        
    
	

	
	
	

	
	
}
