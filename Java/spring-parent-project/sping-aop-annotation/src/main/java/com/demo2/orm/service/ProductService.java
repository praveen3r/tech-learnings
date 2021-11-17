package com.demo2.orm.service;

import com.demo2.orm.dao.ProductDao;
import com.demo2.orm.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public void add(Product product) {
		productDao.persist(product);
	}
	
	public void addAll(Collection<Product> products) {
		for (Product product : products) {
			productDao.persist(product);
		}
	}
	
	public List<Product> listAll() {
		return productDao.findAll();
		
	}

}
