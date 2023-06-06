package com.meza.academia.repo;

import com.meza.academia.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepo extends IRepo<Course, Integer> {
}
