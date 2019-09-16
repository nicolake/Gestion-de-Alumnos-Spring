package dev.nicolake.sistemaalumnos.commons.converter;

import dev.nicolake.sistemaalumnos.dao.api.CursoDaoAPI;
import dev.nicolake.sistemaalumnos.model.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CursoConverter implements Converter<String, Curso> {
    @Autowired
    private CursoDaoAPI cursoDaoAPI;

    @Override
    public Curso convert(String id) {
        Integer identificador = new Integer(id);
        Optional<Curso> object = cursoDaoAPI.findById(identificador);
        if (object.isPresent()){
            return object.get();
        }

        return null;
    }
}
