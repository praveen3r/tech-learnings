package com.demo2.orm.main;

import com.demo2.orm.model.Product;
import com.demo2.orm.service.ProductService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import java.util.Arrays;

/** 
 * Simple tester for a Spring application that uses JPA 
 * with AOP based Transactions. 
 **/
public class SpringOrmMain {
	public static void main(String[] args) {

		//Create Spring application context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/SpringORMwithTX_AOP.xml");
		
		//Get service from context. (service's dependency (ProductDAO) is autowired in ProductService)
		ProductService productService = ctx.getBean(ProductService.class);
		
		//Do some data operation
		
		productService.add(new Product(1, "Television"));
		productService.add(new Product(2, "Phone"));
		
		System.out.println("listAll: " + productService.listAll());
		
		//Test transaction rollback (for duplicated key)
		try {
			productService.addAll(Arrays.asList(
					new Product(3, "Peach"), new Product(4, "Strawberry"), new Product(1, "Melone")));
		} catch (DataAccessException dataAccessException) {
			//Do nothing here, we just test rollback
		}
		
		//Test element list after rollback (same two element, 3 more hasn't been added.)
		System.out.println("listAll: " + productService.listAll());
		
		ctx.close();
	}
}
