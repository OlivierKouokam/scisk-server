package com.scisk.sciskbackend.entity;

import com.scisk.sciskbackend.util.GlobalParams;
import lombok.*;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(GlobalParams.JOB_COLLECTION_NAME)
public class Job {

    @Id
    private Long id;
    private String name;
    private String description;
    private Integer order;

    @Transient
    private Step step;
    private Long stepId;

    public void setStep(Step step) {
        this.step = step;
        this.stepId = Objects.isNull(step) ? null : step.getId();
    }
}
