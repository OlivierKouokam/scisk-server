package com.scisk.sciskbackend.entity;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import com.scisk.sciskbackend.util.GlobalParams;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(GlobalParams.RECORD_STEP_COLLECTION_NAME)
public class RecordStep {

    @Id
    private Long id;
    private String name;
    private String observation;
    private Instant endDate;

    @Transient
    private Record record;
    private Long recordId;

    @Transient
    private Step step;
    private Long stepId;

    private List<RecordJob> recordJobs;

    public void setRecord(Record record) {
        this.record = record;
        this.recordId = Objects.isNull(record) ? null : record.getId();
    }

    public void setStep(Step step) {
        this.step = step;
        this.stepId = Objects.isNull(step) ? null : step.getId();
    }


}
