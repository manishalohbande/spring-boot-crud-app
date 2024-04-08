package com.springcrud.SpringCrud.IncomingDto;


import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
@Setter @Getter
public class ProductDto {
	
    private Long id;	
	private String name ;
	private String description;
	private BigDecimal price ;
}
