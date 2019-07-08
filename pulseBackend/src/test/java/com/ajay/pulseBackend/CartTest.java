package com.ajay.pulseBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajay.pulseBackend.dao.CartDao;
import com.ajay.pulseBackend.model.Cart;

public class CartTest {

	@Autowired
	static CartDao cartDao;

	@Autowired
	static Cart cart;
	
	@BeforeClass
	public static void initilize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ajay.*");
		context.refresh();
		cartDao = (CartDao) context.getBean("cartDao");
		cart = context.getBean(Cart.class);
	}	
	
	@Test
	public void addCart() {
		cart.setPaymentStatus("Not paid");
		cart.setPrice(9000);
		cart.setProdId(2);
		cart.setQuantity(2);
		cart.setProductName("Motherboard");
		cart.setUsername("Ajay");	
		
		assertEquals("adding cart failed",true,cartDao.addCartItem(cart));
	}
	
	@Ignore
	@Test
	public void updateCart() {
		Cart cart = cartDao.getCartItem(001);
		cart.setPrice(9000);
		cartDao.updateCartItem(cart);
		assertEquals("Problem in updating cart", cart.getCartId(),001);
	}
	
	@Ignore
	@Test
	public void deleteCart() {
		Cart cart = cartDao.getCartItem(1);
		cartDao.deleteCartItem(cart);
	}
	
	@Ignore
	@Test
	public void listCart() {
		List<Cart> listCart = cartDao.listCartItems("username");
		assertTrue("Problem in displaying CartItems", listCart.size()>0);
		
		for(Cart cartItem:listCart)
		{
			System.out.println("CartItem Id:" + cartItem.getProdId()+" \t");
			System.out.println("ProductName:" + cartItem.getProductName()+" \t");
			System.out.println("ProductPrice:" + cartItem.getPrice()+" \t");
			System.out.println("Quantity:" + cartItem.getQuantity()+" \t");
			System.out.println("TotalPrice:" + cartItem.getPrice()*cartItem.getQuantity());
			System.out.println("------------------------------------");
		}
	}
	

}
