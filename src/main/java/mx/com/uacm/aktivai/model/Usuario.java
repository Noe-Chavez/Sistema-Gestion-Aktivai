package mx.com.uacm.aktivai.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    private String nombre;

    @NotNull
	@NotEmpty
	private Rol rol;
    private String fechaCreacion;
    private boolean estatus;

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", rol='" + rol + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", estatus=" + estatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return isEstatus() == usuario.isEstatus() && getId().equals(usuario.getId()) && getNombre().equals(usuario.getNombre()) && getRol().equals(usuario.getRol()) && getFechaCreacion().equals(usuario.getFechaCreacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getRol(), getFechaCreacion(), isEstatus());
    }

}
