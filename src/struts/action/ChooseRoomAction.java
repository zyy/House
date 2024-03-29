/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import bean.PublicBean;


import entity.Users;

import server.ChooseroomServer;
import server.impl.ChooseroomServerImpl;
import struts.form.ChooseRoomForm;

/**
 * MyEclipse Struts Creation date: 06-24-2010
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/chooseRoom" name="chooseRoomForm"
 *                input="/form/chooseRoom.jsp" scope="request" validate="true"
 */
public class ChooseRoomAction extends DispatchAction {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward addchooseroom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ChooseRoomForm chooseRoomForm = (ChooseRoomForm) form;// TODO
		// Auto-generated
		// method stub

		return null;
	}

	public ActionForward delchooseroom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ChooseRoomForm chooseRoomForm = (ChooseRoomForm) form;

		int id = Integer.parseInt(request.getParameter("id"));

		ChooseroomServer chooseroomServer = new ChooseroomServerImpl();

		//chooseroomServer.deletechooseroom(id);

		PrintWriter out = response.getWriter();

		boolean falg = false;

		falg = chooseroomServer.deletechooseroom(id);

		if (falg = true) {

			out.print("<script>");
			out.print("alert('鍒犻櫎鎴愬姛!!!');");
			out.print("window.location='chooseroom.jsp';");

			out.print("</script>");
			return null;
		} else {

			out.print("<script>");
			out.print("alert('鍒犻櫎澶辫触!!!');");
			out.print("window.location='chooseroom.jsp';");
			out.print("</script>");
			return null;
		}

	}

	// 鍒嗛〉鏌ヨ
	public ActionForward showChooseroom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		ChooseRoomForm chooseRoomForm = (ChooseRoomForm) form;
		ChooseroomServer server = new ChooseroomServerImpl();
		int showPage = chooseRoomForm.getShowPage(); // 鑾峰緱褰撳墠鎵�瑕佹樉绀虹殑椤电爜
        
		Users users=(Users)request.getSession().getAttribute("users");
		
		PublicBean bean=server.getByPage(showPage,users.getUid());   //鑾峰緱鎵�瑕佹樉绀虹殑鏁版嵁闆嗗悎
		chooseRoomForm.setAllCount(bean.getAllCount());
		chooseRoomForm.setAllPage(bean.getAllPage());
		chooseRoomForm.setShowPage(bean.getShowPage());
		request.setAttribute("crlist", bean.getList());
		request.setAttribute("islist", "islist");
		return mapping.findForward("show");

	}
}