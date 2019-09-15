package dev.nicolake.sistemaalumnos.dao.api;

import dev.nicolake.sistemaalumnos.model.Curso;
import dev.nicolake.sistemaalumnos.model.InscripcionesCurso;
import org.springframework.data.repository.CrudRepository;

public interface InscripcionesCursoDaoAPI extends CrudRepository<InscripcionesCurso, Integer> {
    Iterable<InscripcionesCurso> findByCurso(Curso curso);
}
