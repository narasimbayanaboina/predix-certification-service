package com.ge.predix.certification.businessobject;

import java.sql.Timestamp;
import java.util.Date;

//import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonFormat;
//import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonProperty;
//import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ge.predix.certification.domain.Certtestitem;



@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)


/**
 * The BO class for the certattemp.
 * 
 */
public class CerttestitemBO {


	@JsonProperty("id")
	private Integer id;
	@JsonProperty("notes")
	private String notes;
	@JsonProperty("status")
	private String status;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date statustime;
	@JsonProperty("stepid")
	private Integer stepid;
	private String TesterName;
	public String getTesterName() {
		return TesterName;
	}

	public void setTesterName(String testerName) {
		TesterName = testerName;
	}

	public String getTestItemName() {
		return TestItemName;
	}

	public void setTestItemName(String testItemName) {
		TestItemName = testItemName;
	}
	private String TestItemName;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getStatustime() {
		return this.statustime;
	}

	public void setStatustime(Date date) {
		this.statustime = date;
	}

	public Integer getStepid() {
		return this.stepid;
	}

	public void setStepid(Integer stepid) {
		this.stepid = stepid;
	}
	@JsonProperty("certtestid")
	private Integer certtestid;
	public Integer getCerttestid() {
		return certtestid;
	}

	public void setCerttestid(Integer certtestid) {
		this.certtestid = certtestid;
	}

	public Integer getTesterid() {
		return testerid;
	}

	public void setTesterid(Integer testerid) {
		this.testerid = testerid;
	}
	@JsonProperty("testerid")
	private Integer testerid;

	public static CerttestitemBO getInstance(Certtestitem certSV){
		
		CerttestitemBO bo = new CerttestitemBO();
	   bo.setNotes(certSV.getNotes());
	   bo.setId(certSV.getId());
	   bo.setStepid(certSV.getAttemptid());
	
	   bo.setStatustime(new Date(certSV.getStatustime().getTime()));
	   bo.setCerttestid(certSV.getCerttestid());
	   bo.setTesterid(certSV.getTesterid());
	   bo.setTesterName(certSV.getCertuser().getName());
	   bo.setTestItemName(certSV.getCerttest().getTestname());

	   bo.setStatus(certSV.getStatus());
	   
		return bo;
	}



}