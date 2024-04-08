package com.springcrud.SpringCrud.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.SpringCrud.IncomingDto.ProductDto;
import com.springcrud.SpringCrud.entity.Product;
import com.springcrud.SpringCrud.repository.CrudRepository;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.ValidationException;


@Service
public class CrudServiceImpl implements CrudService{

	private static final Logger logger = LoggerFactory.getLogger(CrudServiceImpl.class);

	@Autowired
	CrudRepository crudRepository;
	
	@Override
	public String addProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		
		logger.info("In addProduct");
		if(productDto.getName()==null || productDto.getName().isBlank()) {
			return "Error: Producut name Should not be blank";
		}
		Product product =new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
	
		crudRepository.save(product);
		
		return "Scuccessfully added the product";
	}

	@Override
	public ProductDto getProductById(Long id) {
		// TODO Auto-generated method stub
		logger.info("In getProductById");
		ProductDto productDto=new ProductDto();
		Optional<Product> product= crudRepository.findById(id);
		Product productobj=product.get();
		
		productDto.setId(productobj.getId());
		productDto.setName(productobj.getName());
		productDto.setDescription(productobj.getDescription());
		productDto.setPrice(productobj.getPrice());
	
		return productDto;
	}

	@Override
	public String updateProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		logger.info("In updateProduct");
		
		  if(productDto.getName()==null || productDto.getName().isBlank())
		   return "Error: Producut name Should not be blank";
		  
		 
	
		Optional<Product> productifExists= crudRepository.findById(productDto.getId());
	
		if(!productifExists.isEmpty()) {
			try {
        Product product =productifExists.get();		
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		
		crudRepository.save(product);
		
		}
		
		catch(Exception  e) {
			
			return "Something went wrong please try again! " + e.getMessage();
		}
			return "Scuccessfully Updated the product";
		}
		else {
			return "Product of given Id does not Exist!";
		}
		
	}

	@Override
	public String deleteProduct(Long id) {
		logger.info("In deleteProduct");
		Optional<Product> product= crudRepository.findById(id);
		
		if(!product.isEmpty()) {
		crudRepository.deleteById(id);
		return "Deleted the product of Id:"+id;
		}
		else {
			return "Product of given Id does not Exist!";
		}
	}

}
