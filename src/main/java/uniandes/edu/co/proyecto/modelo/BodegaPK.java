package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BodegaPK implements Serializable {
    
    private String nombreBodega;

    @ManyToOne
    @JoinColumn(name = "sucursal_nombre", referencedColumnName = "nombre")
    private Sucursal sucursal;

    public BodegaPK() {
        
    }

    public BodegaPK(String nombreBodega, Sucursal sucursal, Ciudad ciudad) {
        this.nombreBodega = nombreBodega;
        this.sucursal = sucursal;
        this.ciudad = ciudad;
    }

   
    public String getNombreBodega() {
        return nombreBodega;
    }

    public void setNombreBodega(String nombreBodega) {
        this.nombreBodega = nombreBodega;
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
        BodegaPK bodegaPK = (BodegaPK) o;
        return Objects.equals(nombreBodega, bodegaPK.nombreBodega) &&
               Objects.equals(sucursal, bodegaPK.sucursal) &&
               Objects.equals(ciudad, bodegaPK.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreBodega, sucursal, ciudad);
    }
}
