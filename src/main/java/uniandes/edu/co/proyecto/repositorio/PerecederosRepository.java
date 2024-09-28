package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Perecederos;

public interface PerecederosRepository extends JpaRepository<Perecederos, Integer> {

    @Query(value = "SELECT * FROM perecederos", nativeQuery = true)
    Collection<Perecederos> findAllPerecederos();

    @Query(value = "SELECT * FROM perecederos WHERE id = :id", nativeQuery = true)
    Perecederos findPerecederoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO perecederos (id, fecha_expiracion) VALUES (:id, :fechaExpiracion)", nativeQuery = true)
    void insertPerecedero(@Param("id") int id, @Param("fechaExpiracion") String fechaExpiracion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE perecederos SET fecha_expiracion = :fechaExpiracion WHERE id = :id", nativeQuery = true)
    void updatePerecedero(@Param("id") int id, @Param("fechaExpiracion") String fechaExpiracion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM perecederos WHERE id = :id", nativeQuery = true)
    void deletePerecedero(@Param("id") int id);
}

