package dev.nicolake.sistemaalumnos.service.api;

import dev.nicolake.sistemaalumnos.commons.GenericServiceAPI;
import dev.nicolake.sistemaalumnos.model.Carrera;
import dev.nicolake.sistemaalumnos.model.Curso;

import java.util.List;

public interface CursoServiceAPI extends GenericServiceAPI<Curso, Integer> {
    List<Curso> getCursosDisponibles(List<Integer> cursos, List<Carrera> carreras);
}
