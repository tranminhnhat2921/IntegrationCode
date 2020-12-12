package com.integration.hr.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Emergency_Contacts")
public class EmergencyContacts {

	@Id
	private BigDecimal Employee_ID;
	private String Emergency_Contact_Name;
	private String Phone_Number;
	private String Relationship;

	public EmergencyContacts() {
		super();
	}

	public EmergencyContacts(BigDecimal employee_ID, String emergency_Contact_Name, String phone_Number,
			String relationship) {
		super();
		Employee_ID = employee_ID;
		Emergency_Contact_Name = emergency_Contact_Name;
		Phone_Number = phone_Number;
		Relationship = relationship;
	}

	public BigDecimal getEmployee_ID() {
		return Employee_ID;
	}

	public void setEmployee_ID(BigDecimal employee_ID) {
		Employee_ID = employee_ID;
	}

	public String getEmergency_Contact_Name() {
		return Emergency_Contact_Name;
	}

	public void setEmergency_Contact_Name(String emergency_Contact_Name) {
		Emergency_Contact_Name = emergency_Contact_Name;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getRelationship() {
		return Relationship;
	}

	public void setRelationship(String relationship) {
		Relationship = relationship;
	}

}
