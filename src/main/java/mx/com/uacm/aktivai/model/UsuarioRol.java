package mx.com.uacm.aktivai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "usuarios_roles")
public class UsuarioRol {

    @Id
    @Column(name = "usuario_id ")
    private Integer idUsuario;
    @Column(name = "rol_id ")
    private Integer idRol;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioRol that)) return false;
        return Objects.equals(getIdUsuario(), that.getIdUsuario()) && Objects.equals(getIdRol(), that.getIdRol());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUsuario(), getIdRol());
    }

    @Override
    public String toString() {
        return "UsuarioRol{" +
                "idUsuario=" + idUsuario +
                ", idRol=" + idRol +
                '}';
    }

}
