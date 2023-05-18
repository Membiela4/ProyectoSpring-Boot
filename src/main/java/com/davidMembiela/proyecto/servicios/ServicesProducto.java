package com.davidMembiela.proyecto.servicios;

import com.davidMembiela.proyecto.model.Producto;
import com.davidMembiela.proyecto.repositories.RepositoryProducto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesProducto implements iServiceProducto {

    static RepositoryProducto repositoryProducto;

    public ServicesProducto(RepositoryProducto repositoryProducto) {this.repositoryProducto = repositoryProducto ;};

    @Override
    public List<Producto> getAllProduct() {
        return repositoryProducto.findAll();
    }

    public void save(Producto producto){
        repositoryProducto.save(producto);
    }
    @Override
    public Producto findByName(String name ) {
       return repositoryProducto.findbyName(name);
    }

    @Override
    public void deleteProduct(int id) {
        repositoryProducto.deleteProducto(id);
    }


    @Override
    public void editProduct(Producto producto) {
        repositoryProducto.editProducto(producto);
    }


}

