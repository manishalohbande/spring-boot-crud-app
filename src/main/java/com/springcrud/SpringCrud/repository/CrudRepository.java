package com.springcrud.SpringCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcrud.SpringCrud.entity.Product;

@Repository
public interface CrudRepository extends JpaRepository<Product, Long>{

}
