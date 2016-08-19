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

import java.util.List;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ge.predix.certification.businessobject.CertattempBO;
import com.ge.predix.certification.businessobject.CerttestitemBO;
import com.ge.predix.certification.domain.Certattemp;
import com.ge.predix.certification.domain.Certtestitem;
import com.ge.predix.certification.domain.Model;
import com.ge.predix.certification.repositories.CertModelRepository;
import com.ge.predix.certification.repositories.CertTestItemRepository;
import com.ge.predix.certification.repositories.CertattempRepository;


/**
 * Utility class that converts the domain model used by the front end services
 * to the domain model used by the persistence layer.
 * 
 * 
 * @author Narasim
 */

@Service
public class CertificationService {


	@Autowired
	private CertModelRepository certModelRepository;
	@Autowired
	private CertattempRepository certattempRepository;
	@Autowired
	private CertTestItemRepository certTestItemRepository;

	
	public List<Model> getModelList(){
		
		//List<Model> coList = new ArrayList<Model>();
		//List<Model> list = certModelRepository.findById(1L);
		List<Model> list = certModelRepository.findAll();

		/*for (Model certModel : list) {
			coList.add(ModelBO.getInstance(certModel));
			System.out.println("attempts:"+certModel.getCertattemps()) ;
		}*/
		//Model model1 = certModelRepository.findOne(1L);
		//coList.add(model1);
	
		return list;
	}
	
	public List<CertattempBO> GetAttempListByModel(){
		List<CertattempBO> coList = new ArrayList<CertattempBO>();
		List<Certattemp> certList  = certattempRepository.GetAttempListByModel();
		for (Certattemp certattemp : certList) {
			coList.add(CertattempBO.getInstance(certattemp));
		}
	
		return coList;
	}
	
	public List<CerttestitemBO> GetCertTestItemsByAttemptId(Integer certattempid){
		List<CerttestitemBO> coList = new ArrayList<CerttestitemBO>();
		List<Certtestitem> certList  = certTestItemRepository.GetTestItemsByAttemptId(certattempid);
		for (Certtestitem certitem : certList) {
			coList.add(CerttestitemBO.getInstance(certitem));
		}
	
		return coList;
	}
	
	public List<Model> createNewModel(Model model){
	
		List<Model> coList = new ArrayList<Model>();
		//List<Model> list = certModelRepository.findById(1L);
		java.util.Date date= new java.util.Date();
		Timestamp ts_now = new Timestamp(date.getTime());
		
		model.setLaststatustime(ts_now);
		Model model1=  certModelRepository.save(model);
		coList.add(model1);

	
		return coList;
	}
	//@Transactional
	public Model getModelById(Integer id){
		
		Model modelDetails  = certModelRepository.findOne(id);
	
	
		return modelDetails;
	}
	
	public List<CertattempBO> GetAttemptsByModelId(Integer modelid){
		
	
		
		List<CertattempBO> coList = new ArrayList<CertattempBO>();
		List<Certattemp> certList  = certattempRepository.findByModelid(modelid);
	
		for (Certattemp certattemp : certList) {
			coList.add(CertattempBO.getInstance(certattemp));
			System.out.println("certattemp:::"+certattemp.toString());
		
		}
		return coList;
	
	}
	
}
