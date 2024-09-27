package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario_de_productos")
public class InventarioDeProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer costoPromedio;
    private Integer cantidad;
    private Integer capacidad;
    private Integer nivelMinimoReorden;

    public InventarioDeProducto() {
        // Default constructor
    }

    public InventarioDeProducto(Integer costoPromedio, Integer cantidad, Integer capacidad, Integer nivelMinimoReorden) {
        this.costoPromedio = costoPromedio;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(Integer costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public Integer getNivelMinimoReorden() {
        return nivelMinimoReorden;
    }

    public void setNivelMinimoReorden(Integer nivelMinimoReorden) {
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    @Override
    public String toString() {
        return "InventarioDeProducto{" +
                "id=" + id +
                ", costoPromedio=" + costoPromedio +
                ", cantidad=" + cantidad +
                ", capacidad=" + capacidad +
                ", nivelMinimoReorden=" + nivelMinimoReorden +
                '}';
    }
}
