package entity;

/**
 * Admin generated by MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer aid;
	private String aname;
	private String apwd;
	private Integer state;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String aname, String apwd, Integer state) {
		this.aname = aname;
		this.apwd = apwd;
		this.state = state;
	}

	// Property accessors

	public Integer getAid() {
		return this.aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAname() {
		return this.aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getApwd() {
		return this.apwd;
	}

	public void setApwd(String apwd) {
		this.apwd = apwd;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}