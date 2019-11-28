package com.ustglobal.jspwithhibernate.jbql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdate {

public static void main(String[] args) {
	EntityTransaction entityTransaction = null;
	EntityManager entityManager = null;
	try {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		String jpql = "update Product set Pname=:name where Pid = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("name","Book");
		query.setParameter("id","101");
		
		
		int count = query.executeUpdate();
		
		
		System.out.println(count);
		entityTransaction.commit();

	} catch (Exception e) {
		e.printStackTrace();
		entityTransaction.rollback();
	}
	finally {
		entityManager.close();
	}
}

}

