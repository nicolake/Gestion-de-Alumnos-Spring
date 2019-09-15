package dev.nicolake.sistemaalumnos.controller;

import dev.nicolake.sistemaalumnos.model.Persona;
import dev.nicolake.sistemaalumnos.service.api.PersonaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonaController {

    @Autowired
    private PersonaServiceAPI personaServiceAPI;

    @RequestMapping("/personas")
    public String index(Model model){
        model.addAttribute("list", personaServiceAPI.getAll());
        return "index";
    }
}
