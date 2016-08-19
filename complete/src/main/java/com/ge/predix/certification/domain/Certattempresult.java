package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the certattempresult database table.
 * 
 */
@Entity
@Table(name="certattempresult" ,schema="cert1")
public class Certattempresult implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String itemtype;

	private String notes;

	//bi-directional many-to-one association to Certattemp
	@ManyToOne
	@JoinColumn(name="attemptid")
	private Certattemp certattemp;

	public Certattempresult() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Certattemp getCertattemp() {
		return this.certattemp;
	}

	public void setCertattemp(Certattemp certattemp) {
		this.certattemp = certattemp;
	}

}