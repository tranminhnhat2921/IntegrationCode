package com.integration.payroll.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pay_rates")
public class PayRate {
	@Id
	int PayRates_id;
	String Pay_Rate_Name;
	BigDecimal Value;
	BigDecimal Tax_Percentage;
	int Pay_Type;
	BigDecimal Pay_Amount;
	BigDecimal PT_Level_C;

	public PayRate() {
		super();
	}

	public PayRate(int payRates_id, String pay_Rate_Name, BigDecimal value, BigDecimal tax_Percentage, int pay_Type,
			BigDecimal pay_Amount, BigDecimal pT_Level_C) {
		super();
		PayRates_id = payRates_id;
		Pay_Rate_Name = pay_Rate_Name;
		Value = value;
		Tax_Percentage = tax_Percentage;
		Pay_Type = pay_Type;
		Pay_Amount = pay_Amount;
		PT_Level_C = pT_Level_C;
	}

	public int getPayRates_id() {
		return PayRates_id;
	}

	public void setPayRates_id(int payRates_id) {
		PayRates_id = payRates_id;
	}

	public String getPay_Rate_Name() {
		return Pay_Rate_Name;
	}

	public void setPay_Rate_Name(String pay_Rate_Name) {
		Pay_Rate_Name = pay_Rate_Name;
	}

	public BigDecimal getValue() {
		return Value;
	}

	public void setValue(BigDecimal value) {
		Value = value;
	}

	public BigDecimal getTax_Percentage() {
		return Tax_Percentage;
	}

	public void setTax_Percentage(BigDecimal tax_Percentage) {
		Tax_Percentage = tax_Percentage;
	}

	public int getPay_Type() {
		return Pay_Type;
	}

	public void setPay_Type(int pay_Type) {
		Pay_Type = pay_Type;
	}

	public BigDecimal getPay_Amount() {
		return Pay_Amount;
	}

	public void setPay_Amount(BigDecimal pay_Amount) {
		Pay_Amount = pay_Amount;
	}

	public BigDecimal getPT_Level_C() {
		return PT_Level_C;
	}

	public void setPT_Level_C(BigDecimal pT_Level_C) {
		PT_Level_C = pT_Level_C;
	}

}
