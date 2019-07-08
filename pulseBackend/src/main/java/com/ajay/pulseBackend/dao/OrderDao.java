package com.ajay.pulseBackend.dao;

import com.ajay.pulseBackend.model.Order1;

public interface OrderDao {

	public boolean saveOrder(Order1 order);
	public boolean updateCart(String username);
	
}
