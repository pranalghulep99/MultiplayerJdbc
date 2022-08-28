package com.jspider.hibernate.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.TransactionException;

import com.jspider.hibernate.dto.ChildDTO;
import com.jspider.hibernate.dto.FatherDTO;

public class ChildFatherDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;

	private static void openConnections() {
		entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnections() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			try {
				entityTransaction.rollback();
			} catch (TransactionException e) {
				System.out.println("Transaction Cannot BE Rolled Back");
			}

		}
	}

	public static void main(String[] args) {
		openConnections();
		entityTransaction.begin();
		ChildDTO childDTO=new ChildDTO();
		childDTO.setId(1);
		childDTO.setName("Ashwin");
		childDTO.setAge(20);
		
		ChildDTO childDTO2=new ChildDTO();
		childDTO2.setId(2);
		childDTO2.setName("Raam");
		childDTO2.setAge(23);
		List<ChildDTO> childList=Arrays.asList(childDTO, childDTO2);
		
		entityManager.persist(childDTO);
		entityManager.persist(childDTO2);
		
		FatherDTO fatherDTO=new FatherDTO();
		fatherDTO.setId(1);
		fatherDTO.setName("Ashok");
		fatherDTO.setAge(50);
		
		
		fatherDTO.setChildren(childList);
		entityManager.persist(fatherDTO);
		entityTransaction.commit();
		closeConnections();


	}
}
