package com.ajay.pulseBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ajay.pulseBackend.model.Cart;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addCartItem(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean deleteCartItem(Cart cart) {
		try {
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean updateCartItem(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Cart getCartItem(int cartId) {
		try {
			Session session = sessionFactory.openSession();
			Cart cart = (Cart) session.get(Cart.class, cartId);
			return cart;
		}
		catch(Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cart> listCartItems(String username) {
		try {
			return sessionFactory.getCurrentSession().createQuery("From Cart").list();
		}
		catch(Exception e) {
			return null;
		}
	}

}
