package com.quintrix.banking.transactions;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.quintrix.banking.DataModel;

@Entity
public class Transaction extends DataModel {
	
	@Id
	public long sourceAccountId;
	
	public long destinationAccountId;
	@ManyToOne(targetEntity=Batch.class)
	public Batch batch;
	public double amount;
	public Date date;
	public String comments;
	public TransactionType type;
	
	public boolean isPendingTransaction() {
		return batch == null || !batch.isFinal();
	}
}
