package mx.com.uacm.aktivai.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "usuario")
    private String nombre;
    private String password;
    private String email;
    private boolean estatus;
    private String rol;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return isEstatus() == usuario.isEstatus() && Objects.equals(getIdUsuario(), usuario.getIdUsuario()) && Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getPassword(), usuario.getPassword()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getRol(), usuario.getRol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUsuario(), getNombre(), getPassword(), getEmail(), isEstatus(), getRol());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", estatus=" + estatus +
                ", rol='" + rol + '\'' +
                '}';
    }

}
