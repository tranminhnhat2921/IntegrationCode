package com.integration.hr.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Job_History")
public class JobHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private BigDecimal ID;
	private BigDecimal Employee_ID;
	private String Department;
	private String Division;
	private Date Start_Date;
	private Date End_Date;
	private String Job_Title;
	private BigDecimal Supervisor;
	private String Job_Category;
	private String Location;
	private BigDecimal Departmen_Code;
	private BigDecimal Salary_Type;
	private String Pay_Period;
	private BigDecimal Hours_per_Week;
	private boolean Hazardous_Training;
	
	public JobHistory() {
		super();
	}

	public JobHistory(BigDecimal employee_ID, String department, String division, Date start_Date,
			Date end_Date, String job_Title, BigDecimal supervisor, String job_Category, String location,
			BigDecimal departmen_Code, BigDecimal salary_Type, String pay_Period, BigDecimal hours_per_Week,
			boolean hazardous_Training) {
		super();
		Employee_ID = employee_ID;
		Department = department;
		Division = division;
		Start_Date = start_Date;
		End_Date = end_Date;
		Job_Title = job_Title;
		Supervisor = supervisor;
		Job_Category = job_Category;
		Location = location;
		Departmen_Code = departmen_Code;
		Salary_Type = salary_Type;
		Pay_Period = pay_Period;
		Hours_per_Week = hours_per_Week;
		Hazardous_Training = hazardous_Training;
	}

	public BigDecimal getID() {
		return ID;
	}

	public void setID(BigDecimal iD) {
		ID = iD;
	}

	public BigDecimal getEmployee_ID() {
		return Employee_ID;
	}

	public void setEmployee_ID(BigDecimal employee_ID) {
		Employee_ID = employee_ID;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getDivision() {
		return Division;
	}

	public void setDivision(String division) {
		Division = division;
	}

	public Date getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(Date start_Date) {
		Start_Date = start_Date;
	}

	public Date getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(Date end_Date) {
		End_Date = end_Date;
	}

	public String getJob_Title() {
		return Job_Title;
	}

	public void setJob_Title(String job_Title) {
		Job_Title = job_Title;
	}

	public BigDecimal getSupervisor() {
		return Supervisor;
	}

	public void setSupervisor(BigDecimal supervisor) {
		Supervisor = supervisor;
	}

	public String getJob_Category() {
		return Job_Category;
	}

	public void setJob_Category(String job_Category) {
		Job_Category = job_Category;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public BigDecimal getDepartmen_Code() {
		return Departmen_Code;
	}

	public void setDepartmen_Code(BigDecimal departmen_Code) {
		Departmen_Code = departmen_Code;
	}

	public BigDecimal getSalary_Type() {
		return Salary_Type;
	}

	public void setSalary_Type(BigDecimal salary_Type) {
		Salary_Type = salary_Type;
	}

	public String getPay_Period() {
		return Pay_Period;
	}

	public void setPay_Period(String pay_Period) {
		Pay_Period = pay_Period;
	}

	public BigDecimal getHours_per_Week() {
		return Hours_per_Week;
	}

	public void setHours_per_Week(BigDecimal hours_per_Week) {
		Hours_per_Week = hours_per_Week;
	}

	public boolean isHazardous_Training() {
		return Hazardous_Training;
	}

	public void setHazardous_Training(boolean hazardous_Training) {
		Hazardous_Training = hazardous_Training;
	}
	
}
