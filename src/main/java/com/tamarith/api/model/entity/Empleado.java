package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleado database table.
 * 
 */
@Entity
@Table(name="empleado")
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idempleado;

	private String apellidos;

	@Column(name="cif_empresa")
	private String cifEmpresa;

	private String dnil;

	@Column(name="e_mail")
	private String eMail;

	private String nombre;

	//bi-directional one-to-one association to Empresa
	@OneToOne
	@JoinColumn(name="idempleado")
	private Empresa empresa;

	//bi-directional one-to-one association to EmpleadosDepartamento
	@OneToOne(mappedBy="empleado")
	private EmpleadosDepartamento empleadosDepartamento;

	public Empleado() {
	}

	public Integer getIdempleado() {
		return this.idempleado;
	}

	public void setIdempleado(Integer idempleado) {
		this.idempleado = idempleado;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCifEmpresa() {
		return this.cifEmpresa;
	}

	public void setCifEmpresa(String cifEmpresa) {
		this.cifEmpresa = cifEmpresa;
	}

	public String getDnil() {
		return this.dnil;
	}

	public void setDnil(String dnil) {
		this.dnil = dnil;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EmpleadosDepartamento getEmpleadosDepartamento() {
		return this.empleadosDepartamento;
	}

	public void setEmpleadosDepartamento(EmpleadosDepartamento empleadosDepartamento) {
		this.empleadosDepartamento = empleadosDepartamento;
	}

}