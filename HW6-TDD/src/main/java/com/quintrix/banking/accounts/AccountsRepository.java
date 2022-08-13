package com.quintrix.banking.accounts;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AccountsRepository extends CrudRepository<Account, Long>  {

	@Query ("select a from Account a where locatiom = a.ownerName")
	public Account findAccountByOwnerName(String location);
	@Query ("select a from Account a where findId = a.id")
	public Account findAccountById(long findId);
	@Transactional
	@Modifying
	@Query ("update Account accountToAdd set accountToAdd.opened = CURRENT_TIMESTAMP")
	public void addAccount(Account accountToAdd);
	@Transactional
	@Modifying
	@Query ("update Account accountToClose set accountToClose.closed = CURRENT_TIMESTAMP")
	public void closeAccount(Account accountToClose);
	@Transactional
	@Modifying
	@Query ("update Account updatedAccount set ownerName = updatedAccount.ownerName")
	public void updateAccount(Account updatedAccount);
	
}
