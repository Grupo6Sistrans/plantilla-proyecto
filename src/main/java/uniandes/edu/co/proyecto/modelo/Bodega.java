package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega {

    @Id
    private String nombre;
    private Integer tamanio;

    public Bodega() {
        // Default constructor
    }

    public Bodega(Integer tamanio) {
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTamanio() {
        return tamanio;
    }

    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Bodega{" +
                "nombre='" + nombre + '\'' +
                ", tamanio=" + tamanio +
                '}';
    }
}
