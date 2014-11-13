/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.action;

import java.nio.MappedByteBuffer;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import entity.HouseType;

import server.HouseTypeServer;
import server.impl.HouseTypeServerimpl;
import struts.form.HouseTypeForm;

/** 
 * MyEclipse Struts
 * Creation date: 06-22-2010
 * 
 * XDoclet definition:
 * @struts.action path="/houseType" name="houseTypeForm" input="/form/houseType.jsp" parameter="method" scope="request" validate="true"
 */
public class HouseTypeAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addHouse(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {    //添加
		HouseTypeForm houseTypeForm = (HouseTypeForm) form;
		
		String htype=houseTypeForm.getType();
		HouseType housType=new HouseType();
		
		housType.setType(htype);
		
		housType.setState(1);
		
		HouseTypeServer houseTypeServer=new HouseTypeServerimpl();
		
		houseTypeServer.insert(housType);
		
		return selectHouse_type(mapping, form, request, response);
	}
	
	
	public ActionForward deleteHouse_type(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {   //删除
		HouseTypeForm houseTypeForm = (HouseTypeForm) form;
		int id=Integer.parseInt(request.getParameter("id"));
        HouseTypeServer houseTypeServer=new HouseTypeServerimpl();
		
		houseTypeServer.delObj(id);
		
		return selectHouse_type(mapping, form, request, response);
		
	}
	
	
	
	public ActionForward selectHouse_type(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {   //查询
		HouseTypeForm houseTypeForm = (HouseTypeForm) form;
		
		HouseTypeServer  typeServer=new HouseTypeServerimpl();
		
		List<HouseType> hlist=typeServer.select();
		
		request.setAttribute("hlist", hlist);
		
		return mapping.findForward("show");
	}
}