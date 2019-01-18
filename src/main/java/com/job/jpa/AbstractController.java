package com.job.jpa;

import com.job.jpa.model.AbstractEntity;
import com.job.jpa.service.CommonService;

public abstract class AbstractController<E extends AbstractEntity, S extends CommonService<E>> {
}
