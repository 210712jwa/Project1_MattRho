package com.revature.util;

import java.sql.Blob;
//import java.sql.Date;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.model.ERSUsersRole;
import com.revature.dto.AddReimbursementDTO;
import com.revature.model.ERSReimbursement;
import com.revature.model.ERSReimbursementStatus;
import com.revature.model.ERSReimbursementType;
import com.revature.model.ERSUsers;

public class PopulateDataInDatabase {
	public static void main(String[] args) {
		populateReinbursementStatus_ReinbursementType_UserRole();
		addSampleUsers();
		addReimbursements_matt123();
	}
	private static void populateReinbursementStatus_ReinbursementType_UserRole() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		ERSUsersRole admin = new ERSUsersRole("admin");
		ERSUsersRole user = new ERSUsersRole("user");
		session.persist(admin);
		session.persist(user);
		
		ERSReimbursementStatus pending = new ERSReimbursementStatus("pending");
		ERSReimbursementStatus approved = new ERSReimbursementStatus("approved");
		ERSReimbursementStatus denied = new ERSReimbursementStatus("denied");
		session.persist(pending);
		session.persist(approved);
		session.persist(denied);
		
		ERSReimbursementType food = new ERSReimbursementType("food");
		ERSReimbursementType drink = new ERSReimbursementType("drink");
		ERSReimbursementType lodging = new ERSReimbursementType("lodging");
		
		session.persist(food);
		session.persist(drink);
		session.persist(lodging);
		
		tx.commit();
		session.close();
	}
	
	private static void addSampleUsers() {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		ERSUsers adminUser1 = new ERSUsers("matt123", "123", "Matt", "Rho", "matt.rho@rev.net");
		//ERSUsersRole admin = (ERSUsersRole) session.createQuery("FROM ERSUsersRole ur WHERE ur.role = 'admin'").getSingleResult();
		
		//adminUser1.setUserRole(admin);
		adminUser1.setUserRole(session.get(ERSUsersRole.class, 1));
		
		
		
		//ERSUsersRole user = (ERSUsersRole) session.createQuery("FROM ERSUsersRole ur WHERE ur.role = 'user'").getSingleResult();
		ERSUsers regularUser1 = new ERSUsers("test123", "456", "test", "testing", "test@test.com");
		//"matt123", "123", "Matt", "Rho", "matt.rho@rev.net
	
		regularUser1.setUserRole(session.get(ERSUsersRole.class, 2));
		ERSUsers regularUser2 = new ERSUsers("john123", "123456", "John", "Doe", "johndoe@email.com");
		regularUser2.setUserRole(session.get(ERSUsersRole.class, 2));
		
		session.persist(adminUser1);
		session.persist(regularUser1);
		session.persist(regularUser2);
		
		tx.commit();
		session.close();
	}
	
	private static void addReimbursements_matt123() {//int id, AddReimbursementDTO reimbursement) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Timestamp submitted = new Timestamp(2021, 8, 16, 12, 30, 52, 12);
		Timestamp resolved = new Timestamp(2021, 8, 17, 3, 32, 36, 37);
		Blob receipt = null;
		
		ERSReimbursement reimbursement = new ERSReimbursement(submitted, resolved, 100, "Example", receipt);
		reimbursement.setReimbAuthor(session.get(ERSUsers.class, 1));
		reimbursement.setReimbResolver(session.get(ERSUsers.class, 2));
		reimbursement.setReimbStatus(session.get(ERSReimbursementStatus.class, 1));
		reimbursement.setReimbType(session.get(ERSReimbursementType.class, 1));
		session.persist(reimbursement);
		
		//reimbursement.setReimbStatus(session.get)
		
		//ERSUsers matt123 = (ERSUsers) session.createQuery("FROM ersuser u WHERE u.username = 'matt123'").getSingleResult();
		
		//ERSReimbursementStatus pending = (ERSReimbursementStatus) session.createQuery("FROM ersuser s WHERE s.status = 'pending'").getSingleResult();
		
		//ERSReimbursementType food = (ERSReimbursementType) session.createQuery("FROM REIMB_TYPE r WHERE r.type = 'food'").getSingleResult();
		//ERSReimbursementType drink = (ERSReimbursementType) session.createQuery("FROM REIMB_TYPE r WHERE r.type = 'drink'").getSingleResult();
		//ERSReimbursementType lodging = (ERSReimbursementType) session.createQuery("FROM REIMB_TYPE r WHERE r.type = 'lodging'").getSingleResult();
		
		//ERSUsers author = new ERSUsers("mrho" , "123", "Matt", "Rho", "mrho@revature.net" );
		//ERSUsers resolver = new ERSUsers("mrho062", "456", "matt", "rho", "mrho062@revature.net");
		//ERSReimbursementStatus status = new ERSReimbursementStatus("status");
		//ERSReimbursementType type = new ERSReimbursementType("food");
		//ERSReimbursement reimb1 = new ERSReimbursement(1000, "asdf", matt123, resolver, pending, food);
		//ERSReimbursement addedReimbursement = new ERSReimbursement();
		//Date date = new Date();
		//Timestamp submitted = new Timestamp(date.getTime());
		
		//Date date1 = new Date();
		//Timestamp resolved = new Timestamp(date1.getTime());
		//ERSReimbursement reinbursement = new ERSReimbursement(submitted, resolved, 1000, "eat lasagne", "Matt", "Matthew", "pending", "food");
		//ERSReimbursement reimb1 = new ERSReimbursement(submitted, resolved, 1000, "Example", receipt);
		//ERSReimbursement reimb1 = new ERSReimbursement();
		
		//session.persist(reimb1);
		//reimb1.setReimbAuthor(session.get(ERSUsers.class, 1));
		//reimb1.setReimbResolver(session.get(ERSUsers.class, 0));
		//reimb1.setReimbType(session.get(ERSReimbursementType.class, reimbursement.getType()));
		//reimb1.setReimbType(session.get(ERSReimbursementType.class, 1));
		//reimb1.setReimbDescription(reimbursement.getReimbDescription());
		//reimb1.setReimbAmount(reimbursement.getReimbAmount());
		
		//reimb1.setReimbStatus(session.get(ERSReimbursementStatus.class, 1));
		
		//ERSReimbursement reimb2 = new ERSReimbursement(submitted, resolved, 2000, "Example", receipt);
		//session.persist(reimb2);
		//reimb2.setReimbAuthor(session.get(ERSUsers.class, 1));
		//reimb2.setReimbResolver(session.get(ERSUsers.class, 2));
		//reimb2.setReimbType(session.get(ERSReimbursementType.class, 1));
		//reimb2.setReimbStatus(session.get(ERSReimbursementStatus.class, 2));
		//session.persist(reimb1);
		//reimb1.setReimbAuthor(123);
		//reimb1.setReimbStatusId(1);
		//reimb1.setReimbTypeId(1);
		
		//session.persist(reimb1);
		tx.commit();
		session.close();
	}
}
