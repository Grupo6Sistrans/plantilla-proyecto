package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "no_perecederos")
public class NoPerecederos extends Categoria {
    private String material;
    private String instruccionesUso;

    public NoPerecederos() {
        // Default constructor
    }

    public NoPerecederos(String nombre, String descripcion, String caracteristicasAlmacenamiento, String material, String instruccionesUso) {
        super(nombre, descripcion, caracteristicasAlmacenamiento);
        this.material = material;
        this.instruccionesUso = instruccionesUso;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getInstruccionesUso() {
        return instruccionesUso;
    }

    public void setInstruccionesUso(String instruccionesUso) {
        this.instruccionesUso = instruccionesUso;
    }

    @Override
    public String toString() {
        return "NoPerecederos{" +
                "codigo=" + getCodigo() +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", caracteristicasAlmacenamiento='" + getCaracteristicasAlmacenamiento() + '\'' +
                ", material='" + material + '\'' +
                ", instruccionesUso='" + instruccionesUso + '\'' +
                '}';
    }
}