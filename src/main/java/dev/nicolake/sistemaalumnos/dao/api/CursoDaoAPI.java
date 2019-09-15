package dev.nicolake.sistemaalumnos.dao.api;

import dev.nicolake.sistemaalumnos.model.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CursoDaoAPI extends CrudRepository<Curso, Integer> {

}
