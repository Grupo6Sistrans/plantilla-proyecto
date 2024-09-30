package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega {
    
    @EmbeddedId
    private BodegaPK id;
    private String nombre;
    private Integer tamano;
    
    @ManyToOne
    @JoinColumn(name = "fk_sucursal", referencedColumnName = "nombre")
    private Sucursal sucursal;

    public Bodega() {;}

    // Constructor con parámetros
    public Bodega(BodegaPK id, String nombre, Integer tamano, Sucursal sucursal) {
        this.id = id;
        this.nombre = nombre;
        this.tamano = tamano;
        this.sucursal = sucursal;
    }

    // Getters y Setters
    public BodegaPK getId() {
        return id;
    }

    public void setId(BodegaPK id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTamano() {
        return tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }

    public Sucursal getNombreSucursal() {
        return sucursal;
    }

    public void setNombreSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tamano=" + tamano +
                '}';
    }
}
