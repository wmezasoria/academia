package com.meza.academia.controller;

import com.meza.academia.dto.TuitionDetailDTO;
import com.meza.academia.model.TuitionDetail;
import com.meza.academia.service.ITuitionDetailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuitionDetail")
@RequiredArgsConstructor
public class TuitionDetailController {

    private final ITuitionDetailService service;
    @Qualifier("courseMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<TuitionDetailDTO>> readAll() throws Exception {
        return new ResponseEntity<>(service.findAll().stream().map(this ::convertToDto).toList(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TuitionDetailDTO> readById(@PathVariable("id") Integer id) throws Exception {
        return new ResponseEntity<> (this.convertToDto(service.findById(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TuitionDetailDTO> create(@Valid @RequestBody TuitionDetailDTO tuitionDetailDto) throws Exception {
        return new ResponseEntity<>(this.convertToDto(service.save(this.convertToEntity(tuitionDetailDto))),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TuitionDetailDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody TuitionDetailDTO tuitionDetailDto) throws Exception {
        return new ResponseEntity<>(this.convertToDto(service.update(this.convertToEntity(tuitionDetailDto), id)),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /**
     * @param tuition
     * @return
     */
    private TuitionDetailDTO convertToDto(TuitionDetail tuition){
        return mapper.map(tuition, TuitionDetailDTO.class);
    }


    /**
     * @param dto
     * @return
     */
    private TuitionDetail convertToEntity(TuitionDetailDTO dto){
        return mapper.map(dto, TuitionDetail.class);
    }

}
