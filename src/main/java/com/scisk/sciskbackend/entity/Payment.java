package com.scisk.sciskbackend.entity;

import java.time.Instant;
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
@Document(GlobalParams.PAYMENT_COLLECTION_NAME)
public class Payment {

    @Id
    private Long id;
    private Instant paymentDate;
    private Double amount;
    private String observation;

    @Transient
    private Record record;
    private Long recordId;

    public void setRecord(Record record) {
        this.record = record;
        this.recordId = Objects.isNull(record) ? null : record.getId();
    }

}
