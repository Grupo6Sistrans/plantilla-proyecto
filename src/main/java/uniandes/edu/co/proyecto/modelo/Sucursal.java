package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursales")
public class Sucursal {
    
    @Id
    private String nombre;
    private Integer tamanio;
    private String direccion;
    private Integer telefono;

    public Sucursal() {
        // Default constructor
    }

    public Sucursal(String nombre, Integer tamanio, String direccion, Integer telefono) {
        this.nombre = nombre;
        this.tamanio = tamanio;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer gettamanio() {
        return tamanio;
    }

    public void settamanio(Integer tamanio) {
        this.tamanio = tamanio;
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
                ", tamanio=" + tamanio +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}