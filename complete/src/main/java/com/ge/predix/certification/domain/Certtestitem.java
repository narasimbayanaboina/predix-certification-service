package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the certtestitem database table.
 * 
 */
@Entity
@Table(name="certtestitem" ,schema="cert1")
public class Certtestitem implements Serializable {
/*	@Override
	public String toString() {
		return "Certtestitem [id=" + id + ", notes=" + notes + ", status=" + status + ", statustime=" + statustime
				+ ", attemptid=" + attemptid + ", certtestid=" + certtestid + ", testerid=" + testerid + ", certattemp="
				+ certattemp + ", certtest=" + certtest + ", certuser=" + certuser + ", certtestitemactivities="
				+ certtestitemactivities + "]";
	}*/

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String notes;

	private String status;

	private Timestamp statustime;
	private Integer attemptid;
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

	private Integer testerid;

	public Integer getAttemptid() {
		return attemptid;
	}

	public void setAttemptid(Integer attemptid) {
		this.attemptid = attemptid;
	}

	//bi-directional many-to-one association to Certattemp
	@ManyToOne
	@JoinColumn(name="attemptid",insertable = false, updatable = false)
	private Certattemp certattemp;

	//bi-directional many-to-one association to Certtest
	@ManyToOne
	@JoinColumn(name="certtestid",insertable = false, updatable = false)
	private Certtest certtest;

	//bi-directional many-to-one association to Certuser
	@ManyToOne
	@JoinColumn(name="testerid",insertable = false, updatable = false)
	private Certuser certuser;

	//bi-directional many-to-one association to Certtestitemactivity
	@OneToMany(mappedBy="certtestitem",fetch = FetchType.LAZY)
	private List<Certtestitemactivity> certtestitemactivities;

	public Certtestitem() {
	}

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

	public Timestamp getStatustime() {
		return this.statustime;
	}

	public void setStatustime(Timestamp statustime) {
		this.statustime = statustime;
	}

	public Certattemp getCertattemp() {
		return this.certattemp;
	}

	public void setCertattemp(Certattemp certattemp) {
		this.certattemp = certattemp;
	}

	public Certtest getCerttest() {
		return this.certtest;
	}

	public void setCerttest(Certtest certtest) {
		this.certtest = certtest;
	}

	public Certuser getCertuser() {
		return this.certuser;
	}

	public void setCertuser(Certuser certuser) {
		this.certuser = certuser;
	}

	public List<Certtestitemactivity> getCerttestitemactivities() {
		return this.certtestitemactivities;
	}

	public void setCerttestitemactivities(List<Certtestitemactivity> certtestitemactivities) {
		this.certtestitemactivities = certtestitemactivities;
	}

	public Certtestitemactivity addCerttestitemactivity(Certtestitemactivity certtestitemactivity) {
		getCerttestitemactivities().add(certtestitemactivity);
		certtestitemactivity.setCerttestitem(this);

		return certtestitemactivity;
	}

	public Certtestitemactivity removeCerttestitemactivity(Certtestitemactivity certtestitemactivity) {
		getCerttestitemactivities().remove(certtestitemactivity);
		certtestitemactivity.setCerttestitem(null);

		return certtestitemactivity;
	}

}