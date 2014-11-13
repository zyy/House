package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Users generated by MyEclipse Persistence Tools
 */

public class Users implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String uname;
	private String upwd;
	private String phone;
	private String email;
	private Integer state;
	private UsersInfo info;

	/** default constructor */
	public Users() {
	}

	/** minimal constructor */
	public Users(String uname, String upwd, String phone, String email,
			Integer state) {
		this.uname = uname;
		this.upwd = upwd;
		this.phone = phone;
		this.email = email;
		this.state = state;
	}



	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	public UsersInfo getInfo() {
		return info;
	}

	public void setInfo(UsersInfo info) {
		this.info = info;
	}

}