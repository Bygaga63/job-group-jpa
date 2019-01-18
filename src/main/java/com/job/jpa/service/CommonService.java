package com.job.jpa.service;

import com.job.jpa.model.AbstractEntity;

public interface CommonService<E extends AbstractEntity> {
    E create(E entity);
    E findOne(String entityId);
    void remove(E entity);
}
