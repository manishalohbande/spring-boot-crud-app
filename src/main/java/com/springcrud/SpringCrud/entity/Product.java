package com.springcrud.SpringCrud.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter 
@Getter
public class Product extends BaseEntity{
	@Id
    private Long id;
	@NotBlank
    @Column(nullable = false, length = 255)
	private String name ;
	
	
    @Column(nullable = false, length = 255)
	private String description;	

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
}
