package com.scisk.sciskbackend.entity;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

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
@Document(GlobalParams.RECORD_JOB_COLLECTION_NAME)
public class RecordJob {

    @Id
    private Long id;
    private Instant estimatedStartDate;
    private Instant estimatedEndDate;
    private Instant startDate;
    private Instant endDate;
    private String observation;
    private Instant chiefEndDate;
    private String chiefObservation;

    @Transient
    private User employee;
    private Long employeeId;

    @Transient
    private RecordStep recordStep;
    private Long recordStepId;

    @Transient
    private Job job;
    private Long jobId;

    public Optional<User> getEmployee() {
        return Optional.ofNullable(employee);
    }

    public void setEmployee(User employee) {
        this.employee = employee;
        this.employeeId = Objects.isNull(employee) ? null : employee.getId();
    }

    public void setRecordStep(RecordStep recordStep) {
        this.recordStep = recordStep;
        this.recordStepId = Objects.isNull(recordStep) ? null : recordStep.getId();
    }

    public void setJob(Job job) {
        this.job = job;
        this.jobId = Objects.isNull(job) ? null : job.getId();
    }


}
