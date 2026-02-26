/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Caso1.AJVJ.service;

import Caso1.AJVJ.domain.Servicio;
import java.util.List;

public interface ServicioService {
    public List<Servicio> getServicios();
    public Servicio getServicio(Servicio servicio);
    public void save(Servicio servicio);
    public void delete(Servicio servicio);
}