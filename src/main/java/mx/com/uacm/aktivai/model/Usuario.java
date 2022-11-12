package mx.com.uacm.aktivai.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "usuario")
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String password;
    private String email;
    private boolean estatus;
    private String avatar;
    private Date fechaCreacion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id ")
    )
    private List<Rol> roles;

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

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return isEstatus() == usuario.isEstatus() && Objects.equals(getIdUsuario(), usuario.getIdUsuario()) && Objects.equals(getNombre(), usuario.getNombre()) && Objects.equals(getApellidoPaterno(), usuario.getApellidoPaterno()) && Objects.equals(getApellidoMaterno(), usuario.getApellidoMaterno()) && Objects.equals(getPassword(), usuario.getPassword()) && Objects.equals(getEmail(), usuario.getEmail()) && Objects.equals(getAvatar(), usuario.getAvatar()) && Objects.equals(getFechaCreacion(), usuario.getFechaCreacion()) && Objects.equals(getRoles(), usuario.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUsuario(), getNombre(), getApellidoPaterno(), getApellidoMaterno(), getPassword(), getEmail(), isEstatus(), getAvatar(), getFechaCreacion(), getRoles());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", estatus=" + estatus +
                ", avatar='" + avatar + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", roles=" + roles +
                '}';
    }

}
