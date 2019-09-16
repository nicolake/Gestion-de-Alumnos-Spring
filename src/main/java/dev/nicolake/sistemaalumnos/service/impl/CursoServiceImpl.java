package dev.nicolake.sistemaalumnos.service.impl;

import dev.nicolake.sistemaalumnos.commons.GenericServiceImpl;
import dev.nicolake.sistemaalumnos.dao.api.CursoDaoAPI;
import dev.nicolake.sistemaalumnos.model.Carrera;
import dev.nicolake.sistemaalumnos.model.Curso;
import dev.nicolake.sistemaalumnos.service.api.CursoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Integer> implements CursoServiceAPI {

    @Autowired
    private CursoDaoAPI cursoDaoAPI;

    @Override
    public CrudRepository<Curso, Integer> getDao() {
        return cursoDaoAPI;
    }

    @Override
    public List<Curso> getCursosDisponibles(List<Integer> cursos, List<Carrera> carreras) {
        return cursoDaoAPI.findByIdentificadorNotInAndCarreraIn(cursos, carreras);
    }
}
