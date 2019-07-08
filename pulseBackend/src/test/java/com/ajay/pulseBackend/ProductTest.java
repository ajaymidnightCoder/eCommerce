package com.ajay.pulseBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajay.pulseBackend.dao.ProductDao;
import com.ajay.pulseBackend.model.Product;

public class ProductTest {

	@Autowired
	static ProductDao prodDao;
	
	@Autowired
	static Product prod;
	
	@BeforeClass
	public static void initilize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.ajay.*");
		context.refresh();
		prodDao = (ProductDao) context.getBean("productDao");
		prod = (Product) context.getBean("product");
	}
	
	@Ignore
	@Test
	public void testAddProduct() {
		prod.setproductName("HelloKitty");
		prod.setProductDesc("Hello Kitty HeadPhone");
		prod.setProductStock(112);
		prod.setSupplierId(1);
		boolean res=prodDao.addProduct(prod);
		assertEquals("problem in adding product",true,res);	
	}

	@Ignore
	@Test
	public void testDeleteProduct() {
		prod=prodDao.getProductById(2);
		boolean res=prodDao.deleteProduct(prod);
		assertEquals("problem in adding product",true,res);
	}
	
	@Ignore
	@Test
	public void updateProduct() {
		prod=prodDao.getProductById(3);
		prod.setProductPrice(17500);
		boolean res=prodDao.updateProduct(prod);
		assertEquals("problem in updatting product",true,res);
	}
	
	@Ignore
	@Test
	public void listProduct() {
		List<Product> plist=prodDao.listProduct();
		assertEquals("Problem in listing product",3,plist.size());
		for(Product prod:plist) {
			System.out.println(prod.getproductName());
		}
	}
	
	
//	@Test
//	public void listProductByCategory() {
//		List<Product> li = prodDao.listProductByCat(74);
//		assertEquals("Problem in listing product",1,li.size());
//		for(Product prod:li) {
//			System.out.println(prod.getproductName());
//		}
//	}
}
