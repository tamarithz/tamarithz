package com.tamarith.api.model.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the salvaguardas_tipo database table.
 * 
 */
@Entity
@Table(name = "salvaguardas_tipo")
@NamedQuery(name = "SalvaguardasTipo.findAll", query = "SELECT s FROM SalvaguardasTipo s")
public class SalvaguardasTipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsalvaguardas_tipo")
	private Integer idsalvaguardasTipo;

	private String descripcion;

	private String name;

	// bi-directional many-to-one association to SalvaguardasSubtipo
	@OneToMany(mappedBy = "salvaguardasTipo")
	private List<SalvaguardasSubtipo> salvaguardasSubtipos;

	public SalvaguardasTipo() {
	}

	public Integer getIdsalvaguardasTipo() {
		return this.idsalvaguardasTipo;
	}

	public void setIdsalvaguardasTipo(Integer idsalvaguardasTipo) {
		this.idsalvaguardasTipo = idsalvaguardasTipo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SalvaguardasSubtipo> getSalvaguardasSubtipos() {
		return this.salvaguardasSubtipos;
	}

	public void setSalvaguardasSubtipos(List<SalvaguardasSubtipo> salvaguardasSubtipos) {
		this.salvaguardasSubtipos = salvaguardasSubtipos;
	}

	public SalvaguardasSubtipo addSalvaguardasSubtipo(SalvaguardasSubtipo salvaguardasSubtipo) {
		getSalvaguardasSubtipos().add(salvaguardasSubtipo);
		salvaguardasSubtipo.setSalvaguardasTipo(this);

		return salvaguardasSubtipo;
	}

	public SalvaguardasSubtipo removeSalvaguardasSubtipo(SalvaguardasSubtipo salvaguardasSubtipo) {
		getSalvaguardasSubtipos().remove(salvaguardasSubtipo);
		salvaguardasSubtipo.setSalvaguardasTipo(null);

		return salvaguardasSubtipo;
	}
}