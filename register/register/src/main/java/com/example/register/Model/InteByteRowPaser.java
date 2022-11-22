package com.example.register.Model;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="inte_byte_row_paser")
public class InteByteRowPaser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="byte_row_id")
    private int byteRowId ;

    @Column(name="record_number")
    private int recordNumber;

    @Column(name="value")
    private String value ;

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
