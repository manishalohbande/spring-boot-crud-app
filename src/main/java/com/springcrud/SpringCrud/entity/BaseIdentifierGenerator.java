package com.springcrud.SpringCrud.entity;

import java.io.Serializable;

import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class BaseIdentifierGenerator implements IdentifierGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        Random random = new Random();
        long id = random.nextLong();
        // Ensure generated ID is positive
        if (id == Long.MIN_VALUE) {
            id = Long.MAX_VALUE;
        } else {
            id = Math.abs(id);
        }
        return id;
    }
}