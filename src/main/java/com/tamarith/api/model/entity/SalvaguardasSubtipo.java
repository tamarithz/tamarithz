package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the salvaguardas_subtipo database table.
 * 
 */
@Entity
@Table(name="salvaguardas_subtipo")
@NamedQuery(name="SalvaguardasSubtipo.findAll", query="SELECT s FROM SalvaguardasSubtipo s")
public class SalvaguardasSubtipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idsalvaguardas_subtipo")
	private Integer idsalvaguardasSubtipo;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-many association to ActivosTipo
	@ManyToMany
	@JoinTable(
		name="salvaguardas_subtipo_has_activos_tipos"
		, joinColumns={
			@JoinColumn(name="salvaguardas_subtipo_idsalvaguardas_subtipo")
			}
		, inverseJoinColumns={
			@JoinColumn(name="activos_tipos_idactivos_tipos")
			}
		)
	private List<ActivosTipo> activosTipos;

	//bi-directional many-to-one association to SalvaguardasTipo
	@ManyToOne
	@JoinColumn(name="id_salvaguarda_tipo")
	private SalvaguardasTipo salvaguardasTipo;

	public SalvaguardasSubtipo() {
	}

	public Integer getIdsalvaguardasSubtipo() {
		return this.idsalvaguardasSubtipo;
	}

	public void setIdsalvaguardasSubtipo(Integer idsalvaguardasSubtipo) {
		this.idsalvaguardasSubtipo = idsalvaguardasSubtipo;
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

	public SalvaguardasTipo getSalvaguardasTipo() {
		return this.salvaguardasTipo;
	}

	public void setSalvaguardasTipo(SalvaguardasTipo salvaguardasTipo) {
		this.salvaguardasTipo = salvaguardasTipo;
	}

}