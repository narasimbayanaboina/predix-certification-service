package com.ge.predix.certification.domain;


import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the certattemp database table.
 * 
 */
@Entity
@Table(name="certattemp" ,schema="cert1")
public class Certattemp implements Serializable {
	@Override
	public String toString() {
		return "Certattemp [id=" + id + ", description=" + description + ", notes=" + notes + ", setuptime=" + setuptime
				+ ", status=" + status + ", model=" + model + ", certattempresults=" + ""
				+ ", certtestitems=" + "" + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String description;

	private String notes;

	private Timestamp setuptime;

	private String status;

	//bi-directional many-to-one association to Model
	@ManyToOne
	@JoinColumn(name="modelid")
	private Model model;
	@Column(name = "modelid",insertable = false, updatable = false)
	private int modelid;

	//bi-directional many-to-one association to Model

	public int getModelid() {
		return modelid;
	}

	public void setModelid(int modelid) {
		this.modelid = modelid;
	}
	

	//bi-directional many-to-one association to Certattempresult
	@OneToMany(mappedBy="certattemp",fetch = FetchType.LAZY)
	private List<Certattempresult> certattempresults;

	//bi-directional many-to-one association to Certtestitem
	@OneToMany(mappedBy="certattemp",fetch = FetchType.LAZY)
	private List<Certtestitem> certtestitems;

	public Certattemp() {
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

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Timestamp getSetuptime() {
		return this.setuptime;
	}

	public void setSetuptime(Timestamp setuptime) {
		this.setuptime = setuptime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Model getModel() {
		return this.model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public List<Certattempresult> getCertattempresults() {
		return this.certattempresults;
	}

	public void setCertattempresults(List<Certattempresult> certattempresults) {
		this.certattempresults = certattempresults;
	}

	public Certattempresult addCertattempresult(Certattempresult certattempresult) {
		getCertattempresults().add(certattempresult);
		certattempresult.setCertattemp(this);

		return certattempresult;
	}

	public Certattempresult removeCertattempresult(Certattempresult certattempresult) {
		getCertattempresults().remove(certattempresult);
		certattempresult.setCertattemp(null);

		return certattempresult;
	}

	public List<Certtestitem> getCerttestitems() {
		return this.certtestitems;
	}

	public void setCerttestitems(List<Certtestitem> certtestitems) {
		this.certtestitems = certtestitems;
	}

	public Certtestitem addCerttestitem(Certtestitem certtestitem) {
		getCerttestitems().add(certtestitem);
		certtestitem.setCertattemp(this);

		return certtestitem;
	}

	public Certtestitem removeCerttestitem(Certtestitem certtestitem) {
		getCerttestitems().remove(certtestitem);
		certtestitem.setCertattemp(null);

		return certtestitem;
	}

}