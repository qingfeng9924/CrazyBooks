package com.crazybooks.etity;

import java.util.HashSet;
import java.util.Set;

/**
 * Managers entity. @author MyEclipse Persistence Tools
 */

public class Managers implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private Set destroybookses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Managers() {
	}

	/** full constructor */
	public Managers(String name, String password, Set destroybookses) {
		this.name = name;
		this.password = password;
		this.destroybookses = destroybookses;
	}

	// Property accessors

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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getDestroybookses() {
		return this.destroybookses;
	}

	public void setDestroybookses(Set destroybookses) {
		this.destroybookses = destroybookses;
	}

}