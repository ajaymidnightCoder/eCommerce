package com.ajay.pulseBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajay.pulseBackend.dao.OrderDao;
import com.ajay.pulseBackend.model.Order1;

public class OrderTest {

	@Autowired
	static Order1 ord;
	
	@Autowired
	static OrderDao ordDao;
	
	@BeforeClass
	public static void initilize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ajay.*");
		context.refresh();
		ordDao = (OrderDao) context.getBean("orderDao");
		ord = (Order1) context.getBean("order1");
	}
	
	@Test
	public void testAddOder() {
		ord.setCartId(12);
		ord.setUsername("Ajay");
		boolean res = ordDao.saveOrder(ord);
		assertEquals("problem in saving order",res,true);
	}
	
}
