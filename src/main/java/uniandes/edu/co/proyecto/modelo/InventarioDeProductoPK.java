package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class InventarioDeProductoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "bodega_nombre", referencedColumnName = "nombre.nombreBodega") 
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "sucursal_nombre", referencedColumnName = "nombre") 
    private Sucursal sucursal;

    @ManyToOne
    @JoinColumn(name = "ciudad_codigo", referencedColumnName = "codigo") 
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "producto_codigoDeBarras", referencedColumnName = "codigoDeBarras")
    private Producto producto;

    public InventarioDeProductoPK() {
        
    }

    public InventarioDeProductoPK(Bodega bodega, Sucursal sucursal, Ciudad ciudad, Producto producto) {
        this.bodega = bodega;
        this.sucursal = sucursal;
        this.ciudad = ciudad;
        this.producto = producto;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventarioDeProductoPK that = (InventarioDeProductoPK) o;
        return Objects.equals(bodega, that.bodega) &&
               Objects.equals(sucursal, that.sucursal) &&
               Objects.equals(ciudad, that.ciudad) &&
               Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bodega, sucursal, ciudad, producto);
    }
}
