package com.meza.academia.service;

import com.meza.academia.model.Tuition;

import java.util.List;
import java.util.Map;

public interface ITuitionService extends IService<Tuition, Long> {

    public Map<String, List<String>> getStudentByCourse ();

    }
