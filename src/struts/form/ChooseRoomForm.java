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
 * MyEclipse Struts Creation date: 06-24-2010
 * 
 * XDoclet definition:
 * 
 * @struts.form name="chooseRoomForm"
 */
public class ChooseRoomForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** id property */
	private Integer id;

	private Integer showPage;

	private Integer allPage;

	private Integer allCount;

	public Integer getShowPage() {
		return showPage;
	}

	public void setShowPage(Integer showPage) {
		this.showPage = showPage;
	}

	public Integer getAllPage() {
		return allPage;
	}

	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}

	public Integer getAllCount() {
		return allCount;
	}

	public void setAllCount(Integer allCount) {
		this.allCount = allCount;
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

	/**
	 * Returns the id.
	 * 
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the id.
	 * 
	 * @param id
	 *            The id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
}