package dev.nicolake.sistemaalumnos.service.impl;

import dev.nicolake.sistemaalumnos.commons.GenericServiceImpl;
import dev.nicolake.sistemaalumnos.dao.api.InscripcionesCursoDaoAPI;
import dev.nicolake.sistemaalumnos.model.Curso;
import dev.nicolake.sistemaalumnos.model.InscripcionesCurso;
import dev.nicolake.sistemaalumnos.service.api.InscripcionesCursoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InscripcionesCursoServiceImpl extends GenericServiceImpl<InscripcionesCurso, Integer> implements InscripcionesCursoServiceAPI {

    @Autowired
    private InscripcionesCursoDaoAPI cursoDaoAPI;

    public List<InscripcionesCurso> getInscripcionesPorCurso(Curso curso) {

        List<InscripcionesCurso> result = new ArrayList<>();
        cursoDaoAPI.findByCurso(curso).forEach(obj-> result.add(obj));
        return result;
    }

    @Override
    public CrudRepository<InscripcionesCurso, Integer> getDao() {
        return cursoDaoAPI;
    }
}
