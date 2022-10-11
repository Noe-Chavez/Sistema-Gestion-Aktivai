package mx.com.uacm.aktivai.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Rol {

    @Id
    @Column(name = "id_rol ")
    private Integer idRol;
    @Column(name = "rol")
    private String rol;
    @Column(name = "descripcion")
    private String descripcion;

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rol rol1)) return false;
        return Objects.equals(getIdRol(), rol1.getIdRol()) && Objects.equals(getRol(), rol1.getRol()) && Objects.equals(getDescripcion(), rol1.getDescripcion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdRol(), getRol(), getDescripcion());
    }

    @Override
    public String toString() {
        return "Rol{" +
                "idRol=" + idRol +
                ", rol='" + rol + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
