package dev.nicolake.sistemaalumnos.service.api;

import dev.nicolake.sistemaalumnos.commons.GenericServiceAPI;
import dev.nicolake.sistemaalumnos.model.Alumno;
import dev.nicolake.sistemaalumnos.model.InscripcionesCarrera;

import java.util.List;

public interface InscripcionesCarreraServiceAPI extends GenericServiceAPI<InscripcionesCarrera, Integer> {
    List<InscripcionesCarrera> getInscripcionesPorAlumno(Alumno alumno);
}
