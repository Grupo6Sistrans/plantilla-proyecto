package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventario_de_productos")
public class InventarioDeProducto {
    @EmbeddedId
    private InventarioDeProductoPK id;

    private Integer costoPromedio;
    private Integer cantidad;
    private Integer capacidad;
    private Integer nivelMinimoReorden;

    public InventarioDeProducto() {
        // Default constructor
    }

    public InventarioDeProducto(InventarioDeProductoPK id, Integer costoPromedio, Integer cantidad, Integer capacidad, Integer nivelMinimoReorden) {
        this.id = id;
        this.costoPromedio = costoPromedio;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.nivelMinimoReorden = nivelMinimoReorden;
    }

    public InventarioDeProductoPK getId() {
        return id;
    }

    public void setId(InventarioDeProductoPK id) {
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
