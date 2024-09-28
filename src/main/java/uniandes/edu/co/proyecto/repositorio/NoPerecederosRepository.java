package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.NoPerecederos;

public interface NoPerecederosRepository extends JpaRepository<NoPerecederos, Integer> {

    @Query(value = "SELECT * FROM no_perecederos", nativeQuery = true)
    Collection<NoPerecederos> findAllNoPerecederos();

    @Query(value = "SELECT * FROM no_perecederos WHERE id = :id", nativeQuery = true)
    NoPerecederos findNoPerecederoById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO no_perecederos (id, nombre, descripcion) VALUES (:id, :nombre, :descripcion)", nativeQuery = true)
    void insertNoPerecedero(@Param("id") int id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE no_perecederos SET nombre = :nombre, descripcion = :descripcion WHERE id = :id", nativeQuery = true)
    void updateNoPerecedero(@Param("id") int id, @Param("nombre") String nombre, @Param("descripcion") String descripcion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM no_perecederos WHERE id = :id", nativeQuery = true)
    void deleteNoPerecedero(@Param("id") int id);
}
