package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega {

    
    @EmbeddedId
    private BodegaPK id;

    private String nombre;
    
    private Integer tamano;

    public Bodega() {
        
    }

    public Bodega(BodegaPK id, Integer tamano) {
        this.id = id;
        this.tamano = tamano;
    }

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

    @Override
    public String toString() {
        return "Bodega{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tamano=" + tamano +
                '}';
    }
}
