package com.ge.predix.certification.businessobject;

import java.sql.Timestamp;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ge.predix.certification.domain.Certattemp;



@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown=true)


/**
 * The BO class for the certattemp.
 * 
 */

public class CertattempBO {


	@JsonProperty("id")
	private Integer id;
	@JsonProperty("description")
	private String description;
	@JsonProperty("modelid")
	private Integer modelid;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date setuptime;
	@JsonProperty("status")
	private String status;
	@JsonProperty("modelname")
	private String modelname;

	public String getModelname() {
		return modelname;
	}

	public void setModelname(String modelname) {
		this.modelname = modelname;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getModelid() {
		return this.modelid;
	}

	public void setModelid(Integer modelid) {
		this.modelid = modelid;
	}

	public Date getSetuptime() {
		return this.setuptime;
	}

	public void setSetuptime(Date setuptime) {
		this.setuptime = setuptime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static CertattempBO getInstance(Certattemp certSV){
		
		CertattempBO bo = new CertattempBO();
	   bo.setDescription(certSV.getDescription());
	   bo.setId(certSV.getId());
	   bo.setModelid(certSV.getModelid());
	   bo.setModelname(certSV.getModel().getModelname());
	 //System.out.println("getCerttestitems"+ certSV.getCerttestitems());
	  // System.out.println("getCerttestitems"+ certSV.get);
	   bo.setSetuptime(new Date(certSV.getSetuptime().getTime()));
	  // System.out.println("getSetuptime:"+bo.getSetuptime());
	   bo.setStatus(certSV.getStatus());
	   
		return bo;
	}

}