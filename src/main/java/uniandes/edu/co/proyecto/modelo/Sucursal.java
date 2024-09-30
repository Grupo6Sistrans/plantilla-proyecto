package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursales")
public class Sucursal {
    
    @Id
    private String nombre;
    private Integer tamano;
    private String direccion;
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "fk_ciudad", referencedColumnName = "codigo")
    private Ciudad ciudad;

    public Sucursal() {;}

    public Sucursal(String nombre, Integer tamano, String direccion, Integer telefono, Ciudad ciudad) {
        this.nombre = nombre;
        this.tamano = tamano;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
    }

    // Getters y Setters
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "nombre='" + nombre + '\'' +
                ", tamano=" + tamano +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}