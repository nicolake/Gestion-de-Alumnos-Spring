package dev.nicolake.sistemaalumnos.controller;

import dev.nicolake.sistemaalumnos.model.Curso;
import dev.nicolake.sistemaalumnos.model.InscripcionesCurso;
import dev.nicolake.sistemaalumnos.service.api.CursoServiceAPI;
import dev.nicolake.sistemaalumnos.service.api.InscripcionesCursoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CursoController {
    @Autowired
    private CursoServiceAPI cursoServiceAPI;

    @Autowired
    private InscripcionesCursoServiceAPI inscripcionesCursoServiceAPI;

    @RequestMapping("/cursos")
    public String index(Model model) {
        model.addAttribute("list", cursoServiceAPI.getAll());
        return "cursos";
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
