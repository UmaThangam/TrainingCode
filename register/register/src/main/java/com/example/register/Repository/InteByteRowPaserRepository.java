package com.example.register.Repository;

import com.example.register.Model.InteByteRowPaser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteByteRowPaserRepository extends JpaRepository<InteByteRowPaser,Integer>{

}
