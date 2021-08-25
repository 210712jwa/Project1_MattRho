package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.revature.dto.AddReimbursementDTO;
import com.revature.dto.MessageDTO;
import com.revature.model.ERSUsers;
import com.revature.service.ERSReimbursementService;
import com.revature.model.ERSReimbursement;

import io.javalin.http.Handler;
import io.javalin.Javalin;

public class ERSReimbursementController implements Controller{
	
	private ERSReimbursementService ersReimbService;
	
	public ERSReimbursementController() {
		this.ersReimbService = new ERSReimbursementService();
	}

	private Handler getAllReimbursementsBelongingToSpecificUser = (ctx) -> {
		HttpSession session = ctx.req.getSession();
		
		if (session.getAttribute("currentUser") == null) {
			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
		} else {
			ERSUsers currentUser = (ERSUsers) session.getAttribute("currentUser");
			
			String userId = ctx.pathParam("userid");
			if (currentUser.getErsUsersId() == Integer.parseInt(userId)) {
			
				List<ERSReimbursement> reimbursements = ERSReimbursementService.getAllReimbursementsFromUserId(userId);
				ctx.json(reimbursements);
				ctx.status(200);
		}
		else {
			ctx.json(new MessageDTO("You are not the user that you want to retrieve all reimbursements from"));
			ctx.status(401);
		}
	}
};

	private Handler addReimbursementsBelongingToUser = (ctx) -> {
		HttpSession session = ctx.req.getSession();
		if (session.getAttribute("currentUser") == null) {
			ctx.json(new MessageDTO("You need to be logged in to perform this action"));
			
		} else {
			ERSUsers currentUser = (ERSUsers) session.getAttribute("currentUser");
			AddReimbursementDTO reimbursementToAdd = ctx.bodyAsClass(AddReimbursementDTO.class);
			String userId = ctx.pathParam("userid");
			if (currentUser.getErsUsersId() == Integer.parseInt(userId)) {
				ERSReimbursement addedReimbursement = ERSReimbursementService.addReimbursementToUser(userId, reimbursementToAdd);
				ctx.json(addedReimbursement);
				ctx.status(200);
			} else {
				ctx.json(new MessageDTO("You are not the user that you want to retreive all ships from"));
				ctx.status(401);
			}
		}
	};

	@Override
	public void mapEndpoints(Javalin app) {
		app.get("/ersuser/:userid/ersreimbursement", getAllReimbursementsBelongingToSpecificUser);
		app.post("/user/:userid/reimbursement", addReimbursementsBelongingToUser);
	}
}
