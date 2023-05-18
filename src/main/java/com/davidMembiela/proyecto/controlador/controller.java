package com.davidMembiela.proyecto.controlador;

import com.davidMembiela.proyecto.model.Producto;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import com.davidMembiela.proyecto.servicios.ServicesProducto;

import java.util.List;

@Controller
public class controller {

    @Autowired
    public ServicesProducto servicesProducto;

    public controller(ServicesProducto servicesProducto){

        this.servicesProducto = servicesProducto;
    }

    @GetMapping("/welcome")
    public String welcomeDefault(Model model){
        model.addAttribute("persona", "david");
        return "welcome";
    }

    @GetMapping("/prueba/{str}/{id}/{cod}")
    public String p2(@PathVariable String str,
                     @PathVariable int id,
                     @PathVariable int cod,
                     Model model){
        model.addAttribute("str", str);
        model.addAttribute("id", id);
        model.addAttribute("cod", cod);
        return "prueba";
    }
    @GetMapping("/productos")
    public String ListaProductos(Model model){
        List<Producto> productos = servicesProducto.getAllProduct();
        model.addAttribute("productos", productos);
        return "listaProductos";
    }

    @GetMapping("/productos/nuevo")
    public String productoNuevo(Model model){
        model.addAttribute("producto", new Producto() );
        return "registroProducto";
    }


    @PostMapping("/productos/nuevo")
    public Object saveProduct( @ModelAttribute("producto") Producto producto, Model model) {
        servicesProducto.save(producto);
        return new RedirectView("/productos");
    }
    @GetMapping("/productos/delete/{id}")
    public RedirectView deleteProducto(@PathVariable int id) {
        servicesProducto.deleteProduct(id);
        return new RedirectView("/productos");
    }
    /*


    @PostMapping("/productos")
    public RedirectView editProducto(@ModelAttribute("producto") Producto producto, Model model) {
        servicesProducto.deleteProduct(producto);
        return new RedirectView("/productos");
    }
    */


}
