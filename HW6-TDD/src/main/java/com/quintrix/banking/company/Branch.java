package com.quintrix.banking.company;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.quintrix.banking.DataModel;
import com.quintrix.banking.accounts.Account;

@Entity
public class Branch extends DataModel {
	
	@Id
	public long id;	

	public String location;
	@OneToMany(mappedBy="id")
	public Set<Account> accounts;
	
}
