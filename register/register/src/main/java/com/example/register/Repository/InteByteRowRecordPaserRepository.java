package com.example.register.Repository;


import com.example.register.Model.InteByteRowRecordPaser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteByteRowRecordPaserRepository extends JpaRepository<InteByteRowRecordPaser,Integer> {
}
