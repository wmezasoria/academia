package com.meza.academia.config;

import com.meza.academia.dto.StudentDTO;
import com.meza.academia.model.Student;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
public class MapperConfig {

    @Bean("studentMapper")
    public ModelMapper studentMapper(){
        ModelMapper mapper = new ModelMapper();
        TypeMap<StudentDTO, Student> tDtoModel = mapper.createTypeMap(StudentDTO.class, Student.class);
        TypeMap<Student,StudentDTO> tModelDto = mapper.createTypeMap(Student.class, StudentDTO.class);

//        tDtoModel.addMapping(StudentDTO :: getName, (estudiante, nombre) -> estudiante.setNombre((String)nombre));
//        tModelDto.addMapping(Student::getNombre, (studentDTO, name) -> studentDTO.setName((String)name));

        tDtoModel.addMapping(StudentDTO :: getCedula, (estudiante, dni) -> estudiante.setDni((String)dni));
        tModelDto.addMapping(Student::getDni, (studentDTO, cedula) -> studentDTO.setCedula((String)cedula));
        return mapper;
    }

    @Bean("courseMapper")
    public ModelMapper courseMapper(){
        return new ModelMapper();
    }

    @Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

}
