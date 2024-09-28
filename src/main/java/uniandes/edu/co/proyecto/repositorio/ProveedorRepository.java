package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Integer> {

    @Query(value = "SELECT * FROM proveedor", nativeQuery = true)
    Collection<Proveedor> findAllProveedores();

    @Query(value = "SELECT * FROM proveedor WHERE nit = :nit", nativeQuery = true)
    Proveedor findProveedorByNit(@Param("nit") int nit);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO proveedor (nit, nombre, direccion, nombre_contacto, telefono_contacto) VALUES (:nit, :nombre, :direccion, :nombreContacto, :telefonoContacto)", nativeQuery = true)
    void insertProveedor(@Param("nit") int nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombreContacto") String nombreContacto, @Param("telefonoContacto") Integer telefonoContacto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE proveedor SET nombre = :nombre, direccion = :direccion, nombre_contacto = :nombreContacto, telefono_contacto = :telefonoContacto WHERE nit = :nit", nativeQuery = true)
    void updateProveedor(@Param("nit") int nit, @Param("nombre") String nombre, @Param("direccion") String direccion, @Param("nombreContacto") String nombreContacto, @Param("telefonoContacto") Integer telefonoContacto);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM proveedor WHERE nit = :nit", nativeQuery = true)
    void deleteProveedor(@Param("nit") int nit);
}
