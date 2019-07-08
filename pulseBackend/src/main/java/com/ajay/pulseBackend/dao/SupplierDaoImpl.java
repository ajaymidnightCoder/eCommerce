package com.ajay.pulseBackend.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.pulseBackend.model.Supplier;

@Repository("supplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e) {
			System.out.println("Problem in saving Supplier");
			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e) {
			System.out.println("Problem in updating Supplier");
			return false;
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e) {
			System.out.println("Problem in deleting Supplier");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Supplier> listSupplier() {
		try {
			List<Supplier> li=sessionFactory.getCurrentSession().createQuery("from Supplier").list();
			return li;
		}
		catch(Exception e) {
			System.out.println("Problem in listing Supplier");
			return null;
		}
	}

	@Override
	public Supplier getSupplierById(int supplierId) {
		try {
			Session session=sessionFactory.openSession();
			Supplier sup=session.get(Supplier.class, supplierId);
			return sup;
		}
		catch(Exception e) {
			System.out.println("Problem in getting Supplier specified");
			return null;
		}
	}

}
