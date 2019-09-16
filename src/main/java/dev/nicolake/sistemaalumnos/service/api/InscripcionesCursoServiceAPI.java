package dev.nicolake.sistemaalumnos.service.api;

import dev.nicolake.sistemaalumnos.commons.GenericServiceAPI;
import dev.nicolake.sistemaalumnos.model.Alumno;
import dev.nicolake.sistemaalumnos.model.Curso;
import dev.nicolake.sistemaalumnos.model.InscripcionesCurso;

import java.util.List;

public interface InscripcionesCursoServiceAPI extends GenericServiceAPI<InscripcionesCurso, Integer> {
    List<InscripcionesCurso> getInscripcionesPorCurso(Curso Curso);

    List<InscripcionesCurso> getInscripcionesPorAlumno(Alumno alumno);
}
