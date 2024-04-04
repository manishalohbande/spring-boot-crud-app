package com.springcrud.SpringCrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter 
@Getter
public class Product extends BaseEntity{
	@Id
    private Long id;
	private String name ;
	private String description;
	private Long price ;
}
