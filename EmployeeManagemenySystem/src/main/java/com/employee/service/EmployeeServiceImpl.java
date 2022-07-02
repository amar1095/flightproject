package com.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmpployeeService {
	@Autowired
	EmployeeRespository empRepository;

	public Integer saveEmploye(EmployeeEntity emp) {
		EmployeeEntity saveemp=empRepository.save(emp);
        return saveemp.getId();
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
	
		return empRepository.findAll();
	}

	@Override
	public Optional<EmployeeEntity> getEmployee(Integer id) {
		// TODO Auto-generated method stub
		return empRepository.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		 empRepository.deleteById(id);
		
	}
	@Override
	 public  Integer  updateEmployee(EmployeeEntity emp, Integer id) {
		 EmployeeEntity  exitemp=empRepository.findById(id).orElseThrow();
		 
	


		 exitemp.setEmpName(emp.getEmpName());
		 exitemp.setEmpAge(emp.getEmpAge());
		 exitemp.setEmpDestination(emp.getEmpDestination());
		 exitemp.setEmpEmail(emp.getEmpEmail());

		 empRepository.save(exitemp);
		 System.out.println("===========99==="+exitemp.getEmpGender());
		 System.out.println("=========88====="+exitemp.getEmpName());
		 System.out.println("========856======"+exitemp.getEmpAge());
	    	return exitemp.getId();	
	    }

	

	
}
