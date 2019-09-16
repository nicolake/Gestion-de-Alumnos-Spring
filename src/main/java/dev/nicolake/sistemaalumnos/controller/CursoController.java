package dev.nicolake.sistemaalumnos.controller;

import dev.nicolake.sistemaalumnos.model.*;
import dev.nicolake.sistemaalumnos.service.api.AlumnoServiceAPI;
import dev.nicolake.sistemaalumnos.service.api.CursoServiceAPI;
import dev.nicolake.sistemaalumnos.service.api.InscripcionesCarreraServiceAPI;
import dev.nicolake.sistemaalumnos.service.api.InscripcionesCursoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CursoController {
    @Autowired
    private CursoServiceAPI cursoServiceAPI;

    @Autowired
    private AlumnoServiceAPI alumnoServiceAPI;

    @Autowired
    private InscripcionesCursoServiceAPI inscripcionesCursoServiceAPI;

    @Autowired
    private InscripcionesCarreraServiceAPI inscripcionesCarreraServiceAPI;

    @RequestMapping("/cursos")
    public String index(Model model) {
        model.addAttribute("list", cursoServiceAPI.getAll());
        return "cursos";
    }

    @RequestMapping("/inscripcion/{identificador}")
    public String inscripcion(@PathVariable("identificador") Integer identificador, Model model) {
        Alumno alumno = alumnoServiceAPI.get(identificador);
        List<InscripcionesCurso> inscripcionesCursos = inscripcionesCursoServiceAPI.getInscripcionesPorAlumno(alumno);
        List<InscripcionesCarrera> inscripcionesCarreras = inscripcionesCarreraServiceAPI.getInscripcionesPorAlumno(alumno);
        List<Integer> cursosAExcluir = new ArrayList<>();
        for (InscripcionesCurso inscripciones : inscripcionesCursos) {
            cursosAExcluir.add(inscripciones.getCurso().getIdentificador());
        }

        List<Carrera> carrerasAIncluir = new ArrayList<>();
        for (InscripcionesCarrera inscripciones : inscripcionesCarreras) {
            carrerasAIncluir.add(inscripciones.getCarrera());
        }

        List<Curso> cursosDisponibles = cursoServiceAPI.getCursosDisponibles(cursosAExcluir, carrerasAIncluir);
        model.addAttribute("alumno", alumno);
        model.addAttribute("cursos", cursosDisponibles);
        InscripcionesCurso inscripcionesCurso = new InscripcionesCurso();
        inscripcionesCurso.setAlumno(alumno);
        model.addAttribute("inscripcion", inscripcionesCurso);
        return "inscripcion";
    }

    @PostMapping("/inscripto")
    public String save(@ModelAttribute InscripcionesCurso inscripcionCurso, Model model) {
        inscripcionCurso.setFechainscripcion(LocalDate.now());
        inscripcionCurso.setAlumnocurso(new AlumnoCurso(inscripcionCurso.getAlumno().getIdentificador(), inscripcionCurso.getCurso().getIdentificador()));
        inscripcionCurso.setNota(0);
        inscripcionesCursoServiceAPI.save(inscripcionCurso);
        return "redirect:/";
    }

    @GetMapping("/curso/{identificador}")
    public String muestraDetalle(@PathVariable("identificador") Integer identificador, Model model) {
        Curso curso = new Curso();
        curso.setIdentificador(identificador);
        List<InscripcionesCurso> lista = inscripcionesCursoServiceAPI.getInscripcionesPorCurso(curso);
        model.addAttribute("list", lista);

        return "curso";
    }
}
