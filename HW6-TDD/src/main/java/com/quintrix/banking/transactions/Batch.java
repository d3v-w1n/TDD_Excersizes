package com.quintrix.banking.transactions;

import java.util.Date;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.quintrix.banking.DataModel;

@Entity
public class Batch extends DataModel  {

	@Id
	public long id;	
	
	public boolean finalized;
	@ManyToOne(targetEntity=Transaction.class)
	@JoinColumn(name="sourceAccountId")
	@ElementCollection
	public Set<Transaction> transactions;
	public Date date;
	
	public boolean isFinal() {
		return finalized;
	}
}
