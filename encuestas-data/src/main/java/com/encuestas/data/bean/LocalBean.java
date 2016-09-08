package com.encuestas.data.bean;



public class LocalBean {
	private Integer idLocal;
	private EmpresaBean empresa;
	private String noLocal;
	private Integer nuLocal;
	private String coLocal;
	public String getNoLocal() {
		return noLocal;
	}
	public void setNoLocal(String noLocal) {
		this.noLocal = noLocal;
	}
	public Integer getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(Integer idLocal) {
		this.idLocal = idLocal;
	}
	public EmpresaBean getEmpresa() {
		return empresa;
	}
	public void setEmpresa(EmpresaBean empresa) {
		this.empresa = empresa;
	}

    public String getCoLocal() {
        return coLocal;
    }

    public void setCoLocal(String coLocal) {
        this.coLocal = coLocal;
    }
        
    public Integer getNuLocal() {
        return nuLocal;
    }

    public void setNuLocal(Integer nuLocal) {
        this.nuLocal = nuLocal;
    }

        
	
}
