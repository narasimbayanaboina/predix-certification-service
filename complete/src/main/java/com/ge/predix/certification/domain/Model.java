package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;

import org.springframework.cloud.cloudfoundry.com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the model database table.
 * 
 */
@Entity
@Table(name="model" ,schema="cert1")
public class Model implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	
	@Column(name="description")
	private String longDesc;
	//@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date laststatustime;
	@Column(name="name")
	private String modelName;

	private String status;

	//bi-directional many-to-one association to Certattemp
	@OneToMany(mappedBy="model",fetch = FetchType.LAZY)
	private List<Certattemp> certattemps;

	//bi-directional many-to-one association to Modelartifact
	@OneToMany(mappedBy="model",fetch = FetchType.LAZY)
	private List<Modelartifact> modelartifacts;
	
	@Column(name="external_Id")
	private String externalId;
	
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	@Temporal(TemporalType.DATE)
	private Date createdts;
	
	public Date getCreatedts() {
		return createdts;
	}

	public void setCreatedts(Date createdts) {
		this.createdts = createdts;
	}
	private String authorname;
	@Column(name="typeofmodel")
	private String typeOfModel;
	public String getTypeOfModel() {
		return typeOfModel;
	}

	public void setTypeOfModel(String typeOfModel) {
		this.typeOfModel = typeOfModel;
	}

	public String getUseOfModel() {
		return useOfModel;
	}

	public void setUseOfModel(String useOfModel) {
		this.useOfModel = useOfModel;
	}
	@Column(name="useofmodel")
	private String useOfModel;

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPartnername() {
		return partnername;
	}

	public void setPartnername(String partnername) {
		this.partnername = partnername;
	}

	public String getProgramminglanguage() {
		return programminglanguage;
	}

	public void setProgramminglanguage(String programminglanguage) {
		this.programminglanguage = programminglanguage;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortdesc) {
		this.shortDesc = shortdesc;
	}

	private String email;

	private String partnername;

	private String programminglanguage;

	private String reason;

	
	@Column(name="shortdesc")
	private String shortDesc;


	public Model() {
	}

	@Override
	public String toString() {
		return "Model [id=" + id + ", description=" + longDesc + ", laststatustime=" + laststatustime + ", name="
				+ modelName + ", status=" + status + ", certattemps=" + "" + ", modelartifacts=" + ""
				+ "]";
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLongDesc() {
		return this.longDesc;
	}

	public void setLongDesc(String description) {
		this.longDesc = description;
	}

	public Date getLaststatustime() {
		return this.laststatustime;
	}

	public void setLaststatustime(Date laststatustime) {
		this.laststatustime = laststatustime;
	}

	public String getModelname() {
		return this.modelName;
	}

	public void setModelname(String name) {
		this.modelName = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

/*	public List<Certattemp> getCertattemps() {
		return this.certattemps;
	}

	public void setCertattemps(List<Certattemp> certattemps) {
		this.certattemps = certattemps;
	}

	public Certattemp addCertattemp(Certattemp certattemp) {
		getCertattemps().add(certattemp);
		certattemp.setModel(this);

		return certattemp;
	}

	public Certattemp removeCertattemp(Certattemp certattemp) {
		getCertattemps().remove(certattemp);
		certattemp.setModel(null);

		return certattemp;
	}

	public List<Modelartifact> getModelartifacts() {
		return this.modelartifacts;
	}

	public void setModelartifacts(List<Modelartifact> modelartifacts) {
		this.modelartifacts = modelartifacts;
	}

	public Modelartifact addModelartifact(Modelartifact modelartifact) {
		getModelartifacts().add(modelartifact);
		modelartifact.setModel(this);

		return modelartifact;
	}

	public Modelartifact removeModelartifact(Modelartifact modelartifact) {
		getModelartifacts().remove(modelartifact);
		modelartifact.setModel(null);

		return modelartifact;
	}
*/
}