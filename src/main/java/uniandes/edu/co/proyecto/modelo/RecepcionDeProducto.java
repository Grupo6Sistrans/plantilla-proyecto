package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "recepcion_de_productos")
public class RecepcionDeProducto {
    @EmbeddedId
    private RecepcionDeProductoPK id;

    public RecepcionDeProducto() {
        // Default constructor
    }

    public RecepcionDeProducto(RecepcionDeProductoPK id) {
        this.id = id;
    }

    public RecepcionDeProductoPK getId() {
        return id;
    }

    public void setId(RecepcionDeProductoPK id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecepcionDeProducto{" +
                "id=" + id +
                '}';
    }
}
