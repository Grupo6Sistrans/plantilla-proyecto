package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.modelo.OrdenDeCompraPK;

public interface OrdenCompraRepository extends JpaRepository<OrdenDeCompra, OrdenDeCompraPK> {

    @Query(value = "SELECT * FROM orden_de_compra", nativeQuery = true)
    Collection<OrdenDeCompra> findAllOrdenesCompra();

    @Query(value = "SELECT * FROM orden_de_compra WHERE codigo = :codigo", nativeQuery = true)
    OrdenDeCompra findOrdenCompraByCodigo(@Param("codigo") int codigo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO orden_de_compra (codigo, fecha_creacion, fecha_entrega, estado) VALUES (:codigo, :fechaCreacion, :fechaEntrega, :estado)", nativeQuery = true)
    void insertOrdenCompra(@Param("codigo") int codigo, @Param("fechaCreacion") String fechaCreacion, @Param("fechaEntrega") String fechaEntrega, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE orden_de_compra SET fecha_creacion = :fechaCreacion, fecha_entrega = :fechaEntrega, estado = :estado WHERE codigo = :codigo", nativeQuery = true)
    void updateOrdenCompra(@Param("codigo") int codigo, @Param("fechaCreacion") String fechaCreacion, @Param("fechaEntrega") String fechaEntrega, @Param("estado") String estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM orden_de_compra WHERE codigo = :codigo", nativeQuery = true)
    void deleteOrdenCompra(@Param("codigo") int codigo);
}

