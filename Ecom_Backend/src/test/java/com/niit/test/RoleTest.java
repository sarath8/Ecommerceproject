package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.RoleDAO;
import com.niit.model.Role;

public class RoleTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		RoleDAO roleDAO = (RoleDAO) context.getBean("RoleDAO");
		Role role = (Role) context.getBean("role");
		role.setUserName("kjgdffd");
		role.setEmailId("hgfshdghj");
		role.setContactNumber(6567);
		
		
		
		
		roleDAO.saveOrUpdate(role);
		
		
	}
}
