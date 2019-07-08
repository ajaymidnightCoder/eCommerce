package com.ajay.pulseBackend.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.pulseBackend.model.Category;

@Repository("categoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e) {
			System.out.println("Problem in saving category");
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			System.out.println("problem in updating category");
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) {
			System.out.println("problem in deleting category");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> listCategory() {
		try {
			List<Category> li=sessionFactory.getCurrentSession().createQuery("from Category").list();
			return li;
		}
		catch(Exception e) {
			System.out.println("Problem in Listing Category");
			return null;
		}
	}

	@Override
	public Category getCategoryById(int catId) {
		try {
			Session session = sessionFactory.openSession();
			Category category=session.get(Category.class, catId);
			return category;
		}
		catch(Exception e) {
			System.out.println("problem in getting data");
			return null;
		}
	}

}
