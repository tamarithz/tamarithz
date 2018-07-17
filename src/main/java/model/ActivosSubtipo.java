package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the activos_subtipos database table.
 * 
 */
@Entity
@Table(name="activos_subtipos")
@NamedQuery(name="ActivosSubtipo.findAll", query="SELECT a FROM ActivosSubtipo a")
public class ActivosSubtipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idactivos_subtipos")
	private int idactivosSubtipos;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to ActivosTipo
	@ManyToOne
	@JoinColumn(name="id_activo_tipo")
	private ActivosTipo activosTipo;

	public ActivosSubtipo() {
	}

	public int getIdactivosSubtipos() {
		return this.idactivosSubtipos;
	}

	public void setIdactivosSubtipos(int idactivosSubtipos) {
		this.idactivosSubtipos = idactivosSubtipos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ActivosTipo getActivosTipo() {
		return this.activosTipo;
	}

	public void setActivosTipo(ActivosTipo activosTipo) {
		this.activosTipo = activosTipo;
	}

}