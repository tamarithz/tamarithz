package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the amenazas_subtipo database table.
 * 
 */

@Entity
@Table(name="amenazas_subtipo")
@NamedQuery(name="AmenazasSubtipo.findAll", query="SELECT a FROM AmenazasSubtipo a")
public class AmenazasSubtipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_amenazas_subtipo")
	private Integer idAmenazasSubtipo;

	private String descripcion;

	@Column(name="id_amenaza_tipo")
	private Integer idAmenazaTipo;

	private String nombre;

	//bi-directional many-to-many association to ActivosTipo
	@ManyToMany
	@JoinTable(
		name="amenazas_has_activos_tipos"
		, joinColumns={
			@JoinColumn(name="amenazas_idriesgo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="activos_tipos_idactivos_tipos")
			}
		)
	private List<ActivosTipo> activosTipos;

	public AmenazasSubtipo() {
	}

	public Integer getIdAmenazasSubtipo() {
		return this.idAmenazasSubtipo;
	}

	public void setIdAmenazasSubtipo(Integer idAmenazasSubtipo) {
		this.idAmenazasSubtipo = idAmenazasSubtipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdAmenazaTipo() {
		return this.idAmenazaTipo;
	}

	public void setIdAmenazaTipo(Integer idAmenazaTipo) {
		this.idAmenazaTipo = idAmenazaTipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ActivosTipo> getActivosTipos() {
		return this.activosTipos;
	}

	public void setActivosTipos(List<ActivosTipo> activosTipos) {
		this.activosTipos = activosTipos;
	}

}