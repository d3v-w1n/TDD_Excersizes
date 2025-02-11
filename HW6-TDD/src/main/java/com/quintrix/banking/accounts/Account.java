package com.quintrix.banking.accounts;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

import com.quintrix.banking.DataModel;
import com.quintrix.banking.company.Branch;
import com.quintrix.banking.transactions.Transaction;

@Entity
@Table(name="Account_table")
public class Account extends DataModel implements Serializable {
	
	public Account() {}
	@Id
	@Column(name = "ID")
	public long id;
	
	@ManyToOne(targetEntity=Transaction.class)
	@JoinColumn(name="sourceAccountId")
	@ElementCollection
	public Set<Transaction> transactions;
	public AccountType type;
	@Column(name = "name")
	public String ownerName;
	public Date opened;
	public Date closed;
	@OneToOne
	@JoinColumn(name="id")
	public Branch homeBranch;
	// Balance after most recent batch
	@Column(name = "bal")
	public double currentBalance;

	public long getId(){
		return id;
	}
}


