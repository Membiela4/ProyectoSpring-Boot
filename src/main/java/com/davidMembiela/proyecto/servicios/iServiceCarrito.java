package com.davidMembiela.proyecto.servicios;

import com.davidMembiela.proyecto.model.Carrito;
import com.davidMembiela.proyecto.model.Producto;

import java.util.List;

public interface iServiceCarrito {

    public List<Producto> getProducts();

    List<Producto> getProducts(Carrito c);

    public double totalPrice(Carrito c);

    public void agregarAlCarrito(int id);
}
