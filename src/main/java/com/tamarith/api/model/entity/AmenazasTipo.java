package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the amenazas_tipo database table.
 * 
 */
@Entity
@Table(name="amenazas_tipo")
@NamedQuery(name="AmenazasTipo.findAll", query="SELECT a FROM AmenazasTipo a")
public class AmenazasTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="`id_amenaza tipo`")
	private int idAmenaza_tipo;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to AmenazasSubtipo
	@OneToMany(mappedBy="amenazasTipo")
	private List<AmenazasSubtipo> amenazasSubtipos;

	public AmenazasTipo() {
	}

	public int getIdAmenaza_tipo() {
		return this.idAmenaza_tipo;
	}

	public void setIdAmenaza_tipo(int idAmenaza_tipo) {
		this.idAmenaza_tipo = idAmenaza_tipo;
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

	public List<AmenazasSubtipo> getAmenazasSubtipos() {
		return this.amenazasSubtipos;
	}

	public void setAmenazasSubtipos(List<AmenazasSubtipo> amenazasSubtipos) {
		this.amenazasSubtipos = amenazasSubtipos;
	}

	public AmenazasSubtipo addAmenazasSubtipo(AmenazasSubtipo amenazasSubtipo) {
		getAmenazasSubtipos().add(amenazasSubtipo);
		amenazasSubtipo.setAmenazasTipo(this);

		return amenazasSubtipo;
	}

	public AmenazasSubtipo removeAmenazasSubtipo(AmenazasSubtipo amenazasSubtipo) {
		getAmenazasSubtipos().remove(amenazasSubtipo);
		amenazasSubtipo.setAmenazasTipo(null);

		return amenazasSubtipo;
	}

}