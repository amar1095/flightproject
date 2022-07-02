package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.OrderEntity;
import com.order.exception.ResourceNotFoundException;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderrepository;

	@Override
	public Integer saveOrder(OrderEntity order) {
		OrderEntity orderrntity=orderrepository.save(order);
		return orderrntity.getOrderId();
	}

	@Override
	public List<OrderEntity> getAllOrder() {
		return orderrepository.findAll();
	}

	@Override
	public Optional<OrderEntity> getOrder(Integer id) {
		
		return orderrepository.findById(id);
	}

	@Override
	public void deleteOrder(Integer id) {
		orderrepository.deleteById(id);
		
	}

	@Override
	public Integer updateOrder(OrderEntity order, Integer id) {
		OrderEntity ordrrntity=orderrepository.findById(id).orElseThrow(()->
    	new ResourceNotFoundException("order","id",id));
		ordrrntity.setOrderId(order.getOrderId());
		ordrrntity.setOrderPrice(order.getOrderPrice());
		ordrrntity.setOrderName(order.getOrderName());
		orderrepository.save(ordrrntity);
		return ordrrntity.getOrderId();
	}

	

}
