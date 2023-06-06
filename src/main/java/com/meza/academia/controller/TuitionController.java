package com.meza.academia.controller;

import com.meza.academia.dto.TuitionDTO;
import com.meza.academia.model.Tuition;
import com.meza.academia.service.ITuitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tuition")
@RequiredArgsConstructor
public class TuitionController {

    private final ITuitionService service;
    @Qualifier("defaultMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<TuitionDTO>> readAll() throws Exception {
        return new ResponseEntity<>(service.findAll().stream().map(this ::convertToDto).toList(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TuitionDTO> readById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<> (this.convertToDto(service.findById(id.longValue())), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TuitionDTO> create(@Valid @RequestBody TuitionDTO tuitionDto) throws Exception {
        return new ResponseEntity<>(this.convertToDto(service.save(this.convertToEntity(tuitionDto))),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TuitionDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody TuitionDTO tuitionDto) throws Exception {
        return new ResponseEntity<>(this.convertToDto(service.update(this.convertToEntity(tuitionDto), id.longValue())),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id.longValue());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/studentByCourse")
    public ResponseEntity<Map<String, List<String>> > studentByCourse() throws Exception {
        return new ResponseEntity<>(service.getStudentByCourse(), HttpStatus.OK);
    }
    /**
     * @param tuition
     * @return
     */
    private TuitionDTO convertToDto(Tuition tuition){
        return mapper.map(tuition, TuitionDTO.class);
    }


    /**
     * @param dto
     * @return
     */
    private Tuition convertToEntity(TuitionDTO dto){
        return mapper.map(dto, Tuition.class);
    }



}
