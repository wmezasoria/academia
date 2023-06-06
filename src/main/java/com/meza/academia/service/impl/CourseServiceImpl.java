package com.meza.academia.service.impl;

import com.meza.academia.model.Course;
import com.meza.academia.repo.ICourseRepo;
import com.meza.academia.repo.IRepo;
import com.meza.academia.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends ServiceImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;

    protected IRepo<Course, Integer> getRepo() {
        return repo;
    }
}
