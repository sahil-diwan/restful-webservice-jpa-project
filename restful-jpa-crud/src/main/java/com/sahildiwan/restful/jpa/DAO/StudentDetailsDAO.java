package com.sahildiwan.restful.jpa.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sahildiwan.restful.jpa.jpaentity.Student; 

@Repository
public interface StudentDetailsDAO  extends JpaRepository<Student,Integer> {

}
