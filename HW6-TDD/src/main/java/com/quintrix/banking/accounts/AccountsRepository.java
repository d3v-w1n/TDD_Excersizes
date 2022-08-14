package com.quintrix.banking.accounts;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;




@Repository
@Component
public class AccountsRepository {
//public interface AccountsRepository extends CrudRepository<Account, Long>  {

	public List<Account> accountList = new ArrayList<>();
	
	//@Query ("select a from Account a where location = name")
	public Account findAccountByOwnerName(String location) {
		
		String [] splitName = location.split("\\W*\\s+");
		
		Account found = new Account();
		
		for(String s:splitName) {
			found = accountList.stream().filter(account -> account.ownerName.toLowerCase().contains(s.toLowerCase())).findFirst().orElse(found);
			if(found!= null)
				return found;
		}
		
		
		return found;
	}
	
	//@Query ("select a from Account a where findId = ID")
	public Account findAccountById(long findId) {
			
		Account found = new Account();
	
		found = accountList.stream().filter(account -> account.getId() == findId).findFirst().orElse(null);
		return found;
	}
	
	@Transactional
	@Modifying
	@Query ("update Account accountToAdd set accountToAdd.opened = CURRENT_TIMESTAMP")
	public void addAccount(Account accountToAdd) {
	}
	@Transactional
	@Modifying
	@Query ("update Account accountToClose set accountToClose.closed = CURRENT_TIMESTAMP")
	public void closeAccount(Account accountToClose) {
	}
	@Transactional
	@Modifying
	@Query ("update Account updatedAccount set ownerName = updatedAccount.ownerName")
	public void updateAccount(Account updatedAccount) {
	}
	
}
