package com.meza.academia.repo;

import com.meza.academia.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepo extends IRepo<Student, Integer> {

    /**
     * Busca un estudiante por su nombre y apellido
     *
     * @param nombre
     * @param apellido
     * @return
     */
    List<Student> findByNombreAndApellido(String nombre, String apellido);

    //jpql
    @Query("FROM Student s WHERE s.nombre LIKE %:name% OR s.apellido LIKE %:lastName%")
    List<Student> findByNombreOrApellidoLike(@Param("name") String nombre, @Param("lastName")String apellido);

    //jpql nativo
    @Query(value = "select * from student where dni = :dni",nativeQuery = true)
    List<Student> findByDni(String dni);


}
