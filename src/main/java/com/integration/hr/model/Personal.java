package com.integration.hr.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Personal")
public class Personal {
	@Id
	private BigDecimal Employee_ID;
	private String First_Name;
	private String Last_Name;
	private String Middle_Initial;
	private String Address1;
	private String Address2;
	private String City;
	private String State;
	private BigDecimal Zip;
	private String Email;
	private String Phone_Number;
	private String Social_Security_Number;
	private String Drivers_License;
	private String Marital_Status;
	private boolean Gender;
	private boolean Shareholder_Status;
	private BigDecimal Benefit_Plans;
	private String Ethnicity;

	public Personal() {
		super();
	}

	public Personal(BigDecimal employee_ID, String first_Name, String last_Name, String middle_Initial, String address1,
			String address2, String city, String state, BigDecimal zip, String email, String phone_Number,
			String social_Security_Number, String drivers_License, String marital_Status, boolean gender,
			boolean shareholder_Status, BigDecimal benefit_Plans, String ethnicity) {
		super();
		Employee_ID = employee_ID;
		First_Name = first_Name;
		Last_Name = last_Name;
		Middle_Initial = middle_Initial;
		Address1 = address1;
		Address2 = address2;
		City = city;
		State = state;
		Zip = zip;
		Email = email;
		Phone_Number = phone_Number;
		Social_Security_Number = social_Security_Number;
		Drivers_License = drivers_License;
		Marital_Status = marital_Status;
		Gender = gender;
		Shareholder_Status = shareholder_Status;
		Benefit_Plans = benefit_Plans;
		Ethnicity = ethnicity;
	}

	public BigDecimal getEmployee_ID() {
		return Employee_ID;
	}

	public void setEmployee_ID(BigDecimal employee_ID) {
		Employee_ID = employee_ID;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getMiddle_Initial() {
		return Middle_Initial;
	}

	public void setMiddle_Initial(String middle_Initial) {
		Middle_Initial = middle_Initial;
	}

	public String getAddress1() {
		return Address1;
	}

	public void setAddress1(String address1) {
		Address1 = address1;
	}

	public String getAddress2() {
		return Address2;
	}

	public void setAddress2(String address2) {
		Address2 = address2;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public BigDecimal getZip() {
		return Zip;
	}

	public void setZip(BigDecimal zip) {
		Zip = zip;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone_Number() {
		return Phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}

	public String getSocial_Security_Number() {
		return Social_Security_Number;
	}

	public void setSocial_Security_Number(String social_Security_Number) {
		Social_Security_Number = social_Security_Number;
	}

	public String getDrivers_License() {
		return Drivers_License;
	}

	public void setDrivers_License(String drivers_License) {
		Drivers_License = drivers_License;
	}

	public String getMarital_Status() {
		return Marital_Status;
	}

	public void setMarital_Status(String marital_Status) {
		Marital_Status = marital_Status;
	}

	public boolean isGender() {
		return Gender;
	}

	public void setGender(boolean gender) {
		Gender = gender;
	}

	public boolean isShareholder_Status() {
		return Shareholder_Status;
	}

	public void setShareholder_Status(boolean shareholder_Status) {
		Shareholder_Status = shareholder_Status;
	}

	public BigDecimal getBenefit_Plans() {
		return Benefit_Plans;
	}

	public void setBenefit_Plans(BigDecimal benefit_Plans) {
		Benefit_Plans = benefit_Plans;
	}

	public String getEthnicity() {
		return Ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		Ethnicity = ethnicity;
	}

}
