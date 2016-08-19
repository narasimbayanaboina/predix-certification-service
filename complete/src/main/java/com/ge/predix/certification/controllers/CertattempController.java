/*
 * Copyright (c) 2016 General Electric Company. All rights reserved.
 *
 * The copyright to the computer software herein is the property of
 * General Electric Company. The software may be used and/or copied only
 * with the written permission of General Electric Company or in accordance
 * with the terms and conditions stipulated in the agreement/contract
 * under which the software has been supplied.
 */

/**
 * @author Narasim Bayanaboina
 */

package com.ge.predix.certification.controllers;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ge.predix.certification.businessobject.CertattempBO;
import com.ge.predix.certification.businessobject.CerttestitemBO;
import com.ge.predix.certification.domain.Certattemp;
import com.ge.predix.certification.domain.Model;
import com.ge.predix.certification.service.CertificationService;



@SuppressWarnings("javadoc")
@RestController
@Component
public class CertattempController {

	
	@Autowired
	private CertificationService certificationService;


	
/*@GET
	@RequestMapping(value = "/certattemps", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<CertattempBO>> getAttempList() throws IOException {
	
		List<CertattempBO> list =certificationService.GetAttempListByModel();

		return new ResponseEntity<List<CertattempBO>>(list, HttpStatus.OK);
	}*/
	

	
	@GET
	@RequestMapping(value = "/certattemps", method = RequestMethod.GET)
	//@Path("/certmodel/{id}")
	public @ResponseBody ResponseEntity<List<CertattempBO>> GetAttemptsByModelId(@QueryParam("modelid") Integer modelid) throws IOException {
		//List<CostSVBO> coList = new ArrayList<CostSVBO>();
		List<CertattempBO> certList=null;
	
		 certList  = certificationService.GetAttemptsByModelId(modelid);
	
	  
		return new ResponseEntity<List<CertattempBO>>(certList, HttpStatus.OK);
	}
	

}