package com.integration.hr.model;

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
	private int employee_ID;
	private String employment_Status;
	@Temporal(TemporalType.DATE)
	private Date hire_Date;
	private String workers_Comp_Code;
	@Temporal(TemporalType.DATE)
	private Date termination_Date;
	@Temporal(TemporalType.DATE)
	private Date rehire_Date;
	@Temporal(TemporalType.DATE)
	private Date last_Review_Date;

	public Employment() {
		super();
	}

	public Employment(int employee_ID, String employment_Status, Date hire_Date, String workers_Comp_Code,
			Date termination_Date, Date rehire_Date, Date last_Review_Date) {
		super();
		this.employee_ID = employee_ID;
		this.employment_Status = employment_Status;
		this.hire_Date = hire_Date;
		this.workers_Comp_Code = workers_Comp_Code;
		this.termination_Date = termination_Date;
		this.rehire_Date = rehire_Date;
		this.last_Review_Date = last_Review_Date;
	}

	public int getEmployee_ID() {
		return employee_ID;
	}

	public void setEmployee_ID(int employee_ID) {
		this.employee_ID = employee_ID;
	}

	public String getEmployment_Status() {
		return employment_Status;
	}

	public void setEmployment_Status(String employment_Status) {
		this.employment_Status = employment_Status;
	}

	public Date getHire_Date() {
		return hire_Date;
	}

	public void setHire_Date(Date hire_Date) {
		this.hire_Date = hire_Date;
	}

	public String getWorkers_Comp_Code() {
		return workers_Comp_Code;
	}

	public void setWorkers_Comp_Code(String workers_Comp_Code) {
		this.workers_Comp_Code = workers_Comp_Code;
	}

	public Date getTermination_Date() {
		return termination_Date;
	}

	public void setTermination_Date(Date termination_Date) {
		this.termination_Date = termination_Date;
	}

	public Date getRehire_Date() {
		return rehire_Date;
	}

	public void setRehire_Date(Date rehire_Date) {
		this.rehire_Date = rehire_Date;
	}

	public Date getLast_Review_Date() {
		return last_Review_Date;
	}

	public void setLast_Review_Date(Date last_Review_Date) {
		this.last_Review_Date = last_Review_Date;
	}

}
