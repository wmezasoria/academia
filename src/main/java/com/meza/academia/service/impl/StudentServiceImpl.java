package com.meza.academia.service.impl;

import com.meza.academia.model.Student;
import com.meza.academia.repo.IRepo;
import com.meza.academia.repo.IStudentRepo;
import com.meza.academia.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends ServiceImpl<Student, Integer> implements IStudentService {
    private final IStudentRepo repo;

    protected IRepo<Student, Integer> getRepo() {
        return repo;
    }

    /**
     * @param nombre
     * @param apellido
     * @return
     */
    public List<Student> findByNombreAndApellido(String nombre, String apellido) {
        return repo.findByNombreAndApellido(nombre, apellido);
    }

    /**
     * @param nombre
     * @param apellido
     * @return
     */
    public List<Student> findByNombreOrApellidoLike(String nombre, String apellido) {
        return repo.findByNombreOrApellidoLike(nombre, apellido);
    }

    /**
     * @param dni
     * @return
     */
    public List<Student> findByDni(String dni) {
        return repo.findByDni(dni);
    }

}
