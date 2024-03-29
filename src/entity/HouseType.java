package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * HouseType generated by MyEclipse Persistence Tools
 */

public class HouseType implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private Integer state;

	// Constructors

	/** default constructor */
	public HouseType() {
	}

	/** minimal constructor */
	public HouseType(String type, Integer state) {
		this.type = type;
		this.state = state;
	}

	/** full constructor */
	public HouseType(String type, Integer state, Set leaseRooms, Set begRents) {
		this.type = type;
		this.state = state;

	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


}