package com.niit.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;

public class CartTest {
	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		CartDAO cartDAO = (CartDAO) context.getBean("CartDAO");
		Cart cart = (Cart) context.getBean("cart");
		cart.setProductName("dfhjj");
		cartDAO.saveOrUpdate(cart);
	}
}
