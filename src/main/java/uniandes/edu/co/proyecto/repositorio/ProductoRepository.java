package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT * FROM producto", nativeQuery = true)
    Collection<Producto> findAllProductos();

    @Query(value = "SELECT * FROM producto WHERE codigo_de_barras = :codigoDeBarras", nativeQuery = true)
    Producto findProductoByCodigoDeBarras(@Param("codigoDeBarras") String codigoDeBarras);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO producto (codigo_de_barras, nombre, costo_en_bodega, precio_unitario, presentacion, cantidad_presentacion, unidad_de_medida, volumen, peso) VALUES (:codigoDeBarras, :nombre, :costoEnBodega, :precioUnitario, :presentacion, :cantidadPresentacion, :unidadDeMedida, :volumen, :peso)", nativeQuery = true)
    void insertProducto(@Param("codigoDeBarras") String codigoDeBarras, @Param("nombre") String nombre, @Param("costoEnBodega") Integer costoEnBodega, @Param("precioUnitario") Integer precioUnitario, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadDeMedida") String unidadDeMedida, @Param("volumen") Integer volumen, @Param("peso") Integer peso);

    @Modifying
    @Transactional
    @Query(value = "UPDATE producto SET nombre = :nombre, costo_en_bodega = :costoEnBodega, precio_unitario = :precioUnitario, presentacion = :presentacion, cantidad_presentacion = :cantidadPresentacion, unidad_de_medida = :unidadDeMedida, volumen = :volumen, peso = :peso WHERE codigo_de_barras = :codigoDeBarras", nativeQuery = true)
    void updateProducto(@Param("codigoDeBarras") String codigoDeBarras, @Param("nombre") String nombre, @Param("costoEnBodega") Integer costoEnBodega, @Param("precioUnitario") Integer precioUnitario, @Param("presentacion") String presentacion, @Param("cantidadPresentacion") Integer cantidadPresentacion, @Param("unidadDeMedida") String unidadDeMedida, @Param("volumen") Integer volumen, @Param("peso") Integer peso);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM producto WHERE codigo_de_barras = :codigoDeBarras", nativeQuery = true)
    void deleteProducto(@Param("codigoDeBarras") String codigoDeBarras);
}
