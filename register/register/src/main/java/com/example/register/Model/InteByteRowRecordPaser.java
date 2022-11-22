package com.example.register.Model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="inte-byte_row_record_paser")
public class InteByteRowRecordPaser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="byte_row_record_id")
    private int byteRowRecordId ;

    @Column(name="record_colum_name")
    private int recordColumName;

    @Column(name="record_from")
    private String recordFrom ;

    @Column(name="record_to")
    private String recordTo ;

    @CreationTimestamp
    @Column(name = "ent_on",updatable = false)
    private Instant entOn = Instant.now();

    @Column(name = "ent_by",updatable = false)
    private String entBy="";

    @UpdateTimestamp
    @Column(name = "upt_on", nullable = false)
    private Instant uptOn = Instant.now();

    @Column(name = "upt_by")
    private String uptBy;

}
