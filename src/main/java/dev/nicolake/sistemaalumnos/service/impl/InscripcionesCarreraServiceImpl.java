package dev.nicolake.sistemaalumnos.service.impl;

import dev.nicolake.sistemaalumnos.commons.GenericServiceImpl;
import dev.nicolake.sistemaalumnos.dao.api.InscripcionesCarreraDaoAPI;
import dev.nicolake.sistemaalumnos.model.Alumno;
import dev.nicolake.sistemaalumnos.model.InscripcionesCarrera;
import dev.nicolake.sistemaalumnos.service.api.InscripcionesCarreraServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InscripcionesCarreraServiceImpl extends GenericServiceImpl<InscripcionesCarrera, Integer> implements InscripcionesCarreraServiceAPI {

    @Autowired
    private InscripcionesCarreraDaoAPI cursoDaoAPI;

    @Override
    public List<InscripcionesCarrera> getInscripcionesPorAlumno(Alumno alumno) {
        List<InscripcionesCarrera> result = new ArrayList<>();
        cursoDaoAPI.findByAlumno(alumno).forEach(obj -> result.add(obj));
        return result;
    }

    @Override
    public CrudRepository<InscripcionesCarrera, Integer> getDao() {
        return cursoDaoAPI;
    }
}
