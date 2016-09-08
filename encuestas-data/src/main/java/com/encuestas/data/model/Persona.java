package com.encuestas.data.model;

import javax.persistence.*;

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.encuestas.data.util.UpperCaseType;

import java.util.Date;
import java.util.List;

@TypeDef(
        name = "upperCase",
        typeClass = UpperCaseType.class,
        parameters = {
            @Parameter(name = "cast", value = "upper")
        }
)
@Entity
@Table(name = "ectm_persona")
public class Persona {
	private Integer idPersona;
	private String amPersona;
	private String noPersona;
	private String apPersona;
	private Date feNacimiento;
	private String nuTelefonoFijo;
	private String noTelefonoCelular;
	private String deEmail;
	private String esPersona;
	private String nuDocumento;
	private String coSexo;
	private TipoDocumento tipoDocumento;


	@Id
	@Column(name = "id_persona")
	@SequenceGenerator(name="ectm_persona_id_persona_seq", sequenceName="ectm_persona_id_persona_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ectm_persona_id_persona_seq")	
	public Integer getIdPersona() {
		return idPersona;
	}

	@ManyToOne
	@JoinColumn(name = "co_tipo_documento")
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	@Type(type="upperCase")
	@Column(name = "am_persona")
	public String getAmPersona() {
		return amPersona;
	}

	public void setAmPersona(String amPersona) {
		this.amPersona = amPersona;
	}
	
	@Type(type="upperCase")
	@Column(name = "no_persona")
	public String getNoPersona() {
		return noPersona;
	}

	public void setNoPersona(String noPersona) {
		this.noPersona = noPersona;
	}

	@Type(type="upperCase")
	@Column(name = "ap_persona")
	public String getApPersona() {
		return apPersona;
	}

	public void setApPersona(String apPersona) {
		this.apPersona = apPersona;
	}

	@Column(name = "fe_nacimiento")
	public Date getFeNacimiento() {
		return feNacimiento;
	}

	public void setFeNacimiento(Date feNacimiento) {
		this.feNacimiento = feNacimiento;
	}

	@Column(name = "nu_telefono_fijo")
	public String getNuTelefonoFijo() {
		return nuTelefonoFijo;
	}

	public void setNuTelefonoFijo(String nuTelefonoFijo) {
		this.nuTelefonoFijo = nuTelefonoFijo;
	}

	@Column(name = "nu_telefono_celular")
	public String getNoTelefonoCelular() {
		return noTelefonoCelular;
	}

	public void setNoTelefonoCelular(String noTelefonoCelular) {
		this.noTelefonoCelular = noTelefonoCelular;
	}

	@Column(name = "de_email")
	public String getDeEmail() {
		return deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}

	@Column(name = "es_persona")
	public String getEsPersona() {
		return esPersona;
	}

	public void setEsPersona(String esPersona) {
		this.esPersona = esPersona;
	}

	@Column(name = "nu_documento")
	public String getNuDocumento() {
		return nuDocumento;
	}

	public void setNuDocumento(String nuDocumento) {
		this.nuDocumento = nuDocumento;
	}

	@Column(name = "co_sexo")
	public String getCoSexo() {
		return coSexo;
	}

	public void setCoSexo(String coSexo) {
		this.coSexo = coSexo;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	// bi-directional many-to-one association to CmtbPersona
	@OneToMany(mappedBy = "persona")
	private List<Colaborador> colaboradors;
}
