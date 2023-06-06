package com.meza.academia.service.impl;

import com.meza.academia.model.Tuition;
import com.meza.academia.model.TuitionDetail;
import com.meza.academia.repo.IRepo;
import com.meza.academia.repo.ITuitionRepo;
import com.meza.academia.service.ITuitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class TuitionServiceImpl extends ServiceImpl<Tuition, Long> implements ITuitionService {
    private final ITuitionRepo repo;

    protected IRepo<Tuition, Long> getRepo() {
        return repo;
    }

    public Map<String, List<String>> getStudentByCourse () {
        Stream<List<TuitionDetail>> sListTuitionDetail = repo.findAll().stream().map(listTuition -> listTuition.getDetail());
        Stream<TuitionDetail> sTuitionDetail = sListTuitionDetail.flatMap(listTuitionDetail -> listTuitionDetail.stream());

        return sTuitionDetail.collect(Collectors.groupingBy(tuitionDetail -> tuitionDetail.getCurso().getName(),
                Collectors.mapping(tuitionDetail -> tuitionDetail.getTuition().getEstudiante().getNombre(), Collectors.toList())));
    }
}
