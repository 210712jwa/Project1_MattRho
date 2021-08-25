package com.revature.service;

import java.util.List;

import com.revature.dao.ersReimbDAO;
import com.revature.dto.AddReimbursementDTO;
import com.revature.model.ERSReimbursement;

public class ERSReimbursementService {
	private static ersReimbDAO reimbDao;
	
	public ERSReimbursementService() {
		this.reimbDao = new ersReimbDAO();
	}
	public static List<ERSReimbursement> getAllReimbursementsFromUserId(String userId) {
		int id = Integer.parseInt(userId);
		List<ERSReimbursement> reimbursements = reimbDao.getAllReimbursementsFromUserId(id);
		
		return reimbursements;
	}
	
	public static ERSReimbursement addReimbursementToUser(String userId, AddReimbursementDTO reimbursement) {
		int id = Integer.parseInt(userId);
		ERSReimbursement addedReimbursement = reimbDao.addReimbursementToUser(id, reimbursement);
		return addedReimbursement;
	}
}
