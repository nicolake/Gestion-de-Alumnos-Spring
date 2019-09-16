package dev.nicolake.sistemaalumnos.dao.api;

import dev.nicolake.sistemaalumnos.model.Carrera;
import dev.nicolake.sistemaalumnos.model.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoDaoAPI extends CrudRepository<Curso, Integer> {
    List<Curso> findByIdentificadorNotInAndCarreraIn(List<Integer> cursos, List<Carrera> carrera);
}
