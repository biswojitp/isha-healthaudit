package com.ha.healthauditlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ha.healthauditlog.model.SignUp;


public interface SignUpRepository extends JpaRepository<SignUp, Long>{

}
