package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the departamento database table.
 * 
 */
@Entity
@NamedQuery(name="Departamento.findAll", query="SELECT d FROM Departamento d")
public class Departamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iddepartamento;

	private String descripccion;

	//bi-directional one-to-one association to EmpleadosDepartamento
	@OneToOne(mappedBy="departamento")
	private EmpleadosDepartamento empleadosDepartamento;

	public Departamento() {
	}

	public int getIddepartamento() {
		return this.iddepartamento;
	}

	public void setIddepartamento(int iddepartamento) {
		this.iddepartamento = iddepartamento;
	}

	public String getDescripccion() {
		return this.descripccion;
	}

	public void setDescripccion(String descripccion) {
		this.descripccion = descripccion;
	}

	public EmpleadosDepartamento getEmpleadosDepartamento() {
		return this.empleadosDepartamento;
	}

	public void setEmpleadosDepartamento(EmpleadosDepartamento empleadosDepartamento) {
		this.empleadosDepartamento = empleadosDepartamento;
	}

}