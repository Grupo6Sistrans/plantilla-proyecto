package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RecepcionDeProductoPK implements Serializable {
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bodega_nombre", referencedColumnName = "nombre") 
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "sucursal_nombre", referencedColumnName = "nombre")
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "ciudad_codigo", referencedColumnName = "codigo")
    private Ciudad ciudad;

    public RecepcionDeProductoPK() {
    }

    public RecepcionDeProductoPK(Integer id, Bodega bodega, Sucursal sucursal, Ciudad ciudad) {
        this.id = id;
        this.bodega = bodega;
        this.sucursal = sucursal;
        this.ciudad = ciudad;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
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
        RecepcionDeProductoPK that = (RecepcionDeProductoPK) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(bodega, that.bodega) &&
               Objects.equals(sucursal, that.sucursal) &&
               Objects.equals(ciudad, that.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bodega, sucursal, ciudad);
    }
}
