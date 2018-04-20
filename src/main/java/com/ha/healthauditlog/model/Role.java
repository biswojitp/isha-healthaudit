package com.ha.healthauditlog.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "t_role")
public class Role implements Serializable{

	 private static final long serialVersionUID = -4566589574587336038L;	
	
     private Long id;
     private String name; 
     private String description;
     private boolean blocked;
	 private Set<User> users;
	 private String display_name; 
	 private Integer role_level;
	 private String display_on_page;
	 
	 private boolean employee;
	 private boolean designation;
	 private Integer designation_level;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	@ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public Integer getRole_level() {
		return role_level;
	}

	public void setRole_level(Integer role_level) {
		this.role_level = role_level;
	}

	public String getDisplay_on_page() {
		return display_on_page;
	}

	public void setDisplay_on_page(String display_on_page) {
		this.display_on_page = display_on_page;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	@Column(name="is_designation")
	public boolean isDesignation() {
		return designation;
	}

	public void setDesignation(boolean designation) {
		this.designation = designation;
	}

	@Column(name="is_employee")
	public boolean isEmployee() {
		return employee;
	}

	public void setEmployee(boolean employee) {
		this.employee = employee;
	}

	
	
	@Column(name="designation_level")
	public Integer getDesignation_level() {
		return designation_level;
	}

	public void setDesignation_level(Integer designation_level) {
		this.designation_level = designation_level;
	}

	 
	
}
