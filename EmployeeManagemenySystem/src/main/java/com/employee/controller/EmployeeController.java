package com.employee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.EmployeeEntity;
import com.employee.service.EmpployeeService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user/")
public class EmployeeController {
	
	@Autowired
	EmpployeeService employeeservice;
	
	
	
	  @PostMapping("/employee")
		Integer createEmployee(@RequestBody EmployeeEntity employee) {
	 	Integer id = employeeservice.saveEmploye(employee);
	 	System.out.println("Id..."+id); 
	 	return id;
			
		}
	  
	  @GetMapping("/allemployee")
	 	public List<EmployeeEntity> getEmployee(){
	    	 return employeeservice.getAllEmployee();
	     }

	  @GetMapping("/employee/{id}")
	     public Optional<EmployeeEntity> getEmployee(@PathVariable Integer id){
	    	 Optional<EmployeeEntity> emp=  employeeservice.getEmployee(id);
	    	 return emp;
	     }
	  

	     @DeleteMapping("/deleteemployee/{id}")
	     public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable Integer id){
	    	 ResponseEntity<EmployeeEntity> responseentity=new  ResponseEntity<>(HttpStatus.OK);
	    	 
	    	 try{
	    		 employeeservice.deleteEmployee(id);
	    	 }catch(Exception e) {
	    		 e.printStackTrace();
	        	 responseentity=new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	 }
	    	 return responseentity;
	     }
	     @PutMapping("/updateemployee/{id}")
	     public ResponseEntity<EmployeeEntity> updateEmployee(@PathVariable Integer id,@RequestBody EmployeeEntity emp){
	    	 ResponseEntity<EmployeeEntity> responseentity=new  ResponseEntity<>(HttpStatus.OK);
	    	 
	    	 try{
	    		 employeeservice.updateEmployee(emp, id);
	    	 }catch(Exception e) {
	    		 e.printStackTrace();
	        	 responseentity=new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	 }
	    	 return responseentity;
	     }
	     

}

