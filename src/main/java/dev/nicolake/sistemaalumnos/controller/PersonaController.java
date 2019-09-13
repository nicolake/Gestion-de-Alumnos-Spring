package dev.nicolake.sistemaalumnos.controller;

import dev.nicolake.sistemaalumnos.model.Persona;
import dev.nicolake.sistemaalumnos.service.api.PersonaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonaController {

    @Autowired
    private PersonaServiceAPI personaServiceAPI;

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("list", personaServiceAPI.getAll());
        return "index";
    }

    @GetMapping("/save/{identificador}")
    public String showSave(@PathVariable("identificador") Integer id,  Model model){
        if(id!=null){
            model.addAttribute("persona", personaServiceAPI.get(id));
        }

        return "save";
    }

    @PostMapping("/save")
    public String save(Persona persona, Model model){
        personaServiceAPI.save(persona);

        return "redirect:/";
    }

    @GetMapping("/delete/{identificador}")
    public String delete(@PathVariable("identificador") Integer id, Model model){
        personaServiceAPI.delete(id);
        return "redirect:/";
    }
}
