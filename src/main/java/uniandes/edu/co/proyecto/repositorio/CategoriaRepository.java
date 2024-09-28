package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


    @Query(value = "SELECT * FROM categoria", nativeQuery = true)
    Collection<Categoria> findAllCategorias();

 
    @Query(value = "SELECT * FROM categoria WHERE codigo = :codigo", nativeQuery = true)
    Categoria findCategoriaById(@Param("codigo") int codigo);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO categoria (codigo, nombre, descripcion, caracteristicas_almacenamiento) VALUES (:codigo, :nombre, :descripcion, :caracteristicasAlmacenamiento)", nativeQuery = true)
    void insertCategoria(@Param("codigo") int codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicasAlmacenamiento") String caracteristicasAlmacenamiento);

    
    @Modifying
    @Transactional
    @Query(value = "UPDATE categoria SET nombre = :nombre, descripcion = :descripcion, caracteristicas_almacenamiento = :caracteristicasAlmacenamiento WHERE codigo = :codigo", nativeQuery = true)
    void updateCategoria(@Param("codigo") int codigo, @Param("nombre") String nombre, @Param("descripcion") String descripcion, @Param("caracteristicasAlmacenamiento") String caracteristicasAlmacenamiento);

   
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM categoria WHERE codigo = :codigo", nativeQuery = true)
    void deleteCategoria(@Param("codigo") int codigo);
}