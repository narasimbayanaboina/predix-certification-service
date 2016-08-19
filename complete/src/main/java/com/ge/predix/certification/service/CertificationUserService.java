/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

package com.ge.predix.certification.service;
/**
 * @author Narasim Bayanaboina
 */
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.predix.certification.businessobject.CertattempBO;
import com.ge.predix.certification.businessobject.CerttestitemBO;
import com.ge.predix.certification.domain.Certattemp;
import com.ge.predix.certification.domain.Certtestitem;
import com.ge.predix.certification.domain.Certuser;
import com.ge.predix.certification.domain.Model;
import com.ge.predix.certification.repositories.CertModelRepository;
import com.ge.predix.certification.repositories.CertTestItemRepository;
import com.ge.predix.certification.repositories.CertattempRepository;
import com.ge.predix.certification.repositories.CertuserRepository;


/**
 * Utility class that converts the domain model used by the front end services
 * to the domain model used by the persistence layer.
 * 
 * 
 * @author Narasim Bayanaboina
 */

@Service
public class CertificationUserService {


	@Autowired
	private CertuserRepository certuserRepository;


	
	public List<Certuser> getUserList(){
		
	
		List<Certuser> list = certuserRepository.findAll();

		return list;
	}
	
	


}
