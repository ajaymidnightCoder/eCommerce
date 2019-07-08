package com.ajay.pulseBackend.dao;

import java.util.List;

import com.ajay.pulseBackend.model.Cart;

public interface CartDao {
	
	public boolean addCartItem(Cart cart);
	public boolean deleteCartItem(Cart cart);
	public boolean updateCartItem(Cart cart);
  	public Cart getCartItem(int cartId);
  	public List<Cart> listCartItems(String username);

}
