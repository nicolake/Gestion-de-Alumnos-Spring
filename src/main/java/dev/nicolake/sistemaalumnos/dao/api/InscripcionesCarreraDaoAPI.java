package dev.nicolake.sistemaalumnos.dao.api;

import dev.nicolake.sistemaalumnos.model.Alumno;
import dev.nicolake.sistemaalumnos.model.InscripcionesCarrera;
import org.springframework.data.repository.CrudRepository;

public interface InscripcionesCarreraDaoAPI extends CrudRepository<InscripcionesCarrera, Integer> {
    Iterable<InscripcionesCarrera> findByAlumno(Alumno alumno);
}
