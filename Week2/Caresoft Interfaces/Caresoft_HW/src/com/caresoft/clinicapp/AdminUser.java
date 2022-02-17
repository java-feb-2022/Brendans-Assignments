/**
 * 
 */
package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Brendan
 *
 */
public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	private String role;
	private ArrayList<String> securityIncidents;
	
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		if(pin<99999) {
			return false;			
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		if(this.id != confirmedAuthID) {
			this.authIncident();
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<String> reportSecurityIncidents() {
		// TODO Auto-generated method stub
		return this.securityIncidents;
	}
	
	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s\n Reported By ID: %s\n Notes: %s \n", new Date(), this.id, notes);
		securityIncidents.add(report);
	}
	
	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n ID: %s \n Notes: %s \n", new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}
	
}
