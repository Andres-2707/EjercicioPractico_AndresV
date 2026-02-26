package Caso1.AJVJ.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String inicio(Model model) {
        // Retorna la vista index.html (la página principal con la promoción y el video)
        return "index"; 
    }

    @GetMapping("/contacto")
    public String contacto(Model model) {
        // Retorna la vista contacto.html (el formulario de quejas y sugerencias)
        return "contacto"; 
    }
}
