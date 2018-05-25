package org.softcits.auth.model;

import java.util.List;

public class UserDisplayForm {
	
	private MbgUserAndRole user;
	private List<MbgRole> roles;
	private List<String> states;
	public MbgUserAndRole getUser() {
		return user;
	}
	public void setUser(MbgUserAndRole user) {
		this.user = user;
	}
	public List<MbgRole> getRoles() {
		return roles;
	}
	public void setRoles(List<MbgRole> roles) {
		this.roles = roles;
	}
	public List<String> getStates() {
		return states;
	}
	public void setStates(List<String> states) {
		this.states = states;
	}
	
}
