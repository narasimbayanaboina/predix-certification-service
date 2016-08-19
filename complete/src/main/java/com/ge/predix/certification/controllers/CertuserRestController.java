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

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ge.predix.certification.domain.Certuser;
import com.ge.predix.certification.service.CertificationUserService;



@SuppressWarnings("javadoc")
@RestController
@Component
public class CertuserRestController {

	
	@Autowired
	private CertificationUserService certificationUserService;


	@GET
	@RequestMapping(value = "/certusers", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Certuser>> getCertUserList() throws IOException {

		List<Certuser> coList  = certificationUserService.getUserList();

		return new ResponseEntity<List<Certuser>>(coList, HttpStatus.OK);
	}
	

	

}