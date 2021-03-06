package com.cg.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.tuple.GeneratedValueGeneration;

@Entity
public class TransactionDetails {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	long transactionId;
	
	public TransactionDetails() {
		
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	private Property property;
	
	@NotBlank(message="propertyName should not be blank")
	private String propertyName;
	
	private double amount;
	@NotBlank(message="amount should not be blank")
    private	String ownerName;
	@NotBlank(message="ownerName should not be blank")
	private String tenantName;
	@NotBlank(message="tenantName should not be blank")
	private String buyerName;
	@NotBlank(message="buyerName should not be blank")
	private String transactionDate;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public double getAmmount() {
		return amount;
	}

	public void setAmmount(double ammount) {
		this.amount = ammount;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	@Override
	public String toString() {
		return "TransactionDetails [transectionId=" + transactionId + ", property=" + property + ", propertyName="
				+ propertyName + ", ammount=" + amount + ", ownerName=" + ownerName + ", tenantName=" + tenantName
				+ ", buyerName=" + buyerName + ", transectionDate=" + transactionDate + "]";
	}
}
