package com.davidMembiela.proyecto.repositories;

import com.davidMembiela.proyecto.model.Producto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositoryProducto extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM PRODUCTOS", nativeQuery = true)
    public List<Producto> findAll();

    @Query(value = "SELECT * FROM PRODUCTOS WHERE nombre = ?1", nativeQuery = true)
    public Producto findbyName(String name);

    @Modifying
    @Transactional
    @Query(value="DELETE FROM productos where id =?1 ",nativeQuery = true)
    public void deleteProducto(int id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos set precio = ?1", nativeQuery = true)
    public void editProducto(Producto producto);


}
