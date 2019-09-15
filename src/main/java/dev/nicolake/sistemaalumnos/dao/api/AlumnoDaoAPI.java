package dev.nicolake.sistemaalumnos.dao.api;

import dev.nicolake.sistemaalumnos.model.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoDaoAPI extends CrudRepository<Alumno, Integer> {
}
