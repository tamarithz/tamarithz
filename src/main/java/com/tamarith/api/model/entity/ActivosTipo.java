package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the activos_tipos database table.
 * 
 */
@Entity
@Table(name="activos_tipos")
@NamedQuery(name="ActivosTipo.findAll", query="SELECT a FROM ActivosTipo a")
public class ActivosTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idactivos_tipos")
	private Integer idactivosTipos;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to ActivosSubtipo
	@OneToMany(mappedBy="activosTipo")
	private List<ActivosSubtipo> activosSubtipos;

	//bi-directional one-to-one association to ActivosEmpresa
	@OneToOne
	@JoinColumn(name="idactivos_tipos")
	private ActivosEmpresa activosEmpresa;

	//bi-directional many-to-many association to AmenazasSubtipo
	@ManyToMany(mappedBy="activosTipos")
	private List<AmenazasSubtipo> amenazasSubtipos;

	//bi-directional many-to-many association to SalvaguardasSubtipo
	@ManyToMany(mappedBy="activosTipos")
	private List<SalvaguardasSubtipo> salvaguardasSubtipos;

	public ActivosTipo() {
	}

	public Integer getIdactivosTipos() {
		return this.idactivosTipos;
	}

	public void setIdactivosTipos(Integer idactivosTipos) {
		this.idactivosTipos = idactivosTipos;
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

	public List<ActivosSubtipo> getActivosSubtipos() {
		return this.activosSubtipos;
	}

	public void setActivosSubtipos(List<ActivosSubtipo> activosSubtipos) {
		this.activosSubtipos = activosSubtipos;
	}

	public ActivosSubtipo addActivosSubtipo(ActivosSubtipo activosSubtipo) {
		getActivosSubtipos().add(activosSubtipo);
		activosSubtipo.setActivosTipo(this);

		return activosSubtipo;
	}

	public ActivosSubtipo removeActivosSubtipo(ActivosSubtipo activosSubtipo) {
		getActivosSubtipos().remove(activosSubtipo);
		activosSubtipo.setActivosTipo(null);

		return activosSubtipo;
	}

	public ActivosEmpresa getActivosEmpresa() {
		return this.activosEmpresa;
	}

	public void setActivosEmpresa(ActivosEmpresa activosEmpresa) {
		this.activosEmpresa = activosEmpresa;
	}

	public List<AmenazasSubtipo> getAmenazasSubtipos() {
		return this.amenazasSubtipos;
	}

	public void setAmenazasSubtipos(List<AmenazasSubtipo> amenazasSubtipos) {
		this.amenazasSubtipos = amenazasSubtipos;
	}

	public List<SalvaguardasSubtipo> getSalvaguardasSubtipos() {
		return this.salvaguardasSubtipos;
	}

	public void setSalvaguardasSubtipos(List<SalvaguardasSubtipo> salvaguardasSubtipos) {
		this.salvaguardasSubtipos = salvaguardasSubtipos;
	}

}