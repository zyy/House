/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 06-21-2010
 * 
 * XDoclet definition:
 * @struts.form name="areaTypeForm"
 */
public class AreaTypeForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** gid property */
	private Integer gid;

	/** state property */
	private Integer state;

	/** area property */
	private String area;

	/*
	 * Generated Methods
	 */

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		// TODO Auto-generated method stub
	}

	/** 
	 * Returns the gid.
	 * @return Integer
	 */
	public Integer getGid() {
		return gid;
	}

	/** 
	 * Set the gid.
	 * @param gid The gid to set
	 */
	public void setGid(Integer gid) {
		this.gid = gid;
	}

	/** 
	 * Returns the state.
	 * @return Integer
	 */
	public Integer getState() {
		return state;
	}

	/** 
	 * Set the state.
	 * @param state The state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/** 
	 * Returns the area.
	 * @return String
	 */
	public String getArea() {
		return area;
	}

	/** 
	 * Set the area.
	 * @param area The area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}
}