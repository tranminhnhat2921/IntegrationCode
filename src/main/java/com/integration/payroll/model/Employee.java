package com.integration.payroll.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	private int Employee_Number;
	private int idEmployee;
	private String Last_Name;
	private String First_Name;
	private int SSN;
	private String Pay_Rate;
	private int PayRates_id;
	private int Vacation_Days;
	private int Paid_To_Date;
	private int Paid_Last_Year;

	public Employee() {
		super();
	}

	public Employee(int employee_Number, int idEmployee, String last_Name, String first_Name, int sSN, String pay_Rate,
			int payRates_id, int vacation_Days, int paid_To_Date, int paid_Last_Year) {
		super();
		Employee_Number = employee_Number;
		this.idEmployee = idEmployee;
		Last_Name = last_Name;
		First_Name = first_Name;
		SSN = sSN;
		Pay_Rate = pay_Rate;
		PayRates_id = payRates_id;
		Vacation_Days = vacation_Days;
		Paid_To_Date = paid_To_Date;
		Paid_Last_Year = paid_Last_Year;
	}

	public int getEmployee_Number() {
		return Employee_Number;
	}

	public void setEmployee_Number(int employee_Number) {
		Employee_Number = employee_Number;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public int getSSN() {
		return SSN;
	}

	public void setSSN(int sSN) {
		SSN = sSN;
	}

	public String getPay_Rate() {
		return Pay_Rate;
	}

	public void setPay_Rate(String pay_Rate) {
		Pay_Rate = pay_Rate;
	}

	public int getPayRates_id() {
		return PayRates_id;
	}

	public void setPayRates_id(int payRates_id) {
		PayRates_id = payRates_id;
	}

	public int getVacation_Days() {
		return Vacation_Days;
	}

	public void setVacation_Days(int vacation_Days) {
		Vacation_Days = vacation_Days;
	}

	public int getPaid_To_Date() {
		return Paid_To_Date;
	}

	public void setPaid_To_Date(int paid_To_Date) {
		Paid_To_Date = paid_To_Date;
	}

	public int getPaid_Last_Year() {
		return Paid_Last_Year;
	}

	public void setPaid_Last_Year(int paid_Last_Year) {
		Paid_Last_Year = paid_Last_Year;
	}

}
