package com.meza.academia.controller;

import com.meza.academia.model.Course;
import com.meza.academia.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
    @Qualifier("courseMapper")
    public final ModelMapper courseMapper;

        @GetMapping
    public List<Course> readll() throws Exception {
        return service.findAll();
    }


    @GetMapping("/{id}")
    public Course readById(@PathVariable("id") Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public Course create(@RequestBody Course course) throws Exception {
        return service.save(course);
    }

    @PutMapping
    public Course update(@PathVariable("id") Integer id, @RequestBody Course course) throws Exception {
        return service.update(course, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }


}
