package com.meza.academia.controller;

import com.meza.academia.dto.StudentDTO;
import com.meza.academia.model.Student;
import com.meza.academia.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
    @Qualifier("studentMapper")
    private final ModelMapper studentMapper;

    //read all, desc ordered by edad
    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception {
        return new ResponseEntity<>(service.findAll().stream().sorted((s1,s2)->s2.getEdad()-s1.getEdad()).map(this ::convertToDto).toList(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<> (this.convertToDto(service.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO studentDto) throws Exception {
        return new ResponseEntity<>(this.convertToDto(service.save(this.convertToEntity(studentDto))),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody StudentDTO studentDto) throws Exception {
        return new ResponseEntity<>(this.convertToDto(service.update(this.convertToEntity(studentDto), id)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/findByNameAndLastName")
    public ResponseEntity<List<StudentDTO>> findByNameAndLastName(@RequestParam("name") String name, @RequestParam("lastName")String lastName) throws Exception {
        return new ResponseEntity<>(service.findByNombreAndApellido(name, lastName).stream().map(this::convertToDto).toList(), HttpStatus.OK);
    }

    @GetMapping("/findByNameOrLastNameLike")
    public ResponseEntity<List<StudentDTO>> findByNombreOrApellidoLike(@RequestParam("name") String name, @RequestParam("lastName") String lastName) throws Exception {
        return new ResponseEntity<>(service.findByNombreOrApellidoLike(name,lastName).stream().map(this::convertToDto).toList(), HttpStatus.OK);
    }

    @GetMapping("/findByDni")
    public ResponseEntity<List<StudentDTO>> findByDni(@RequestParam("dni") String dni) throws Exception{
        return new ResponseEntity<>(service.findByDni(dni).stream().map(this::convertToDto).toList(),HttpStatus.OK);

    }

    /**
     * @param student
     * @return
     */
    private StudentDTO convertToDto(Student student){
        return studentMapper.map(student, StudentDTO.class);
    }


    /**
     * @param dto
     * @return
     */
    private Student convertToEntity(StudentDTO dto){
        return studentMapper.map(dto, Student.class);
    }

}
