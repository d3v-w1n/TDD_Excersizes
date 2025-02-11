package com.quintrix.banking.tdd;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.quintrix.banking.accounts.Account;
import com.quintrix.banking.accounts.AccountsRepository;
import com.quintrix.banking.company.Branch;
import com.quintrix.banking.company.CompanyRepository;
import com.quintrix.banking.transactions.Batch;
import com.quintrix.banking.transactions.Transaction;
import com.quintrix.banking.transactions.TransactionType;
import com.quintrix.banking.transactions.TransactionsRepository;

import graphql.com.google.common.collect.Sets;

@SpringBootTest
public class BusinessLogicTestDrivenDevelopment {
	
	@Autowired
	CompanyRepository companyDb;
	@Autowired
	AccountsRepository accountsDb;
	@Autowired
	TransactionsRepository transactionsDb;

	String testerLocation = null;
	long testId;
	
	
	@Test
	public void canAddBranch() {
		Branch testBranch = new Branch();
		testBranch.accounts = Sets.newHashSet();
		testBranch.location = testerLocation; // VARIABLE-REFACTOR
		assert(companyDb.save(testBranch) != null); //companyDb.save() was previously addBranch()
	}

	@Test
	public void canQueryBranches() {
		Branch testBranch = companyDb.findBranchByLocation(testerLocation);
		assert(testBranch != null);
	}
	
	@Test
	public void canAddAccount() {
		Account testAccount = makeAccount("General Zod");
		//  ** The following line may clash with the auto ID generation found in DataModel.java
		@SuppressWarnings("unused")
		long testId = testAccount.id;
		accountsDb.addAccount(testAccount);
		}
	
	@Test
	public void canFindAccountById() {
		//Account testAccount = makeAccount("General Zod");//Added line into Testing - SEPARATE JPA REPOS REQUESTED
		//  ** If auto ID generation created an issue with specifying an ID then this test will need to first locate a valid account ID before performing this search
		Account testAccount = accountsDb.findAccountById(testId);
		assert(testAccount != null);
	}
	
	@Test
	public void canFindAccountByName() {
		//Account testAccount = makeAccount("General Zod");
		Account testAccount = accountsDb.findAccountByOwnerName("Zod, General");
		assert(testAccount != null);
	}
	
	@Test
	public void canUpdateAccountInfo() {
		Account testAccount = accountsDb.findAccountByOwnerName("General Zod");
		testAccount.ownerName = "Batman";
		accountsDb.updateAccount(testAccount);
		testAccount = accountsDb.findAccountByOwnerName("Batman");
		assert(testAccount != null && testAccount.ownerName.equals("Batman"));
	}
	
	@Test
	public void canCloseAccount() {
		Account testAccount = accountsDb.findAccountByOwnerName("Batman");
		accountsDb.closeAccount(testAccount);
		testAccount = accountsDb.findAccountByOwnerName("Batman");
		assert(testAccount.closed != null);
	}
	
	@Test
	public void canStoreTwoNewAccounts() {
		Account newAccount1 = makeAccount("Thing 1");
		Account newAccount2 = makeAccount("Thing 2");
		newAccount1.currentBalance = 50.0;
		newAccount2.currentBalance = 0.0;
		accountsDb.addAccount(newAccount1);
		accountsDb.addAccount(newAccount2);
	}
	
	@Test
	public void canCreateValidTransaction() {
		Account sourceAccount = accountsDb.findAccountByOwnerName("Thing 1");
		Account destAccount = accountsDb.findAccountByOwnerName("Thing 2");
		Transaction newTransaction = new Transaction();
		newTransaction.amount = 50.0;
		newTransaction.date = new Date();
		newTransaction.sourceAccountId = sourceAccount.id;
		newTransaction.destinationAccountId = destAccount.id;
		newTransaction.type = TransactionType.Transfer;
		transactionsDb.submitNewTransaction(newTransaction);
	}
	
	@Test
	public void cannotCreateInvalidTransaction() {
		Account sourceAccount = accountsDb.findAccountByOwnerName("Thing 2");
		Account destAccount = accountsDb.findAccountByOwnerName("Thing 1");
		Transaction newTransaction = new Transaction();
		newTransaction.amount = 1.0;
		newTransaction.date = new Date();
		newTransaction.sourceAccountId = sourceAccount.id;
		newTransaction.destinationAccountId = destAccount.id;
		newTransaction.type = TransactionType.Transfer;
		assertThrows(Exception.class, () -> transactionsDb.submitNewTransaction(newTransaction));
	}
	
	@Test
	public void canBatchProcessTransactions() {
		Batch newBatch = new Batch();
		transactionsDb.startBatchProcessing(newBatch.date);
	}
	
	@Test
	public void batchProcessIsAccurate() {
		Account testAccount1 = accountsDb.findAccountByOwnerName("Thing 1");
		Account testAccount2 = accountsDb.findAccountByOwnerName("Thing 2");
		assert(testAccount1.currentBalance == 0.0 && testAccount2.currentBalance == 50.0);
	}
	
	private Account makeAccount(String owner) {
		Account testAccount = new Account();
		testAccount.currentBalance = 0.0;
		testAccount.homeBranch = companyDb.findBranchByLocation(testerLocation);
		testAccount.opened = new Date();
		testAccount.transactions = Sets.newHashSet();
		testAccount.ownerName = owner;
		return testAccount;
	}
}
