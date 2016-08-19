package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the certtestitemactivity database table.
 * 
 */
@Entity
@Table(name="certtestitemactivity" ,schema="cert1")
public class Certtestitemactivity implements Serializable {
	@Override
	public String toString() {
		return "Certtestitemactivity [id=" + id + ", notes=" + notes + ", status=" + status + ", statustime="
				+ statustime + ", certtestitem=" + certtestitem + ", certteststep=" + certteststep + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String notes;

	private String status;

	private Timestamp statustime;

	//bi-directional many-to-one association to Certtestitem
	@ManyToOne
	@JoinColumn(name="testitemid",insertable = false, updatable = false)
	private Certtestitem certtestitem;

	//bi-directional many-to-one association to Certteststep
	@ManyToOne
	@JoinColumn(name="certteststepid",insertable = false, updatable = false)
	private Certteststep certteststep;

	public Certtestitemactivity() {
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

	public Certtestitem getCerttestitem() {
		return this.certtestitem;
	}

	public void setCerttestitem(Certtestitem certtestitem) {
		this.certtestitem = certtestitem;
	}

	public Certteststep getCertteststep() {
		return this.certteststep;
	}

	public void setCertteststep(Certteststep certteststep) {
		this.certteststep = certteststep;
	}

}