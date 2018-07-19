package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the empleados_departamento database table.
 * 
 */
@Entity
@Table(name="empleados_departamento")
@NamedQuery(name="EmpleadosDepartamento.findAll", query="SELECT e FROM EmpleadosDepartamento e")
public class EmpleadosDepartamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idempleados_departamento")
	private Integer idempleadosDepartamento;

	private String descripcion;

	//bi-directional one-to-one association to Departamento
	@OneToOne
	@JoinColumn(name="idempleados_departamento")
	private Departamento departamento;

	//bi-directional one-to-one association to Empleado
	@OneToOne
	@JoinColumn(name="idempleados_departamento")
	private Empleado empleado;

	public EmpleadosDepartamento() {
	}

	public Integer getIdempleadosDepartamento() {
		return this.idempleadosDepartamento;
	}

	public void setIdempleadosDepartamento(Integer idempleadosDepartamento) {
		this.idempleadosDepartamento = idempleadosDepartamento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

}