package com.employee.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.entity.EmployeeEntity;

public interface EmployeeRespository extends JpaRepository<EmployeeEntity, Integer>{

}
