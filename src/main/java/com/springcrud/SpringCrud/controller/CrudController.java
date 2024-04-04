package com.springcrud.SpringCrud.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcrud.SpringCrud.IncomingDto.ProductDto;
import com.springcrud.SpringCrud.service.CrudService;

@RestController
@RequestMapping(value = "/crud", produces = APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", maxAge = 3600)
public class CrudController {

	private static final Logger logger = LoggerFactory.getLogger(CrudController.class);


	@Autowired
	CrudService crudService;
	
	@PostMapping(value = "/addProduct", consumes = APPLICATION_JSON_VALUE)
	public  String addProduct(@RequestBody ProductDto productDto) {
		logger.info("In addProduct");
	
		String response=crudService.addProduct(productDto);
		
		return response;
		
	}
	@GetMapping(value = "/getProductById/{productId}", consumes = APPLICATION_JSON_VALUE)
	public   ProductDto getProductById(@PathVariable Long productId) {
		
		logger.info("In getProductById");
		ProductDto response=crudService.getProductById(productId);
		
		return response;
		
	}
	@PutMapping(value = "/updateProduct", consumes = APPLICATION_JSON_VALUE)
	public  String updateProduct(@RequestBody ProductDto productDto) {
		
		logger.info("In updateProduct");
		String response=crudService.updateProduct(productDto);
		
		return response;
		
	}
	@DeleteMapping(value = "/deleteProduct/{productId}", consumes = APPLICATION_JSON_VALUE)
	public String deleteProduct(@PathVariable Long productId) {
		
		logger.info("In deleteProduct");
		String response=crudService.deleteProduct(productId);
		
		return response;
		
	}
}
