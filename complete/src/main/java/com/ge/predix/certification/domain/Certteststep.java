package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the certteststep database table.
 * 
 */
@Entity
@Table(name="certteststep" ,schema="cert1")
public class Certteststep implements Serializable {
/*	@Override
	public String toString() {
		return "Certteststep [id=" + id + ", category=" + category + ", stepdesc=" + stepdesc + ", stepname=" + stepname
				+ ", certtestitemactivities=" + certtestitemactivities + ", certtest=" + certtest + "]";
	}*/

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String category;

	private String stepdesc;

	private String stepname;

	//bi-directional many-to-one association to Certtestitemactivity
	@OneToMany(mappedBy="certteststep",fetch = FetchType.LAZY)
	private List<Certtestitemactivity> certtestitemactivities;

	//bi-directional many-to-one association to Certtest
	@ManyToOne
	@JoinColumn(name="certtestid")
	private Certtest certtest;

	public Certteststep() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getStepdesc() {
		return this.stepdesc;
	}

	public void setStepdesc(String stepdesc) {
		this.stepdesc = stepdesc;
	}

	public String getStepname() {
		return this.stepname;
	}

	public void setStepname(String stepname) {
		this.stepname = stepname;
	}

	public List<Certtestitemactivity> getCerttestitemactivities() {
		return this.certtestitemactivities;
	}

	public void setCerttestitemactivities(List<Certtestitemactivity> certtestitemactivities) {
		this.certtestitemactivities = certtestitemactivities;
	}

	public Certtestitemactivity addCerttestitemactivity(Certtestitemactivity certtestitemactivity) {
		getCerttestitemactivities().add(certtestitemactivity);
		certtestitemactivity.setCertteststep(this);

		return certtestitemactivity;
	}

	public Certtestitemactivity removeCerttestitemactivity(Certtestitemactivity certtestitemactivity) {
		getCerttestitemactivities().remove(certtestitemactivity);
		certtestitemactivity.setCertteststep(null);

		return certtestitemactivity;
	}

	public Certtest getCerttest() {
		return this.certtest;
	}

	public void setCerttest(Certtest certtest) {
		this.certtest = certtest;
	}

}