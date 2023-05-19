package com.davidMembiela.proyecto.servicios;

import com.davidMembiela.proyecto.model.Carrito;
import com.davidMembiela.proyecto.model.Producto;
import com.davidMembiela.proyecto.repositories.RepositoryCarrito;
import com.davidMembiela.proyecto.repositories.RepositoryProducto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ServicesCarrito implements iServiceCarrito {

    RepositoryCarrito repositoryCarrito;
    RepositoryProducto productoRepository;



    public ServicesCarrito(RepositoryCarrito repositoryCarrito, RepositoryProducto repositoryProducto) {
        this.repositoryCarrito = repositoryCarrito;this.productoRepository = repositoryProducto;
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
    @Override
    public void agregarAlCarrito(int productoId) {

        Producto p = productoRepository.findById(productoId);
        if (p!=null) {
            Producto producto = p;

            Carrito carrito =obtenerCarrito() ;
            carrito.getProdutoes().add(producto);
            repositoryCarrito.save(carrito);
        } else {
            throw new IllegalArgumentException("El producto con ID " + productoId + " no existe.");
        }
    }

    public Carrito obtenerCarrito() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        HttpSession session = request.getSession();

        Carrito carrito = (Carrito) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }

        return carrito;
    }
}
