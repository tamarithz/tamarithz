package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activos_empresa database table.
 * 
 */
@Entity
@Table(name="activos_empresa")
@NamedQuery(name="ActivosEmpresa.findAll", query="SELECT a FROM ActivosEmpresa a")
public class ActivosEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idactivos_empresa")
	private Integer idactivosEmpresa;

	private String cif;

	private Integer idactivos;

	private Integer idempleado;

	//bi-directional one-to-one association to Empresa
	@OneToOne
	@JoinColumn(name="idactivos_empresa")
	private Empresa empresa;

	//bi-directional one-to-one association to ActivosTipo
	@OneToOne(mappedBy="activosEmpresa")
	private ActivosTipo activosTipo;

	public ActivosEmpresa() {
	}

	public int getIdactivosEmpresa() {
		return this.idactivosEmpresa;
	}

	public void setIdactivosEmpresa(Integer idactivosEmpresa) {
		this.idactivosEmpresa = idactivosEmpresa;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public Integer getIdactivos() {
		return this.idactivos;
	}

	public void setIdactivos(Integer idactivos) {
		this.idactivos = idactivos;
	}

	public Integer getIdempleado() {
		return this.idempleado;
	}

	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public ActivosTipo getActivosTipo() {
		return this.activosTipo;
	}

	public void setActivosTipo(ActivosTipo activosTipo) {
		this.activosTipo = activosTipo;
	}

}