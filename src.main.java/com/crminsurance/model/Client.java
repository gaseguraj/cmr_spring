package com.crminsurance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "client", catalog = "crm", uniqueConstraints = { @UniqueConstraint(columnNames = "ID") })
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})  
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String source;
	private String status;
	private double amount;
	private String industry;
	private String description;

	public Client(){
		
	}

	public Client(Long id, String firstName, String lastName, String email, String source, String status, double amount,
			String industry, String description) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.source = source;
		this.status = status;
		this.amount = amount;
		this.industry = industry;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "first_name", unique = false, nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", unique = false, nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email", unique = false, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "source", unique = false, nullable = true)
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	@Column(name = "status", unique = false, nullable = true)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "amount", unique = false, nullable = true)
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@Column(name = "industry", unique = false, nullable = true)
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
	@Column(name = "description", unique = false, nullable = true)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
