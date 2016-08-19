package com.ge.predix.certification.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the certuser database table.
 * 
 */
@Entity
@Table(name="certuser" ,schema="cert1")
public class Certuser implements Serializable {
	@Override
	public String toString() {
		return "Certuser [id=" + id + ", name=" + name + "]";
	}

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Certtestitem
	//@OneToMany(mappedBy="certuser",fetch = FetchType.LAZY)
	//private List<Certtestitem> certtestitems;

	//bi-directional many-to-one association to Userrole
	//@ManyToOne
	//@JoinColumn(name="roleid",insertable = false, updatable = false)
	//private Userrole userrole;

	public Certuser() {
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

/*	public List<Certtestitem> getCerttestitems() {
		return this.certtestitems;
	}

	public void setCerttestitems(List<Certtestitem> certtestitems) {
		this.certtestitems = certtestitems;
	}

	public Certtestitem addCerttestitem(Certtestitem certtestitem) {
		getCerttestitems().add(certtestitem);
		certtestitem.setCertuser(this);

		return certtestitem;
	}

	public Certtestitem removeCerttestitem(Certtestitem certtestitem) {
		getCerttestitems().remove(certtestitem);
		certtestitem.setCertuser(null);

		return certtestitem;
	}*/

/*	public Userrole getUserrole() {
		return this.userrole;
	}

	public void setUserrole(Userrole userrole) {
		this.userrole = userrole;
	}*/

}