package com.order.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.entity.OrderEntity;
import com.order.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	@PostMapping("/createOrder")
	Integer createOrder(@RequestBody OrderEntity order) {
	 	Integer id = orderservice.saveOrder(order);
	 	return id;
		}	
	
	  @GetMapping("/getAllOrder")
	 	public List<OrderEntity> getOrder(){
	    	 return orderservice.getAllOrder();
	     }
	  @GetMapping("/order/{id}")
	     public Optional<OrderEntity> getOrder(@PathVariable Integer id){
	    	 Optional<OrderEntity> order=  orderservice.getOrder(id);
	    	 return order;
	     }
	  
	  @DeleteMapping("/deleteOrder/{id}")
	     public ResponseEntity<OrderEntity> deleteOrder(@PathVariable Integer id){
	    	 ResponseEntity<OrderEntity> responseentity=new  ResponseEntity<>(HttpStatus.OK);
	    	 
	    	 try{
	    		 orderservice.deleteOrder(id);
	    	 }catch(Exception e) {
	    		 e.printStackTrace();
	        	 responseentity=new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	 }
	    	 return responseentity;
	     }
	  
	  @PutMapping("/updateOrder/{id}")
	     public ResponseEntity<OrderEntity> updateOrder(@PathVariable Integer id,@RequestBody OrderEntity order){
	    	 ResponseEntity<OrderEntity> responseentity=new  ResponseEntity<>(HttpStatus.OK);
	    	 
	    	 try{
	    		 orderservice.updateOrder(order, id);
	    	 }catch(Exception e) {
	    		 e.printStackTrace();
	        	 responseentity=new  ResponseEntity<>(HttpStatus.NOT_FOUND);
	    	 }
	    	 return responseentity;
	     }
	  
	  

}
