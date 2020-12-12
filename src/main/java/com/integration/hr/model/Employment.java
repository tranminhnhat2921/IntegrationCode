package com.integration.hr.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Employment")
public class Employment {

	@Id
	private BigDecimal Employee_ID;
	private String Employment_Status;
	@Temporal(TemporalType.DATE)
	private Date Hire_Date;
	private String Workers_Comp_Code;
	@Temporal(TemporalType.DATE)
	private Date Termination_Date;
	@Temporal(TemporalType.DATE)
	private Date Rehire_Date;
	@Temporal(TemporalType.DATE)
	private Date Last_Review_Date;

	public Employment() {
		super();
	}

	public Employment(BigDecimal employee_ID, String employment_Status, Date hire_Date, String workers_Comp_Code,
			Date termination_Date, Date rehire_Date, Date last_Review_Date) {
		super();
		Employee_ID = employee_ID;
		Employment_Status = employment_Status;
		Hire_Date = hire_Date;
		Workers_Comp_Code = workers_Comp_Code;
		Termination_Date = termination_Date;
		Rehire_Date = rehire_Date;
		Last_Review_Date = last_Review_Date;
	}

	public BigDecimal getEmployee_ID() {
		return Employee_ID;
	}

	public void setEmployee_ID(BigDecimal employee_ID) {
		Employee_ID = employee_ID;
	}

	public String getEmployment_Status() {
		return Employment_Status;
	}

	public void setEmployment_Status(String employment_Status) {
		Employment_Status = employment_Status;
	}

	public Date getHire_Date() {
		return Hire_Date;
	}

	public void setHire_Date(Date hire_Date) {
		Hire_Date = hire_Date;
	}

	public String getWorkers_Comp_Code() {
		return Workers_Comp_Code;
	}

	public void setWorkers_Comp_Code(String workers_Comp_Code) {
		Workers_Comp_Code = workers_Comp_Code;
	}

	public Date getTermination_Date() {
		return Termination_Date;
	}

	public void setTermination_Date(Date termination_Date) {
		Termination_Date = termination_Date;
	}

	public Date getRehire_Date() {
		return Rehire_Date;
	}

	public void setRehire_Date(Date rehire_Date) {
		Rehire_Date = rehire_Date;
	}

	public Date getLast_Review_Date() {
		return Last_Review_Date;
	}

	public void setLast_Review_Date(Date last_Review_Date) {
		Last_Review_Date = last_Review_Date;
	}

}
