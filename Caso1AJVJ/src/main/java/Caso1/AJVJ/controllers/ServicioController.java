package Caso1.AJVJ.controllers;

import Caso1.AJVJ.domain.Servicio;
import Caso1.AJVJ.service.CategoriaService;
import Caso1.AJVJ.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/servicio")
public class ServicioController {

    @Autowired
    private ServicioService servicioService;

    // Inyectamos también CategoriaService para poder listar las categorías en el formulario
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var servicios = servicioService.getServicios();
        model.addAttribute("servicios", servicios);
        return "/servicio/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Servicio servicio) {
        servicioService.save(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Servicio servicio) {
        servicioService.delete(servicio);
        return "redirect:/servicio/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Servicio servicio, Model model) {
        servicio = servicioService.getServicio(servicio);
        // Traemos las categorías para el "select" del formulario HTML
        var categorias = categoriaService.getCategorias(); 
        
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categorias);
        return "/servicio/modifica";
    }
}