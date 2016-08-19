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



import org.springframework.data.jpa.repository.JpaRepository;

import com.ge.predix.certification.domain.Certtest;


/**
 * 
 * @author Narasim
 */
public interface CerttestRepository extends JpaRepository<Certtest, Integer> {
	
	public static final String GET_TOP_20 = "select a from Model a ,Certattemp b where a.id=b.modelid ";

	
}
