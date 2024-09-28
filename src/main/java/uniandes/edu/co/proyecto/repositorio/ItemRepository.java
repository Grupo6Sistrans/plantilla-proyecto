package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(value = "SELECT * FROM item", nativeQuery = true)
    Collection<Item> findAllItems();

    @Query(value = "SELECT * FROM item WHERE id = :id", nativeQuery = true)
    Item findItemById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO item (id, cantidad, precio) VALUES (:id, :cantidad, :precio)", nativeQuery = true)
    void insertItem(@Param("id") int id, @Param("cantidad") Integer cantidad, @Param("precio") Integer precio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE item SET cantidad = :cantidad, precio = :precio WHERE id = :id", nativeQuery = true)
    void updateItem(@Param("id") int id, @Param("cantidad") Integer cantidad, @Param("precio") Integer precio);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM item WHERE id = :id", nativeQuery = true)
    void deleteItem(@Param("id") int id);
}
