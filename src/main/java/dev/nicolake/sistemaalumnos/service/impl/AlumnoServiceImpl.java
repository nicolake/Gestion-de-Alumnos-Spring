package dev.nicolake.sistemaalumnos.service.impl;

import dev.nicolake.sistemaalumnos.commons.GenericServiceImpl;
import dev.nicolake.sistemaalumnos.dao.api.AlumnoDaoAPI;
import dev.nicolake.sistemaalumnos.model.Alumno;
import dev.nicolake.sistemaalumnos.service.api.AlumnoServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AlumnoServiceImpl extends GenericServiceImpl<Alumno, Integer> implements AlumnoServiceAPI {

    @Autowired
    private AlumnoDaoAPI alumnoDaoAPI;

    @Override
    public CrudRepository<Alumno, Integer> getDao() {
        return alumnoDaoAPI;
    }
}
