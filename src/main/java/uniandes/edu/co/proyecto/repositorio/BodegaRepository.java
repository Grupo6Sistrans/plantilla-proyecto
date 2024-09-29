package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.BodegaPK;


public interface BodegaRepository extends JpaRepository<Bodega, BodegaPK> {

    
    @Query(value = "SELECT * FROM bodega", nativeQuery = true)
    Collection<Bodega> findAllBodegas();

    
    @Query(value = "SELECT * FROM bodega WHERE id = :id", nativeQuery = true)
    Bodega findBodegaById(@Param("id") int id);

    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodega (id, nombre, tamano) VALUES (bodega_sequence.nextval, :nombre, :tamano)", nativeQuery = true)
    void insertBodega(@Param("nombre") String nombre, @Param("tamano") Integer tamano);

   
    @Modifying
    @Transactional
    @Query(value = "UPDATE bodega SET nombre = :nombre, tamano = :tamano WHERE id = :id", nativeQuery = true)
    void updateBodega(@Param("id") long id, @Param("nombre") String nombre, @Param("tamano") Integer tamano);

    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodega WHERE id = :id", nativeQuery = true)
    void deleteBodega(@Param("id") long id);
}
