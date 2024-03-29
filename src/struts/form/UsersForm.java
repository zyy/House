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
 * MyEclipse Struts Creation date: 06-23-2010
 * 
 * XDoclet definition:
 * 
 * @struts.form name="usersForm"
 */
public class UsersForm extends ActionForm {
	/*
	 * Generated fields
	 */

	/** phone property */
	private String phone;

	/** uid property */
	private Integer uid;

	/** state property */
	private Integer state;

	/** email property */
	private String email;

	/** upwd property */
	private String upwd;

	/** uname property */
	private String uname;

	private String fromto;
	
	
	private int showPage;

	public int getShowPage() {
		return showPage;
	}

	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}

	public String getFromto() {
		return fromto;
	}

	public void setFromto(String fromto) {
		this.fromto = fromto;
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
	 * Returns the phone.
	 * 
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Set the phone.
	 * 
	 * @param phone
	 *            The phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Returns the uid.
	 * 
	 * @return Integer
	 */
	public Integer getUid() {
		return uid;
	}

	/**
	 * Set the uid.
	 * 
	 * @param uid
	 *            The uid to set
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}

	/**
	 * Returns the state.
	 * 
	 * @return Integer
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * Set the state.
	 * 
	 * @param state
	 *            The state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * Returns the email.
	 * 
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set the email.
	 * 
	 * @param email
	 *            The email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Returns the upwd.
	 * 
	 * @return String
	 */
	public String getUpwd() {
		return upwd;
	}

	/**
	 * Set the upwd.
	 * 
	 * @param upwd
	 *            The upwd to set
	 */
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	/**
	 * Returns the uname.
	 * 
	 * @return String
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * Set the uname.
	 * 
	 * @param uname
	 *            The uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
}