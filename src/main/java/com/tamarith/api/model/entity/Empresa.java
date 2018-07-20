package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@Table(name="empresa")
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idempresa;

	private String cif;

	private String nombre;

	@Column(name="riesgo_asumido")
	private Integer riesgoAsumido;

	//bi-directional one-to-one association to ActivosEmpresa
	@OneToOne(mappedBy="empresa")
	private ActivosEmpresa activosEmpresa;

	//bi-directional one-to-one association to Empleado
	@OneToOne(mappedBy="empresa")
	private Empleado empleado;


	public Empresa() {
	}

	public Integer getIdempresa() {
		return this.idempresa;
	}

	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}

	public String getCif() {
		return this.cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getRiesgoAsumido() {
		return this.riesgoAsumido;
	}

	public void setRiesgoAsumido(Integer riesgoAsumido) {
		this.riesgoAsumido = riesgoAsumido;
	}

	public ActivosEmpresa getActivosEmpresa() {
		return this.activosEmpresa;
	}

	public void setActivosEmpresa(ActivosEmpresa activosEmpresa) {
		this.activosEmpresa = activosEmpresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}