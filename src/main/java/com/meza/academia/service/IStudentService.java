package com.meza.academia.service;

import com.meza.academia.model.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentService extends IService<Student, Integer> {

    /**
     * @param nombre
     * @param apellido
     * @return
     */
    public List<Student> findByNombreAndApellido(String nombre, String apellido);

    /**
     * @param nombre
     * @param apellido
     * @return
     */
    List<Student> findByNombreOrApellidoLike(String nombre, String apellido);

    /**
     * @param dni
     * @return
     */
    List<Student> findByDni(String dni);


}
