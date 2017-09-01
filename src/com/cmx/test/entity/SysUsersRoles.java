package com.cmx.test.entity;

import java.io.Serializable;

public class SysUsersRoles implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long user_id;
	private Long role_id;

	public void setRole_id(Long role_id){
		this.role_id = role_id;
	}
	public Long getRole_id(){
		return role_id;
	}

	public void setUser_id(Long user_id){
		this.user_id = user_id;
	}
	public Long getUser_id(){
		return user_id;
	}
	
	 @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUsersRoles userRole = (SysUsersRoles) o;

        if (role_id != null ? !role_id.equals(userRole.role_id) : userRole.role_id != null) return false;
        if (user_id != null ? !user_id.equals(userRole.user_id) : userRole.user_id != null) return false;

        return true;
    }

	    @Override
	    public int hashCode() {
	        int result = user_id != null ? user_id.hashCode() : 0;
	        result = 31 * result + (role_id != null ? role_id.hashCode() : 0);
	        return result;
	    }

	public String toString(){
		return "SysUsersRoles["
		+"role_id=" + role_id + ","
		+"user_id=" + user_id 
		+"]";
	}
}