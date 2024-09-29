package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrdenDeCompraPK implements Serializable {
    private Integer codigo;

    @ManyToOne
    @JoinColumn(name = "sucursal_nombre", referencedColumnName = "nombre")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "ciudad_codigo", referencedColumnName = "codigo")
    private Ciudad ciudad;

    public OrdenDeCompraPK() {
       
    }

    public OrdenDeCompraPK(Integer codigo, Sucursal sucursal, Ciudad ciudad) {
        this.codigo = codigo;
        this.sucursal = sucursal;
        this.ciudad = ciudad;
    }


    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdenDeCompraPK that = (OrdenDeCompraPK) o;
        return Objects.equals(codigo, that.codigo) &&
               Objects.equals(sucursal, that.sucursal) &&
               Objects.equals(ciudad, that.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, sucursal, ciudad);
    }
}
