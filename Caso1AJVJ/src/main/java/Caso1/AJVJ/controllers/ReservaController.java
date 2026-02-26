package Caso1.AJVJ.controllers;

import Caso1.AJVJ.domain.Reserva;
import Caso1.AJVJ.service.ReservaService;
import Caso1.AJVJ.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    // Inyectamos el servicio de "Servicio" para poblar el select en la vista
    @Autowired
    private ServicioService servicioService; 

    @GetMapping("/listado")
    public String listado(Model model) {
        var reservas = reservaService.getReservas();
        model.addAttribute("reservas", reservas);
        return "/reserva/listado";
    }

    @PostMapping("/guardar")
    public String guardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);
        var servicios = servicioService.getServicios(); // Traemos todos los servicios
        
        model.addAttribute("reserva", reserva);
        model.addAttribute("servicios", servicios);
        return "/reserva/modifica";
    }
}
