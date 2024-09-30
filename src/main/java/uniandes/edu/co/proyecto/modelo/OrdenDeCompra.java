package uniandes.edu.co.proyecto.modelo;

import java.util.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ordenes_de_compra")
public class OrdenDeCompra {
    @EmbeddedId
    private OrdenDeCompraPK id;

    private Date fechaCreacion;
    private Date fechaEntrega;

    @ManyToOne
    private Proveedor proveedor;

    @Enumerated(EnumType.STRING)
    private EstadoCompra estado;

    public OrdenDeCompra() {
        
    }

    public OrdenDeCompra(OrdenDeCompraPK id, Date fechaCreacion, Date fechaEntrega, EstadoCompra estado) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    public OrdenDeCompraPK getId() {
        return id;
    }

    public void setId(OrdenDeCompraPK id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public EstadoCompra getEstado() {
        return estado;
    }

    public void setEstado(EstadoCompra estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "OrdenDeCompra{" +
                "id=" + id +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaEntrega=" + fechaEntrega +
                ", estado=" + estado +
                '}';
    }
}
