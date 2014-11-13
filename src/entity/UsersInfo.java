package entity;

/**
 * UsersInfo generated by MyEclipse Persistence Tools
 */

public class UsersInfo implements java.io.Serializable {

	// Fields

	private Integer uid;
	private Users users;
	private String truename;
	private String sex;
	private String address;
	private String image;
	private String remark;

	// Constructors

	/** default constructor */
	public UsersInfo() {
	}

	/** minimal constructor */
	public UsersInfo(Users users) {
		this.users = users;
	}

	/** full constructor */
	public UsersInfo(Users users, String truename, String sex, String address,
			String image, String remark) {
		this.users = users;
		this.truename = truename;
		this.sex = sex;
		this.address = address;
		this.image = image;
		this.remark = remark;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getTruename() {
		return this.truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}