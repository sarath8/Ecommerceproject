package com.niit.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;
public class SupplierTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("SupplierDAO");
		Supplier supplier = (Supplier) context.getBean("supplier");

		supplier.setSupplierName("hddsjk");
		supplier.setContactNumber(87968764);
		supplierDAO.saveOrUpdate(supplier);
		

	}
}
