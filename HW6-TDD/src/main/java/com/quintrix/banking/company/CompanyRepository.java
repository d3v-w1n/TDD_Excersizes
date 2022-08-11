package com.quintrix.banking.company;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/***
 * Please read about JPA repositories and utilize them here
 * @author drhin
 *
 */

@Repository
@Component
public interface CompanyRepository extends CrudRepository<Branch, Long>  {

	@SuppressWarnings("unchecked")
	public Branch save(Branch newBranch);
	public Branch findBranchByLocation(String location);
	public Branch findBranchById(long id);
	
}
