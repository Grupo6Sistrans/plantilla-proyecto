package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String codigoDeBarras;
    private String nombre;
    private Integer costoEnBodega;
    private Integer precioUnitario;
    private String presentacion;
    private Integer cantidadPresentacion;
   

    @Enumerated(EnumType.STRING)
    private UnidadDeMedida unidadDeMedida;

    private Integer volumen;
    private Integer peso;

    public Producto() {
        // Default constructor
    }

    public Producto(String codigoDeBarras, String nombre, Integer costoEnBodega, Integer precioUnitario, 
                    String presentacion, Integer cantidadPresentacion, UnidadDeMedida unidadDeMedida, 
                    Integer volumen, Integer peso) {
        this.codigoDeBarras = codigoDeBarras;
        this.nombre = nombre;
        this.costoEnBodega = costoEnBodega;
        this.precioUnitario = precioUnitario;
        this.presentacion = presentacion;
        this.cantidadPresentacion = cantidadPresentacion;
        this.unidadDeMedida = unidadDeMedida;
        this.volumen = volumen;
        this.peso = peso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCostoEnBodega() {
        return costoEnBodega;
    }

    public void setCostoEnBodega(Integer costoEnBodega) {
        this.costoEnBodega = costoEnBodega;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Integer getCantidadPresentacion() {
        return cantidadPresentacion;
    }

    public void setCantidadPresentacion(Integer cantidadPresentacion) {
        this.cantidadPresentacion = cantidadPresentacion;
    }

    public UnidadDeMedida getUnidadDeMedida() {
        return unidadDeMedida;
    }
    
    public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    public Integer getVolumen() {
        return volumen;
    }

    public void setVolumen(Integer volumen) {
        this.volumen = volumen;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigoDeBarras='" + codigoDeBarras + '\'' +
                ", nombre='" + nombre + '\'' +
                ", costoEnBodega=" + costoEnBodega +
                ", precioUnitario=" + precioUnitario +
                ", presentacion='" + presentacion + '\'' +
                ", cantidadPresentacion=" + cantidadPresentacion +
                ", unidadDeMedida='" + unidadDeMedida + '\'' +
                ", volumen=" + volumen +
                ", peso=" + peso +
                '}';
    }
}