package com.davidMembiela.proyecto.controlador;

import com.davidMembiela.proyecto.model.Carrito;
import com.davidMembiela.proyecto.servicios.ServicesCarrito;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
    public class CarritoController {

        private final ServicesCarrito carritoService;

        public CarritoController(ServicesCarrito carritoService) {
            this.carritoService = carritoService;
        }

        @PostMapping("/carrito/agregar")
        public String agregarAlCarrito(@RequestParam("productoId") int productoId) {
            carritoService.agregarAlCarrito(productoId);
            return "redirect:/productos";
        }

    @GetMapping("/carrito")
    public String mostrarCarrito(Model model) {
        Carrito carrito = carritoService.obtenerCarrito();
        model.addAttribute("carrito", carrito);
        return "carrito";
    }
    }
