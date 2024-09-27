package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bodegas")
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private Integer tamano;

    public Bodega() {
        // Default constructor
    }

    public Bodega(String nombre, Integer tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
