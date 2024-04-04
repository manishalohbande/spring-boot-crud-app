package com.springcrud.SpringCrud.service;

import com.springcrud.SpringCrud.IncomingDto.ProductDto;

public interface CrudService {

	String addProduct( ProductDto productDto);
	ProductDto getProductById(Long id);
	String updateProduct (ProductDto productDto);
	String deleteProduct(Long id);
}
