package com.quintrix.banking.accounts;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AccountsRepository extends CrudRepository<Account, Long>  {

	public Account findAccountByOwnerName(String location);
	public Account findAccountById(long id);
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
