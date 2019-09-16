package dev.nicolake.sistemaalumnos.controller;

import dev.nicolake.sistemaalumnos.model.*;
import dev.nicolake.sistemaalumnos.service.api.AlumnoServiceAPI;
import dev.nicolake.sistemaalumnos.service.api.InscripcionesCarreraServiceAPI;
import dev.nicolake.sistemaalumnos.service.api.InscripcionesCursoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoServiceAPI alumnoServiceAPI;

    @Autowired
    private InscripcionesCursoServiceAPI inscripcionesCursoServiceAPI;

    @Autowired
    private InscripcionesCarreraServiceAPI inscripcionesCarreraServiceAPI;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", alumnoServiceAPI.getAll());
        return "index";
    }

    @RequestMapping("/{identificador}")
    public String detalle(@PathVariable("identificador") Integer identificador, Model model) {
        Alumno alumno = alumnoServiceAPI.get(identificador);
        List<InscripcionesCurso> cursos = inscripcionesCursoServiceAPI.getInscripcionesPorAlumno(alumno);
        List<InscripcionesCarrera> carreras = inscripcionesCarreraServiceAPI.getInscripcionesPorAlumno(alumno);
        model.addAttribute("alumno", alumno);
        model.addAttribute("cursos", cursos);
        model.addAttribute("carreras", carreras);

        return "detallealumno";
    }

    @GetMapping("/save/{identificador}")
    public String showSave(@PathVariable("identificador") Integer identificador, Model model) {
        if (identificador != null && identificador != 0) {
            model.addAttribute("alumno", alumnoServiceAPI.get(identificador));
        } else {
            model.addAttribute("alumno", new Alumno());
        }

        return "save";
    }

    @PostMapping("/save")
    public String save(Alumno alumno, Model model) {
        alumnoServiceAPI.save(alumno);

        return "redirect:/";
    }
}
