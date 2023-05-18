package com.davidMembiela.proyecto.repositories;

import com.davidMembiela.proyecto.model.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositoryProducto extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM PRODUCTOS", nativeQuery = true)
    public List<Producto> findAll();

    @Query(value = "SELECT * FROM PRODUCTOS WHERE nombre = ?1", nativeQuery = true)
    public Producto findbyName(String name);

    @Query(value = "SELECT * FROM PRODUCTOS WHERE id = ?1", nativeQuery = true)
    public Producto findById(int id);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM productos where id =?1 ",nativeQuery = true)
    public void deleteProducto(int id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = ?1, precio = ?2 WHERE id = ?3", nativeQuery = true)
    public void editProducto(String nombre, double precio, int id);


    @Query(value = "SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Producto p WHERE p.id = :id")
    boolean existsProductobyId(@Param("id") int id);


}
