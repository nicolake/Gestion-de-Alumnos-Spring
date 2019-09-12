package dev.nicolake.sistemaalumnos.commons;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {
    @Override
    public T save(T entity) {
        return getDao().save(entity);
    }

    @Override
    public void delete(ID id) {
        getDao().deleteById(id);
    }

    @Override
    public T get(ID id) {
        Optional<T> object = getDao().findById(id);
        if (object.isPresent()){
            return object.get();
        }

        return null;
    }

    @Override
    public List<T> getAll() {
        List<T> result = new ArrayList<>();
        getDao().findAll().forEach(obj-> result.add(obj));
        return result;
    }

    public abstract CrudRepository<T,ID> getDao();
}
