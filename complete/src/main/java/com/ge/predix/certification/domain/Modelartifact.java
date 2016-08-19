package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the modelartifact database table.
 * 
 */
@Entity
@Table(name="modelartifact" ,schema="cert1")
public class Modelartifact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private byte[] content;

	private Timestamp lastupdatedtime;

	private String name;

	private String type;

	//bi-directional many-to-one association to Model
	@ManyToOne
	@JoinColumn(name="candidateid")
	private Model model;

	public Modelartifact() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public byte[] getContent() {
		return this.content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Timestamp getLastupdatedtime() {
		return this.lastupdatedtime;
	}

	public void setLastupdatedtime(Timestamp lastupdatedtime) {
		this.lastupdatedtime = lastupdatedtime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}