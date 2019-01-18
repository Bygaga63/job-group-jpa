package com.job.jpa;

import com.job.jpa.model.AbstractEntity;

import java.util.Set;

public interface CommonController<E extends AbstractEntity> {

    E create();
    void delete();
    E update();
    Set<E> findOne(String entityId);
}
