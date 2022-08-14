package com.quintrix.banking.transactions;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.quintrix.banking.accounts.Account;
import com.quintrix.banking.accounts.AccountsRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
//import java.util.Set;
import java.util.List;

import javax.transaction.Transactional;

/***
 * Please read about JPA repositories and utilize them here
 * @author drhin
 *
 */

@Repository
@Component
public class TransactionsRepository {
//public interface TransactionsRepository extends CrudRepository<Transaction, Long> {
	
	//@Modifying
	//@Query ("update Transaction sourceAccountId set date = getdate()")
	//public Set<Transaction> getAllPendingTransactions(Date date);
	@Transactional
	@Modifying
	@Query ("update Transaction transactionToSubmit set amount = transactionToSubmit.amount, date = transactionToSubmit.date, sourceAccountId = transactionToSubmit.sourceAccountId, destinationAccountId = transactionToSubmit.destinationAccountId, type = transactionToSubmit.type")
	public void submitNewTransaction(Transaction transactionToSubmit) {
		/*transactionToSubmit.sourceAccountId
		Account found = AccountsRepository.findAccountById(transactionToSubmit.sourceAccountId);
		
		if(transactionToSubmit.amount > found.currentBalance)
			throw new EmptyStackException();*/
	}
	@Transactional
	@Modifying
	@Query ("select t from Transaction t where date = batchDate")
	public void startBatchProcessing(Date batchDate) {}
	
}
