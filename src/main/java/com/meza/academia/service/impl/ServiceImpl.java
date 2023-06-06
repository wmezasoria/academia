package com.meza.academia.service.impl;

import com.meza.academia.exception.ModelNotFoundException;
import com.meza.academia.repo.IRepo;
import com.meza.academia.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

public abstract class ServiceImpl<T, ID> implements IService<T, ID> {

    protected abstract IRepo<T, ID> getRepo();

    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    public T update(T t, ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXISTS: " + id));
        return getRepo().save(t);
    }

    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXISTS: " + id));
    }

    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT EXISTS: " + id));
        getRepo().deleteById(id);
    }
}
