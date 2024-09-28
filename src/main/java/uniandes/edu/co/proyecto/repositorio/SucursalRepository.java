package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Sucursal;

public interface SucursalRepository extends JpaRepository<Sucursal, Integer> {

    @Query(value = "SELECT * FROM sucursal", nativeQuery = true)
    Collection<Sucursal> findAllSucursales();

    @Query(value = "SELECT * FROM sucursal WHERE id = :id", nativeQuery = true)
    Sucursal findSucursalById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO sucursal (id, nombre, direccion, ciudad) VALUES (:id, :nombre, :direccion, :ciudad)", nativeQuery = true)
    void insertSucursal(@Param("id") int id, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE sucursal SET nombre = :nombre, direccion = :direccion, ciudad = :ciudad WHERE id = :id", nativeQuery = true)
    void updateSucursal(@Param("id") int id, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("ciudad") String ciudad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM sucursal WHERE id = :id", nativeQuery = true)
    void deleteSucursal(@Param("id") int id);
}
