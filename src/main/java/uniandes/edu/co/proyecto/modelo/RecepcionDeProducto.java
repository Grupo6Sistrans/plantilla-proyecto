package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recepcion_de_productos")
public class RecepcionDeProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public RecepcionDeProducto() {
        // Default constructor
    }

    public RecepcionDeProducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "RecepcionDeProducto{" +
                "id=" + id +
                '}';
    }
}