package com.ajay.pulseBackend.dao;

import java.util.List;

import com.ajay.pulseBackend.model.Supplier;

public interface SupplierDao {

	public boolean addSupplier(Supplier supplier);
	public boolean updateSupplier(Supplier supplier);
	public boolean deleteSupplier(Supplier supplier);
	public List<Supplier> listSupplier();
	public Supplier getSupplierById(int supplierId);
	
}
