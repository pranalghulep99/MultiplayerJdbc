package com.jspider.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspider.hibernate.dto.HusbandDTO;
import com.jspider.hibernate.dto.WifeDTO;

public class HusbandWifeDAO {
	private static EntityManagerFactory createEntityManagerFactory;
	private static EntityManager createEntityManager;
	private static EntityTransaction transaction;
	
	private static void openConnection() {
		
		createEntityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
		createEntityManager = createEntityManagerFactory.createEntityManager();
		transaction = createEntityManager.getTransaction();
	}
	
	
	private static void closeConnection() {
		createEntityManagerFactory.close();
		createEntityManager.close();
		try {
			transaction.rollback();
		} catch (TransactionException e) {
			System.out.println("transaction cannot be rolled back");
		}
	}
	
	public static void main(String[] args) {
		openConnection();
		transaction.begin();
		WifeDTO wifeDTO = new WifeDTO();
		wifeDTO.setWId(1);
		wifeDTO.setWName("Urmila");
		wifeDTO.setWAge(25);
		
		
		
		HusbandDTO husbandDTO = new HusbandDTO();
		husbandDTO.setHId(1);
		husbandDTO.setHName("Raam");
		husbandDTO.setHAge(26);
		husbandDTO.setWifeDTO(wifeDTO);
		
		createEntityManager.persist(wifeDTO);
		createEntityManager.persist(husbandDTO);
		
		transaction.commit();
		closeConnection();
	}
	
}
