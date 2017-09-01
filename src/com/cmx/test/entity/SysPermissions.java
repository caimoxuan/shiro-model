package com.cmx.test.entity;

import java.io.Serializable;

public class SysPermissions implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String permission;
	private String description;
	private Boolean available = false;
	
	
	public SysPermissions(){}
	
	public SysPermissions(String permission, String description, Boolean available){
		this.permission = permission;
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

	public void setPermission(String permission){
		this.permission = permission;
	}
	public String getPermission(){
		return permission;
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

        SysPermissions role = (SysPermissions) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
	
	

	public String toString(){
		return "SysPermissions["
		+"id=" + id + ","
		+"description=" + description + ","
		+"permission=" + permission + ","
		+"available=" + available 
		+"]";
	}
}