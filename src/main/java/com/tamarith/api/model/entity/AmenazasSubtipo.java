package com.tamarith.api.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


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

	private String nombre;

	//bi-directional many-to-many association to ActivosTipo
	@ManyToMany
	@JoinTable(
		name="activos_tipos_has_amenazas_subtipo"
		, joinColumns={
			@JoinColumn(name="amenazas_subtipo_id_amenazas_subtipo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="activos_tipos_id_activos_tipos")
			}
		)
	private List<ActivosTipo> activosTipos;
	
	//bi-directional many-to-one association to AmenazasTipo
	@ManyToOne
	@JoinColumn(name="id_amenaza_tipo")
	private AmenazasTipo amenazasTipo;

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

	public AmenazasTipo getAmenazasTipo() {
		return this.amenazasTipo;
	}

	public void setAmenazasTipo(AmenazasTipo amenazasTipo) {
		this.amenazasTipo = amenazasTipo;
	}
//<<<<<<< HEAD
//=======














//
//
//
//
//package com.tamarith.api.model.entity;
//
//import java.io.Serializable;
//import javax.persistence.*;
//import java.util.List;
//
//
///**
// * The persistent class for the amenazas_subtipo database table.
// * 
// */
//@Entity
//@Table(name="amenazas_subtipo")
//@NamedQuery(name="AmenazasSubtipo.findAll", query="SELECT a FROM AmenazasSubtipo a")
//public class AmenazasSubtipo implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id_amenazas_subtipo")
//	private Integer idAmenazasSubtipo;
//
//	private String descripcion;
//
//	private String nombre;
//
//	//bi-directional many-to-many association to ActivosTipo
//	@ManyToMany
//	@JoinTable(
//		name="activos_tipos_has_amenazas_subtipo"
//		, joinColumns={
//			@JoinColumn(name="amenazas_subtipo_id_amenazas_subtipo")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="activos_tipos_id_activos_tipos")
//			}
//		)
//	private List<ActivosTipo> activosTipos;
//
//	public AmenazasSubtipo() {
//	}
//
//	public Integer getIdAmenazasSubtipo() {
//		return this.idAmenazasSubtipo;
//	}
//
//	public void setIdAmenazasSubtipo(Integer idAmenazasSubtipo) {
//		this.idAmenazasSubtipo = idAmenazasSubtipo;
//	}
//
//	public String getDescripcion() {
//		return this.descripcion;
//	}
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//
//	public String getNombre() {
//		return this.nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public List<ActivosTipo> getActivosTipos() {
//		return this.activosTipos;
//	}
//
//	public void setActivosTipos(List<ActivosTipo> activosTipos) {
//		this.activosTipos = activosTipos;
//	}
}