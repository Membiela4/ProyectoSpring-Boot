package com.davidMembiela.proyecto.servicios;

import com.davidMembiela.proyecto.model.Producto;

import java.util.List;

public interface iServiceProducto {
   public List<Producto> getAllProduct();
    public Producto findByName(String name);
    public Producto findById(int id);
    public void deleteProduct(int id);
    public void editProduct(int id, String nombre, double precio);
}
