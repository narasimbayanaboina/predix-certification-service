/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.ge.predix.certification.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.ge.predix.certification.domain.Certattemp;;

/**
 * 
 * @author Narasim
 */
public interface CertattempRepository extends JpaRepository<Certattemp, Integer> {
	

	public static final String ATTEMP_LIST_MODEL="select b from Certattemp b where b.id=(select distinct max(c.id) from Certattemp c where c.modelid=b.model.id )";

	@Query(ATTEMP_LIST_MODEL)
	public List<Certattemp> GetAttempListByModel();
	
	public List<Certattemp> findByModelid(Integer modelid);
	
	
}
