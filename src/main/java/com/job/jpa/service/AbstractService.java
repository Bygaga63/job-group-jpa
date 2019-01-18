package com.job.jpa.service;

import com.job.jpa.model.AbstractEntity;
import com.job.jpa.repo.CommonRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>> implements CommonService<E> {
    private final R repository;
}
