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

import com.ge.predix.certification.domain.Certtestitem;

/**
 * 
 * @author Narasim
 */
public interface CertTestItemRepository extends JpaRepository<Certtestitem, Long> {
	

	public static final String GET_TEST_ITEMS= "SELECT t FROM Certtestitem t WHERE t.attemptid=:certattempid";
	//public static final String GET_TEST_ITEMS= "SELECT t FROM Certtestitem t WHERE t.certtestid=t.certtest.id and t.testerid=t.certuser.id and t.attemptid=:certattempid";
	
	public List<Certtestitem> findAll();
	@Query(GET_TEST_ITEMS)
	public List<Certtestitem> GetTestItemsByAttemptId(@Param("certattempid") Integer certattempid);
	
	
}
