package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the userrole database table.
 * 
 */
@Entity
@Table(name="userrole" ,schema="cert1")
public class Userrole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Certuser
	//@OneToMany(mappedBy="userrole",fetch = FetchType.LAZY)
	//private List<Certuser> certusers;

	public Userrole() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*	public List<Certuser> getCertusers() {
		return this.certusers;
	}

	public void setCertusers(List<Certuser> certusers) {
		this.certusers = certusers;
	}

	public Certuser addCertuser(Certuser certuser) {
		getCertusers().add(certuser);
		certuser.setUserrole(this);

		return certuser;
	}

	public Certuser removeCertuser(Certuser certuser) {
		getCertusers().remove(certuser);
		certuser.setUserrole(null);

		return certuser;
	}*/

}