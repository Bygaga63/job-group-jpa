package com.job.jpa.dto;

import com.job.jpa.model.group.Visibility;
import lombok.Data;

@Data
public class GroupRequestModel {
    private String name;
    private String description;
    private Visibility visibility;
    private String userId;
}
