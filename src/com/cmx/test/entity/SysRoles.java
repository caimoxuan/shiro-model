package com.cmx.test.entity;

import java.io.Serializable;

public class SysRoles implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String role;
	private String description;
	private Boolean available;

	public SysRoles(){}
	
	public SysRoles(String role, String description, Boolean available){
		this.role = role;
		this.description = description;
		this.available = available;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return id;
	}

	public void setDescription(String description){
		this.description = description;
	}
	public String getDescription(){
		return description;
	}

	public void setRole(String role){
		this.role = role;
	}
	public String getRole(){
		return role;
	}

	public void setAvailable(Boolean available){
		this.available = available;
	}
	public Boolean getAvailable(){
		return available;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRoles role = (SysRoles) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

	public String toString(){
		return "SysRoles["
		+"id=" + id + ","
		+"description=" + description + ","
		+"role=" + role + ","
		+"available=" + available 
		+"]";
	}
}