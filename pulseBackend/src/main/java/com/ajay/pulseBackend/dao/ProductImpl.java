package com.ajay.pulseBackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.pulseBackend.model.Product;

@Repository("productDao")
@Transactional
public class ProductImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().save(product);
			return true;
		}
		catch(Exception e) {
			System.out.println("Error in inserting prod");
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e) {
			System.out.println("Error in updating prod");
			return false;
		}
	}

	@Override
	public boolean deleteProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e) {
			System.out.println("Error in deleting prod");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> listProduct() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Product").list();
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public Product getProductById(int prodId) {
		try {
			Session session = sessionFactory.openSession();
			Product prod=session.get(Product.class, prodId);
			return prod;
		}
		catch(Exception e) {
			System.out.println("Problem in getting product by Id");
			return null;
		}
	}
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Product> listProductByCat(int catId){
//		List<Product> li;
//			Session session = sessionFactory.openSession();
//			if(catId == 74) {
//				String hql = "FROM Product WHERE categoryId = 74";
//				Query query = session.createQuery(hql);
//				li =  query.list();
//				return li;
//			}
//			else if(catId == 92) {
//				String hql = "FROM Product WHERE categoryId = 92";
//				Query query = session.createQuery(hql);
//				List<Product> li =  query.list();
//				return li;
//			}
//			return this.li;
//				
//		
//			
//		
//	}
	
}
