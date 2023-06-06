package com.meza.academia.service;

import java.util.List;

public interface IService<T, ID> {
    List<T> findAll() throws Exception;
    T save(T t) throws Exception;
    T update(T t, ID id) throws Exception;
    T findById(ID id) throws Exception;
    void delete(ID id) throws Exception;
}
