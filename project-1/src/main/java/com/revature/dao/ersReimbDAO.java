package com.revature.dao;

import com.revature.model.ERSReimbursement;
import com.revature.model.ERSReimbursementStatus;
import com.revature.model.ERSReimbursementType;
import com.revature.model.ERSUsers;
import com.revature.dto.AddReimbursementDTO;
import com.revature.util.SessionFactorySingleton;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
public class ersReimbDAO {

	public List<ERSReimbursement> getAllReimbursementsFromUserId(int id) {
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		List<ERSReimbursement> ersReimbursements = session.createQuery("SELECT s FROM ERSReimbursement e JOIN e.author a.id = :userid").setParameter("userid", id).getResultList();
		return ersReimbursements;
	}
	public static ERSReimbursement addReimbursementToUser(int id, AddReimbursementDTO reimbursement) {
	
		Date date = new Date();
		Timestamp submitted = new Timestamp(date.getTime());
		Blob receipt = null;
		
		SessionFactory sf = SessionFactorySingleton.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		ERSReimbursement addedReimbursement = new ERSReimbursement();
		session.persist(addedReimbursement);
		addedReimbursement.setReimbAuthor(session.get(ERSUsers.class, id));
		addedReimbursement.setReimbType(session.get(ERSReimbursementType.class, reimbursement.getType()));
		addedReimbursement.setReimbDescription(reimbursement.getReimbDescription());
		addedReimbursement.setReimbStatus(session.get(ERSReimbursementStatus.class, 1));
		addedReimbursement.setReimbSubmitted(submitted);
		addedReimbursement.setReimbResolved(null);
		addedReimbursement.setReimbResolver(null);
		addedReimbursement.setReimbReceipt(null);
		
		tx.commit();
		session.close();
		return addedReimbursement;
	}
	
}
