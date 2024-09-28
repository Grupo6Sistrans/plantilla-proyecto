package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import uniandes.edu.co.proyecto.modelo.UnidadDeMedida;

public interface UnidadDeMedidaRepository extends JpaRepository<UnidadDeMedida, String> {

    @Query(value = "SELECT * FROM unidad_de_medida", nativeQuery = true)
    Collection<UnidadDeMedida> findAllUnidadesDeMedida();
}
