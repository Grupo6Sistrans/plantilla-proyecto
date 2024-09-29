package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega {
    @EmbeddedId
    private BodegaPK nombre;

    private Integer tamano;

    public Bodega() {
        
    }

    public Bodega(BodegaPK nombre, Integer tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }

    public BodegaPK getNombre() {
        return nombre;
    }

    public void setNombre(BodegaPK nombre) {
        this.nombre = nombre;
    }

    public Integer getTamano() {
        return tamano;
    }

    public void setTamano(Integer tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "nombre=" + nombre +
                ", tamano=" + tamano +
                '}';
    }
}
