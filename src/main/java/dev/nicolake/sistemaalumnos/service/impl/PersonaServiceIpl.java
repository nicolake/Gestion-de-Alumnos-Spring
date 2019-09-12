package dev.nicolake.sistemaalumnos.service.impl;

import dev.nicolake.sistemaalumnos.commons.GenericServiceImpl;
import dev.nicolake.sistemaalumnos.dao.api.PersonaDaoAPI;
import dev.nicolake.sistemaalumnos.model.Persona;
import dev.nicolake.sistemaalumnos.service.api.PersonaServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceIpl extends GenericServiceImpl<Persona, Integer> implements PersonaServiceAPI {
    @Autowired
    private PersonaDaoAPI personaDaoAPI;

    @Override
    public CrudRepository<Persona, Integer> getDao() {
        return personaDaoAPI;
    }
}
