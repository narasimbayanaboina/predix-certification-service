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
import org.springframework.web.bind.annotation.PathVariable;
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
public class ModelController {

	
	@Autowired
	private CertificationService certificationService;


	@GET
	@RequestMapping(value = "/certmodels", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<Model>> getModelList() throws IOException {
		//List<CostSVBO> coList = new ArrayList<CostSVBO>();
		List<Model> coList  = certificationService.getModelList();
//		list = totalCostDataRepository.getTop20LocomotiveTotalCost();
		//for (Model certModel : list) {
		//	coList.add(CostSVBO.getInstance(certModel));
		//}
		return new ResponseEntity<List<Model>>(coList, HttpStatus.OK);
	}
	
	
	@GET
	@RequestMapping(value = "/certtestitems", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<List<CerttestitemBO>> GetCertTestItemsByAttemptId(@RequestParam("certattempid") Integer certattempid) throws IOException {
	
		List<CerttestitemBO> list =certificationService.GetCertTestItemsByAttemptId(certattempid);

		return new ResponseEntity<List<CerttestitemBO>>(list, HttpStatus.OK);
	}
	
	@POST
	@RequestMapping(value = "/certmodels", method = RequestMethod.POST)
	@Consumes("application/json")
	public @ResponseBody ResponseEntity<List<Model>> createNewModel(@RequestBody Model model) throws IOException {
		//List<CostSVBO> coList = new ArrayList<CostSVBO>();
		
		List<Model> coList  = certificationService.createNewModel(model);
//		list = totalCostDataRepository.getTop20LocomotiveTotalCost();
		//for (Model certModel : list) {
		//	coList.add(CostSVBO.getInstance(certModel));
		//}
		return new ResponseEntity<List<Model>>(coList, HttpStatus.CREATED);
	}
	
	@GET
	@RequestMapping(value = "/certmodel/{id}", method = RequestMethod.GET)
	//@Path("/certmodel/{id}")
	public @ResponseBody ResponseEntity<Model> getModelById(@PathVariable("id") Integer id) throws IOException {
		//List<CostSVBO> coList = new ArrayList<CostSVBO>();
		System.out.println("Id:::"+id);
	
		Model coList  = certificationService.getModelById(id);

		return new ResponseEntity<Model>(coList, HttpStatus.OK);
	}
	



	

}