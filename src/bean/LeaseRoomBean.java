/*
 * 出租房源的条件JavaBean
 */

package bean;

public class LeaseRoomBean {

	private String areaName; // 区域名

	private Float startPrice; // 开始单价

	private Float endPrice; // 结束单价

	private Integer chamber; // 户型(几室)

	private String houseType; // 房源类别

	private String time; // 时间

	private String orderBy; // 排序方式

	private int state; // 房源状态

	private int uid;// 用户id
	
	private String title;//房源标题

	private int id;

	private String islist;

	public String getIslist() {
		return islist;
	}

	public void setIslist(String islist) {
		this.islist = islist;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Float getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Float startPrice) {
		this.startPrice = startPrice;
	}

	public Float getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Float endPrice) {
		this.endPrice = endPrice;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Integer getChamber() {
		return chamber;
	}

	public void setChamber(Integer chamber) {
		this.chamber = chamber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
