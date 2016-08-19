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
import org.springframework.data.repository.query.Param;

import com.ge.predix.certification.domain.Certtestitem;
import com.ge.predix.certification.domain.Model;

/**
 * 
 * @author Narasim
 */
public interface CertModelRepository extends JpaRepository<Model, Integer> {
	
	public static final String GET_TOP_20 = "select a from Model a ,Certattemp b where a.id=b.modelid ";

	//public Model findOne(Integer id);
}
