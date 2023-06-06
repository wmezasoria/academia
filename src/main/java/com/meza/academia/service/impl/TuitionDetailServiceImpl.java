package com.meza.academia.service.impl;

import com.meza.academia.model.TuitionDetail;
import com.meza.academia.repo.IRepo;
import com.meza.academia.repo.ITuitionDetailRepo;
import com.meza.academia.service.ITuitionDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TuitionDetailServiceImpl extends ServiceImpl<TuitionDetail, Integer> implements ITuitionDetailService {
    private final ITuitionDetailRepo repo;

    protected IRepo<TuitionDetail, Integer> getRepo() {
        return repo;
    }

}
