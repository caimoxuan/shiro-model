package com.cmx.test.entity;

import java.io.Serializable;

public class SysRolesPermissions implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long role_id;
	private Long permission_id;

	public void setPermission_id(Long permissionId){
		this.permission_id = permissionId;
	}
	public Long getPermission_id(){
		return permission_id;
	}

	public void setRole_id(Long role_id){
		this.role_id = role_id;
	}
	public Long getRole_id(){
		return role_id;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysRolesPermissions that = (SysRolesPermissions) o;

        if (permission_id != null ? !permission_id.equals(that.permission_id) : that.permission_id != null) return false;
        if (role_id != null ? !role_id.equals(that.role_id) : that.role_id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = role_id != null ? role_id.hashCode() : 0;
        result = 31 * result + (permission_id != null ? permission_id.hashCode() : 0);
        return result;
    }

	public String toString(){
		return "SysRolesPermissions["
		+"permission_id=" + permission_id + ","
		+"role_id=" + role_id 
		+"]";
	}
}