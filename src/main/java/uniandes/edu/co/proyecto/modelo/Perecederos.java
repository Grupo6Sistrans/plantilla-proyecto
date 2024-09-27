package uniandes.edu.co.proyecto.modelo;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "perecederos")
public class Perecederos extends Categoria {
    private Integer diasCaducidad;
    private String condicionesEspeciales;

    public Perecederos() {
        // Default constructor
    }

    public Perecederos(String nombre, String descripcion, String caracteristicasAlmacenamiento, Integer diasCaducidad, String condicionesEspeciales) {
        super(nombre, descripcion, caracteristicasAlmacenamiento);
        this.diasCaducidad = diasCaducidad;
        this.condicionesEspeciales = condicionesEspeciales;
    }

    public Integer getDiasCaducidad() {
        return diasCaducidad;
    }

    public void setDiasCaducidad(Integer diasCaducidad) {
        this.diasCaducidad = diasCaducidad;
    }

    public String getCondicionesEspeciales() {
        return condicionesEspeciales;
    }

    public void setCondicionesEspeciales(String condicionesEspeciales) {
        this.condicionesEspeciales = condicionesEspeciales;
    }

    @Override
    public String toString() {
        return "Perecederos{" +
                "codigo=" + getCodigo() +
                ", nombre='" + getNombre() + '\'' +
                ", descripcion='" + getDescripcion() + '\'' +
                ", caracteristicasAlmacenamiento='" + getCaracteristicasAlmacenamiento() + '\'' +
                ", diasCaducidad=" + diasCaducidad +
                ", condicionesEspeciales='" + condicionesEspeciales + '\'' +
                '}';
    }
}