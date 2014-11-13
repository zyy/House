/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 * MyEclipse Struts Creation date: 06-24-2010
 * 
 * XDoclet definition:
 * 
 * @struts.form name="leaseRoomForm"
 */
public class LeaseRoomForm extends ActionForm {

	private Integer id;

	private Integer areaId;

	private Integer htypeId;

	private String address;

	private String title;

	private Integer hall;

	private Integer toilet;

	private Float acreage;
	// -----------------------------
	private Float pirce;

	private Integer chamber; // 户型(几室)

	private String areaName; // 区域名

	private Float startPrice; // 开始单价

	private Float endPrice; // 结束单价

	private String houseType; // 房源类别

	private String orderBy; // 排序方式

	// ------------------------------
	private String[] esthments;

	private String remark;

	private FormFile file[] = new FormFile[5];

	private String telePhone;

	private String email;

	private int showPage;

	private String time;

	private String fromto;

	public String getFromto() {
		return fromto;
	}

	public void setFromto(String fromto) {
		this.fromto = fromto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getHtypeId() {
		return htypeId;
	}

	public void setHtypeId(Integer htypeId) {
		this.htypeId = htypeId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getHall() {
		return hall;
	}

	public void setHall(Integer hall) {
		this.hall = hall;
	}

	public Integer getToilet() {
		return toilet;
	}

	public void setToilet(Integer toilet) {
		this.toilet = toilet;
	}

	public Float getAcreage() {
		return acreage;
	}

	public void setAcreage(Float acreage) {
		this.acreage = acreage;
	}

	public Float getPirce() {
		return pirce;
	}

	public void setPirce(Float pirce) {
		this.pirce = pirce;
	}

	public Integer getChamber() {
		return chamber;
	}

	public void setChamber(Integer chamber) {
		this.chamber = chamber;
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

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String[] getEsthments() {
		return esthments;
	}

	public void setEsthments(String[] esthments) {
		this.esthments = esthments;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public FormFile[] getFile() {
		return file;
	}

	public void setFile(FormFile[] file) {
		this.file = file;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getShowPage() {
		return showPage;
	}

	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method reset
	 * 
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

}