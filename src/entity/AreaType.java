package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AreaType generated by MyEclipse Persistence Tools
 */

public class AreaType implements java.io.Serializable {

	// Fields

	private Integer gid;
	private String area;
	private Integer state;

	// Constructors

	/** default constructor */
	public AreaType() {
	}

	/** minimal constructor */
	public AreaType(String area, Integer state) {
		this.area = area;
		this.state = state;
	}

	/** full constructor */
	public AreaType(String area, Integer state, Set leaseRooms, Set begRents) {
		this.area = area;
		this.state = state;

	}

	// Property accessors

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


}