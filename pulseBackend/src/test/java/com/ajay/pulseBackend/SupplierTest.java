package com.ajay.pulseBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ajay.pulseBackend.dao.SupplierDao;
import com.ajay.pulseBackend.model.Category;
import com.ajay.pulseBackend.model.Supplier;

public class SupplierTest {

	@Autowired
	static SupplierDao suppDao;
	
	@Autowired
	static Supplier supp;
	
	@BeforeClass
	public static void initilize() {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ajay.*");
		context.refresh();
		suppDao = (SupplierDao) context.getBean("supplierDao");
		supp = (Supplier) context.getBean("supplier");
	}	
		
	
	@Ignore
	@Test
	public void addSupp() {
		supp.setSupplierName("House of IT");
		supp.setSupplierLocation("Chennai");
		boolean res = suppDao.addSupplier(supp);
		assertEquals("Problem in adding Supplier",true,res);
	}

	@Ignore
	@Test
	public void testUpdateSupp() {
		supp=suppDao.getSupplierById(12);
		supp.setSupplierLocation("Mumbai");
		boolean res = suppDao.updateSupplier(supp);
		assertEquals("Probvlem in updating",true,res);
	}
	
	@Ignore
	@Test
	public void testDeleteSupp() {
		supp=suppDao.getSupplierById(12);
		boolean res = suppDao.deleteSupplier(supp);
		assertEquals("Probvlem in deleting",true,res);
	}
	
	@Ignore
	@Test
	public void testListSupp() {
		List<Supplier> li=suppDao.listSupplier();
		assertEquals("Problem in listing category",2,li.size());
		for(Supplier supp:li) {
			System.out.println(supp.getSupplierLocation());
		}
	}

}
