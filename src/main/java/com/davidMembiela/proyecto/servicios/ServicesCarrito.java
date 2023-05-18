package com.davidMembiela.proyecto.servicios;

import com.davidMembiela.proyecto.model.Carrito;
import com.davidMembiela.proyecto.model.Producto;
import com.davidMembiela.proyecto.repositories.RepositoryCarrito;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ServicesCarrito implements iServiceCarrito {

    RepositoryCarrito repositoryCarrito;

    public ServicesCarrito(RepositoryCarrito repositoryCarrito) {
        this.repositoryCarrito = repositoryCarrito;
    }


    @Override
    public List<Producto> getProducts() {
        return null;
    }

    @Override
    public List<Producto> getProducts(Carrito c) {
        List<Producto> productos = new ArrayList<>();
        productos = (List<Producto>) c.getProdutoes();

        return productos;
    }

    @Override
    public double totalPrice(Carrito c) {
        Set<Producto> productos = c.getProdutoes();
        double precioTotal = 0;
        for (Producto p : productos ) {
            precioTotal += p.getPrecio();
        }

        return precioTotal;
    }
}
