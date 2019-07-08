package com.ajay.pulseBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajay.pulseBackend.dao.CategoryDao;
import com.ajay.pulseBackend.model.Category;

public class CategoryTest {

	@Autowired
	static CategoryDao catDao;
	
	@Autowired
	static Category cat;
	
	@BeforeClass
	public static void initilize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ajay.*");
		context.refresh();
		catDao=(CategoryDao) context.getBean("categoryDao");
		cat=(Category) context.getBean("category");
	}
	
	
	@Test
	public void addCategory() {
		cat.setCatName("Mouse");
		cat.setCatDesc("One of the best IO device");
		boolean res = catDao.addCategory(cat);
		assertEquals("Problem in loading Category",true,res);
	}

	@Ignore
	@Test
	public void testUpdateCategory() {
		cat=catDao.getCategoryById(7);
		cat.setCatName("Tablet");
		cat.setCatDesc("best for Graphics stuff");
		boolean res = catDao.updateCategory(cat);
		assertEquals("Probvlem in updating",true,res);
	}
	
	@Ignore
	@Test
	public void testDeleteCategory() {
		cat=catDao.getCategoryById(8);
		boolean res = catDao.deleteCategory(cat);
		assertEquals("Probvlem in deleting",true,res);
	}
	
	@Ignore
	@Test
	public void testListCategory() {
		List<Category> li=catDao.listCategory();
		assertEquals("Problem in listing category",3,li.size());
		for(Category cat:li) {
			System.out.println(cat.getCatName());
		}
	}
	
}
