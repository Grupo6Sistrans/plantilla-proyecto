package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {
    @Id
    private Integer NIT;

    private String nombre;
    private String direccion;
    private String nombreContacto;
    private Integer telefonoContacto;

    public Proveedor() {
        // Default constructor
    }

    public Proveedor(Integer NIT, String nombre, String direccion, String nombreContacto, Integer telefonoContacto) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nombreContacto = nombreContacto;
        this.telefonoContacto = telefonoContacto;
    }

    public Integer getNIT() {
        return NIT;
    }

    public void setNIT(Integer NIT) {
        this.NIT = NIT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public Integer getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(Integer telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "NIT=" + NIT +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", telefonoContacto=" + telefonoContacto +
                '}';
    }
}
