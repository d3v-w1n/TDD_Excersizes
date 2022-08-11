package com.quintrix.banking.company;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.quintrix.banking.DataModel;
@Entity
public class Organization extends DataModel  {

	@Id
	public long id;	
	
	@ElementCollection
	public Set<Branch> branches;
	
}
