package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the empresa database table.
 * 
 */
@Entity
@NamedQuery(name="Empresa.findAll", query="SELECT e FROM Empresa e")
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idempresa;

	private int cif;

	private String nombre;

	@Column(name="riesgo_asumido")
	private int riesgoAsumido;

	//bi-directional one-to-one association to ActivosEmpresa
	@OneToOne(mappedBy="empresa")
	private ActivosEmpresa activosEmpresa;

	//bi-directional one-to-one association to Empleado
	@OneToOne(mappedBy="empresa")
	private Empleado empleado;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="empresa")
	private List<Usuario> usuarios;

	public Empresa() {
	}

	public int getIdempresa() {
		return this.idempresa;
	}

	public void setIdempresa(int idempresa) {
		this.idempresa = idempresa;
	}

	public int getCif() {
		return this.cif;
	}

	public void setCif(int cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRiesgoAsumido() {
		return this.riesgoAsumido;
	}

	public void setRiesgoAsumido(int riesgoAsumido) {
		this.riesgoAsumido = riesgoAsumido;
	}

	public ActivosEmpresa getActivosEmpresa() {
		return this.activosEmpresa;
	}

	public void setActivosEmpresa(ActivosEmpresa activosEmpresa) {
		this.activosEmpresa = activosEmpresa;
	}

	public Empleado getEmpleado() {
		return this.empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setEmpresa(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setEmpresa(null);

		return usuario;
	}

}