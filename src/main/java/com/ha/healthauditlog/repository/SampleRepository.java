package com.ha.healthauditlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.healthauditlog.model.Sample;

public interface SampleRepository extends JpaRepository<Sample,Long>{

}
