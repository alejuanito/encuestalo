package com.encuestas.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.encuestas.data.bean.PromocionBean;

@Entity
@Table(name = "ectm_promocion")
public class Promocion {
	private Integer idPromocion;
	private MotivoPromocion motivoPromocion;
	private TipoPromocion tipoPromocion;
        
	private Local local;
	private String coPromocion;
	private String deTitulo;
	private String deDescripcion;
	private String noImagen;
	private String hrEnvio;
	private Date feInicio;
	private Date feFin;
        private String esPromocion;
        private Usuario usuario;

	public Promocion() {
	}

	public Promocion (PromocionBean promocionBean) {
		this.coPromocion = promocionBean.getCoPromocion();
		this.deDescripcion=promocionBean.getDeDescripcion();
		this.deTitulo= promocionBean.getDeTitulo();
		this.feFin= promocionBean.getFeFin();
		this.feInicio=promocionBean.getFeInicio();
		this.hrEnvio=promocionBean.getHrEnvio();
		this.idPromocion=promocionBean.getIdPromocion();
                this.noImagen = promocionBean.getNoImagen();
		this.esPromocion = promocionBean.getEsPromocion();
    	if (promocionBean.getLocal() != null) {
    	    this.local = new Local(promocionBean.getLocal());
    	}
    	if (promocionBean.getMotivoPromocion() != null) {
    	    this.motivoPromocion = new MotivoPromocion(promocionBean.getMotivoPromocion());
    	}
    	if (promocionBean.getTipoPromocion() != null) {
    	    this.tipoPromocion = new TipoPromocion(promocionBean.getTipoPromocion());
    	}
        if (promocionBean.getUsuario()!= null) {
    	    this.usuario = new Usuario(promocionBean.getUsuario());
    	}
       
    }
	
	@Id
	@Column(name = "id_promocion")
	 @SequenceGenerator(name="ectm_promocion_id_promocion_seq", sequenceName="ectm_promocion_id_promocion_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectm_promocion_id_promocion_seq")
	public Integer getIdPromocion() {
		return idPromocion;
	}

	public void setIdPromocion(Integer idPromocion) {
		this.idPromocion = idPromocion;
	}

	@ManyToOne
	@JoinColumn(name = "id_motivo_promocion")
	public MotivoPromocion getMotivoPromocion() {
		return motivoPromocion;
	}
        
        public void setMotivoPromocion(MotivoPromocion motivoPromocion) {
		this.motivoPromocion = motivoPromocion;
	}
        
        @ManyToOne
	@JoinColumn(name = "id_usuario_registro")
        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        
	

	@ManyToOne
	@JoinColumn(name = "id_tipo_promocion")
	public TipoPromocion getTipoPromocion() {
		return tipoPromocion;
	}

	public void setTipoPromocion(TipoPromocion tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}

	@ManyToOne
	@JoinColumn(name = "id_local")
	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Column(name = "co_promocion")
	public String getCoPromocion() {
		return coPromocion;
	}

	public void setCoPromocion(String coPromocion) {
		this.coPromocion = coPromocion;
	}

	@Column(name = "de_titulo")
	public String getDeTitulo() {
		return deTitulo;
	}

	public void setDeTitulo(String deTitulo) {
		this.deTitulo = deTitulo;
	}

	@Column(name = "de_descripcion")
	public String getDeDescripcion() {
		return deDescripcion;
	}

	public void setDeDescripcion(String deDescripcion) {
		this.deDescripcion = deDescripcion;
	}

	@Column(name = "no_imagen")
	public String getNoImagen() {
		return noImagen;
	}

	public void setNoImagen(String noImagen) {
		this.noImagen = noImagen;
	}

	@Column(name = "hr_envio")
	public String getHrEnvio() {
		return hrEnvio;
	}

	public void setHrEnvio(String hrEnvio) {
		this.hrEnvio = hrEnvio;
	}

	@Column(name = "fe_inicio")       
	public Date getFeInicio() {
		return feInicio;
	}

	public void setFeInicio(Date feInicio) {
		this.feInicio = feInicio;
	}

	@Column(name = "fe_fin")
	public Date getFeFin() {
		return feFin;
	}

	public void setFeFin(Date feFin) {
		this.feFin = feFin;
	}

        @Column(name = "es_promocion")
        public String getEsPromocion() {
            return esPromocion;
        }

        public void setEsPromocion(String esPromocion) {
            this.esPromocion = esPromocion;
        }
        
       

}
