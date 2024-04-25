package dev.estebangperez.ticket.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * This class will implement the wrappers for the standard CRUD methods for each repository with ease
 *
 * @param <T>
 * @param <ID>
 * @author egarcia_profile
 */
public abstract class BaseService<T, ID> {

    protected abstract JpaRepository<T, ID> getRepository();

    public T save(T entity) {
        return getRepository().save(entity);
    }

    public Optional<T> findById(ID id) {
        return getRepository().findById(id);
    }

    public List<T> findAll() {
        return getRepository().findAll();
    }

    public void deleteById(ID id) {
        getRepository().deleteById(id);
    }
}