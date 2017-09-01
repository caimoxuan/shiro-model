package com.cmx.test.entity;

import java.io.Serializable;

public class SysUsers implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String password;
	private String salt;
	private Boolean locked = false;
	
	public SysUsers(){}
	
	public SysUsers(String username, String password){
		this.username = username;
		this.password = password;
	}

	public void setId(Long id){
		this.id = id;
	}
	public Long getId(){
		return id;
	}

	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}

	public void setLocked(Boolean locked){
		this.locked = locked;
	}
	public Boolean getLocked(){
		return locked;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

	public void setSalt(String salt){
		this.salt = salt;
	}
	public String getSalt(){
		return salt;
	}
	
	public String getCredentialsSalt(){
		return username + salt;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysUsers user = (SysUsers) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

	public String toString(){
		return "SysUsers["
		+"id=" + id + ","
		+"username=" + username + ","
		+"locked=" + locked + ","
		+"password=" + password + ","
		+"salt=" + salt 
		+"]";
	}
}