package com.order.service;

import java.util.List;
import java.util.Optional;

import com.order.entity.OrderEntity;


public interface OrderService {
	
	Integer  saveOrder(OrderEntity order);
	public List<OrderEntity> getAllOrder();
	Optional<OrderEntity> getOrder(Integer id);
	public void deleteOrder(Integer id);
	Integer updateOrder(OrderEntity order, Integer id);

	
	

}
