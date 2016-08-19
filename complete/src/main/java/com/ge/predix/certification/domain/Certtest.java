package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the certtest database table.
 * 
 */
@Entity
@Table(name="certtest" ,schema="cert1")
public class Certtest implements Serializable {
	@Override
	public String toString() {
		return "Certtest [id=" + id + ", description=" + description + ", testname=" + testname + ", certtestitems="
				+ certtestitems + ", certteststeps=" + certteststeps + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String description;

	private String testname;

	//bi-directional many-to-one association to Certtestitem
	@OneToMany(mappedBy="certtest",fetch = FetchType.LAZY)
	private List<Certtestitem> certtestitems;

	//bi-directional many-to-one association to Certteststep
	@OneToMany(mappedBy="certtest",fetch = FetchType.LAZY)
	private List<Certteststep> certteststeps;

	public Certtest() {
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

	public String getTestname() {
		return this.testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public List<Certtestitem> getCerttestitems() {
		return this.certtestitems;
	}

	public void setCerttestitems(List<Certtestitem> certtestitems) {
		this.certtestitems = certtestitems;
	}

	public Certtestitem addCerttestitem(Certtestitem certtestitem) {
		getCerttestitems().add(certtestitem);
		certtestitem.setCerttest(this);

		return certtestitem;
	}

	public Certtestitem removeCerttestitem(Certtestitem certtestitem) {
		getCerttestitems().remove(certtestitem);
		certtestitem.setCerttest(null);

		return certtestitem;
	}

	public List<Certteststep> getCertteststeps() {
		return this.certteststeps;
	}

	public void setCertteststeps(List<Certteststep> certteststeps) {
		this.certteststeps = certteststeps;
	}

	public Certteststep addCertteststep(Certteststep certteststep) {
		getCertteststeps().add(certteststep);
		certteststep.setCerttest(this);

		return certteststep;
	}

	public Certteststep removeCertteststep(Certteststep certteststep) {
		getCertteststeps().remove(certteststep);
		certteststep.setCerttest(null);

		return certteststep;
	}

}