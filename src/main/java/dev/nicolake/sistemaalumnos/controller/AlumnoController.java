package dev.nicolake.sistemaalumnos.controller;

import dev.nicolake.sistemaalumnos.model.Alumno;
import dev.nicolake.sistemaalumnos.service.api.AlumnoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoServiceAPI alumnoServiceAPI;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list", alumnoServiceAPI.getAll());
        return "index";
    }

    @GetMapping("/save/{identificador}")
    public String showSave(@PathVariable("identificador") Integer id, Model model) {
        if (id != null) {
            model.addAttribute("persona", alumnoServiceAPI.get(id));
        }

        return "save";
    }

    @PostMapping("/save")
    public String save(Alumno alumno, Model model) {
        alumnoServiceAPI.save(alumno);

        return "redirect:/";
    }

    @GetMapping("/delete/{identificador}")
    public String delete(@PathVariable("identificador") Integer id, Model model) {
        alumnoServiceAPI.delete(id);
        return "redirect:/";
    }
}
