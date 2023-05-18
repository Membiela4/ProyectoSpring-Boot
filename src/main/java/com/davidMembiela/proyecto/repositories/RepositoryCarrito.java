package com.davidMembiela.proyecto.repositories;

import com.davidMembiela.proyecto.model.Carrito;
import com.davidMembiela.proyecto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepositoryCarrito extends JpaRepository<Carrito, Long>{

    @Query(value = "SELECT * FROM carrito", nativeQuery = true)
    public List<Carrito> findAll();

}
