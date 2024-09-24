package com.example.crud_sensillo.Estudiante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.crud_sensillo.Estudiante.Estudiante;
import com.example.crud_sensillo.Estudiante.ServiciosEstudiante;


import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class ControladorEstudiante {


    @Autowired
    private ServiciosEstudiante serviciosEstudiante;


    @GetMapping
    public String obtenerEstudiantes(Model model) {
        List<Estudiante> estudiantes = serviciosEstudiante.obtenerTodos();
        model.addAttribute("estudiantes", estudiantes);
        return "index"; }


    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("estudiante", new Estudiante());
        return "nuevo-estudiante";
    }


    @PostMapping
    public String crearEstudiante(@ModelAttribute Estudiante estudiante) {
        serviciosEstudiante.guardar(estudiante);
        return "redirect:/estudiantes";
    }


    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Estudiante estudiante = serviciosEstudiante.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        model.addAttribute("estudiante", estudiante);
        return "editar-estudiante";
    }


    @PostMapping("/editar/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute Estudiante estudianteActualizado) {
        serviciosEstudiante.actualizar(id, estudianteActualizado);
        return "redirect:/estudiantes";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarEstudiante(@PathVariable Long id) {
        serviciosEstudiante.eliminar(id);
        return "redirect:/estudiantes";
    }
}
