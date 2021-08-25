package com.revature.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ersreimbursement")
public class ERSReimbursement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@ManyToOne
	//@JoinColumn
	@Column(name = "REIMB_ID")
	private int reimbId;
	
	@Column(name = "REIMB_AMOUNT")
	private int reimbAmount;
	
	@Column(name =  "REIMB_SUBMITTED")
	private Timestamp reimbSubmitted;
	
	@Column(name = "REIMB_RESOLVED")
	private Timestamp reimbResolved;
	
	@Column(name = "REIMB_DESCRIPTION")
	private String reimbDescription;
	
	@Column(name = "REIMB_RECEIPT")
	private Blob reimbReceipt;
	
	@ManyToOne
	@JoinColumn(name = "REIMB_AUTHOR", nullable = false)
	private ERSUsers reimbAuthor;
	
	@ManyToOne
	@JoinColumn(name = "REIMB_RESOLVER")
	private ERSUsers reimbResolver;
	
	@ManyToOne
	@JoinColumn(name = "REIMB_STATUS_ID")
	private ERSReimbursementStatus reimbStatus;
	
	@ManyToOne
	@JoinColumn(name = "REIMB_TYPE_ID")
	private ERSReimbursementType reimbType;
	
	
	public ERSReimbursement() {
		super();
	}
	

	public ERSReimbursement(Timestamp reimbSubmitted, Timestamp reimbResolved, int reimbAmount,
			String reimbDescription, Blob reimbReceipt) {//, ERSUsers reimbAuthor, ERSUsers reimbResolver,
		//	ERSReimbursementStatus reimbStatus, ERSReimbursementType reimbType) {
		super();
		this.reimbAmount = reimbAmount;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
		this.reimbDescription = reimbDescription;
		this.reimbReceipt = reimbReceipt;
		//this.reimbAuthor = reimbAuthor;
		//this.reimbResolver = reimbResolver;
		//this.reimbStatus = reimbStatus;
		//this.reimbType = reimbType;
	}
	
	public int getReimbId() {
		return reimbId;
	}


	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}


	public int getReimbAmount() {
		return reimbAmount;
	}


	public void setReimbAmount(int reimbAmount) {
		this.reimbAmount = reimbAmount;
	}


	public String getReimbDescription() {
		return reimbDescription;
	}


	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}


	public ERSUsers getReimbAuthor() {
		return reimbAuthor;
	}


	public void setReimbAuthor(ERSUsers reimbAuthor) {
		this.reimbAuthor = reimbAuthor;
	}


	public ERSUsers getReimbResolver() {
		return reimbResolver;
	}


	public void setReimbResolver(ERSUsers reimbResolver) {
		this.reimbResolver = reimbResolver;
	}


	public ERSReimbursementStatus getReimbStatus() {
		return reimbStatus;
	}


	public void setReimbStatus(ERSReimbursementStatus reimbStatus) {
		this.reimbStatus = reimbStatus;
	}


	public ERSReimbursementType getReimbType() {
		return reimbType;
	}


	public void setReimbType(ERSReimbursementType reimbType) {
		this.reimbType = reimbType;
	}

	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}

	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}

	public Timestamp getReimbResolved() {
		return reimbResolved;
	}
	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}

	public Blob getReimbReceipt() {
		return reimbReceipt;
	}
	
	public void setReimbReceipt(Blob reimbReceipt) {
		this.reimbReceipt = reimbReceipt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(reimbAmount, reimbAuthor, reimbDescription, reimbId, reimbResolver, reimbStatus, reimbType);
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERSReimbursement other = (ERSReimbursement) obj;
		return reimbAmount == other.reimbAmount && Objects.equals(reimbAuthor, other.reimbAuthor)
				&& Objects.equals(reimbDescription, other.reimbDescription) && reimbId == other.reimbId
				&& Objects.equals(reimbResolver, other.reimbResolver) && Objects.equals(reimbStatus, other.reimbStatus)
				&& Objects.equals(reimbType, other.reimbType);
	}







	@Override
	public String toString() {
		return "ERSReimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbDescription="
				+ reimbDescription + ", reimbAuthor=" + reimbAuthor + ", reimbResolver=" + reimbResolver
				+ ", reimbStatus=" + reimbStatus + ", reimbType=" + reimbType + "]";
	}
	
	
	
	
	
	
	
	





	
	//@ManyToOne
	//@JoinColumn(name = "REIMB_STATUS_ID")
	//@JoinColumn(name = "REIMB_TYPE_ID")
	//@JoinColumn(name = "REIMB_AUTHOR")
	//@JoinColumn(name = "REIMB_ID")
	
	
	

}
