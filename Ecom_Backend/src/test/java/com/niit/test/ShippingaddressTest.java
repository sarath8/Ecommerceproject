package com.niit.test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ShippingaddressDAO;
import com.niit.model.Shippingaddress;


public class ShippingaddressTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		ShippingaddressDAO shippingaddressDAO = (ShippingaddressDAO) context.getBean("ShippingaddressDAO");
		Shippingaddress shippingaddress = (Shippingaddress) context.getBean("shippingaddress");
		shippingaddress.setAddress("fdgfs");
		shippingaddress.setUserName("jkfgjd");
		shippingaddressDAO.saveOrUpdate(shippingaddress);
		

}
}