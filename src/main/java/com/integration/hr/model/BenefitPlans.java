package com.integration.hr.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Benefit_Plans")
public class BenefitPlans {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	BigDecimal Benefit_Plan_ID;
	String Plan_Name;
	BigDecimal Deductable;
	int Percentage_CoPay;

	public BenefitPlans() {
		super();
	}

	public BenefitPlans(String plan_Name, BigDecimal deductable, int percentage_CoPay) {
		super();
		Plan_Name = plan_Name;
		Deductable = deductable;
		Percentage_CoPay = percentage_CoPay;
	}

	public BigDecimal getBenefit_Plan_ID() {
		return Benefit_Plan_ID;
	}

	public void setBenefit_Plan_ID(BigDecimal benefit_Plan_ID) {
		Benefit_Plan_ID = benefit_Plan_ID;
	}

	public String getPlan_Name() {
		return Plan_Name;
	}

	public void setPlan_Name(String plan_Name) {
		Plan_Name = plan_Name;
	}

	public BigDecimal getDeductable() {
		return Deductable;
	}

	public void setDeductable(BigDecimal deductable) {
		Deductable = deductable;
	}

	public int getPercentage_CoPay() {
		return Percentage_CoPay;
	}

	public void setPercentage_CoPay(int percentage_CoPay) {
		Percentage_CoPay = percentage_CoPay;
	}

}
