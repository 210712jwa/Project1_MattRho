package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class ERSUsersRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ERS_USER_ROLE_ID")
	private int ersUserRoleId;
	

	@Column(name = "USER_ROLE", nullable = false, unique = true)
	private String userRole;
	
	public ERSUsersRole() {
		super();
	}
	public ERSUsersRole(String role) {
		super();
		this.userRole = role;
	}
	public int getErsUserRoleId() {
		return ersUserRoleId;
	}
	public void setErsUserRoleId(int ersUserRoleId) {
		this.ersUserRoleId = ersUserRoleId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public int hashCode() {
		return Objects.hash(ersUserRoleId, userRole);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ERSUsersRole other = (ERSUsersRole) obj;
		return ersUserRoleId == other.ersUserRoleId && Objects.equals(userRole, other.userRole);
	}
	@Override
	public String toString() {
		return "ERSUsersRole [ersUserRoleId=" + ersUserRoleId + ", userRole=" + userRole + "]";
	}
	
	
	
}
