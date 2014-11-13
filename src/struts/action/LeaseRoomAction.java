/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package struts.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

import server.AreaTypeServer;
import server.HouseTypeServer;
import server.ImageTableServer;
import server.LeaseRoomServer;
import server.UserServer;
import server.impl.AreaTypeServerImpl;
import server.impl.HouseTypeServerimpl;
import server.impl.ImageTableServerImpl;
import server.impl.LeaseRoomServerImpl;
import server.impl.UserServerImpl;
import struts.form.LeaseRoomForm;
import bean.LeaseRoomBean;
import bean.PublicBean;
import entity.AreaType;
import entity.HouseType;
import entity.ImageTable;
import entity.LeaseRoom;
import entity.Users;

/**
 * MyEclipse Struts Creation date: 06-24-2010
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/leaseRoom" name="leaseRoomForm" parameter="method"
 *                scope="request"
 */
public class LeaseRoomAction extends DispatchAction {
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

	public void sel(HttpServletRequest request, HttpServletResponse response) {
		AreaTypeServer server = new AreaTypeServerImpl();
		HouseTypeServer hserver = new HouseTypeServerimpl();

		List<HouseType> hlist = hserver.select(); // 房源类别
		List<AreaType> alist = server.selArea(); // 房源区域

		request.setAttribute("hlist", hlist);
		request.setAttribute("alist", alist);

	}

	// 审核房源
	public ActionForward toExamine(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		LeaseRoomForm leaseRoomForm = (LeaseRoomForm) form;

		int id = Integer.parseInt(request.getParameter("id"));
		LeaseRoomServer roomServer = new LeaseRoomServerImpl();
		LeaseRoom leaseRoom = roomServer.getRoom(id);
		leaseRoom.setState(3);

		if (roomServer.update(leaseRoom)) {
			response.getWriter().print("<script>");
			response.getWriter().print("alert('审核通过！');");
			response
					.getWriter()
					.print(
							"window.location='leaseRoom.do?method=showRoomAdmin&showPage=1';");
			response.getWriter().print("</script>");
		} else {
			response.getWriter().print("<script>");
			response.getWriter().print("alert('审核失败！');");
			response
					.getWriter()
					.print(
							"window.location='leaseRoom.do?method=showRoomAdmin&showPage=1';");
			response.getWriter().print("</script>");

		}

		return null;
	}

	public ActionForward selArea(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		LeaseRoomForm leaseRoomForm = (LeaseRoomForm) form;
		sel(request, response);
		return mapping.findForward("ok");
	}

	// 添加
	public ActionForward addLease(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException,
			FileNotFoundException, IOException {
		LeaseRoomForm leaseform = (LeaseRoomForm) form;

		LeaseRoomServer lserver = new LeaseRoomServerImpl();
		AreaTypeServer aserver = new AreaTypeServerImpl();
		HouseTypeServer hserver = new HouseTypeServerimpl();
		UserServer userver = new UserServerImpl();

		LeaseRoom room = new LeaseRoom();
		BeanUtils.copyProperties(room, leaseform); // 复制javaBean 属性

		if (leaseform.getEsthments() != null) {// 房源基础设施
			String esthment = "";
			for (String ment : leaseform.getEsthments()) {
				esthment += ment + ",";
			}
			esthment = esthment.substring(0, esthment.length() - 1);
			room.setEsthment(esthment);
		}
		Users users = (Users) request.getSession().getAttribute("users");// 加载当前用户
		room.setTime(new Date().toLocaleString());
		room.setState(1); // 等待审核
		room.setAreaType(aserver.getthis(leaseform.getAreaId())); // 加载并设置一个区域对象
		room.setHouseType(hserver.getHouse_type(leaseform.getHtypeId())); // 加载并设置一个房源类别对象
		room.setUsers(users);

		// 判断用户联系方式是否有改变
		if (!users.getPhone().equals(leaseform.getTelePhone())
				|| !users.getEmail().endsWith(leaseform.getEmail())) {
			// 有改变，修改当前用户信息
			users.setPhone(leaseform.getTelePhone());
			users.setEmail(leaseform.getEmail());
			userver.update(users);
		}

		boolean isroom = false;
		boolean isimg = true;
		int isimgCount = 0;

		// 获得上传文件保存在服务器上的文件夹路径
		String path = this.servlet.getServletContext()
				.getRealPath("/uploadIMG");

		for (int i = 0; i < leaseform.getFile().length; i++) {
			FormFile file = leaseform.getFile()[i];
			if (file != null && !file.getFileName().equals("")) { // 需要上传图片的情况

				String date = new SimpleDateFormat("yyyyMMddhhmmss")
						.format(new Date());
				String fileName = file.getFileName(); // 获得上传文件名
				fileName = users.getUname() + "_" + date
						+ fileName.substring(fileName.lastIndexOf(".")); // 重命名上传文件名

				if (isimgCount == 0) {
					room.setImg(fileName); // 设置封面
					isroom = lserver.addRoom(room);// 添加该条房源信息
				}
				if (!isroom) { // 房源信息添加失败，停止图片上传
					break;
				}
				// 获得上传文件数据
				byte[] data = file.getFileData();
				// 创建文件对象
				File uploadFile = new File(path + "\\" + fileName);
				// 创建文件输出流
				FileOutputStream stream = new FileOutputStream(uploadFile);
				stream.write(data);

				// 添加图片到数据库表
				ImageTableServer iserver = new ImageTableServerImpl();
				ImageTable image = new ImageTable();
				image.setImage(fileName);
				image.setLeaseRoom(room);
				if (!iserver.add(image)) { // 添加图片出错
					isimg = false;
					break;
				} else {
					isimgCount++; // 添加的图片数
				}

			}
		}

		if (isimgCount == 0) {// 不需要上传图片的情况，
			room.setImg("");
			isroom = lserver.addRoom(room);// 直接添加该条房源信息
		}
		if (isroom && isimg) { // 图片全部成功上传
			if (isimgCount == 0) { // 没有上传图片
				response.getWriter().print("<script>");
				response.getWriter().print("alert('发布出租房源成功！');");
				response.getWriter().print("window.location='room.jsp';");
				response.getWriter().print("</script>");

			} else { // 图片全部成功上传
				response.getWriter().print("<script>");
				response.getWriter().print("alert('发布出租房源成功！图片已被成功上传');");
				response.getWriter().print("window.location='room.jsp';");
				response.getWriter().print("</script>");
			}

		} else if (isroom && isimg == false && isimgCount > 0) { // 部分图片上传成功
			response.getWriter().print("<script>");
			response.getWriter().print(
					"alert('发布出租房源成功！" + isimgCount + "张图片已被成功上传');");
			response.getWriter().print("window.location='room.jsp';");
			response.getWriter().print("</script>");
		} else if (isroom && isimg == false && isimgCount == 0) { // 图片上传失败
			response.getWriter().print("<script>");
			response.getWriter().print("alert('发布出租房源成功！图片上传失败');");
			response.getWriter().print("window.location='room.jsp';");
			response.getWriter().print("</script>");
		} else { // 发布出租房源失败(图片不被上传)
			response.getWriter().print("<script>");
			response.getWriter().print("alert('发布出租房源失败，请重新再试！');");
			response.getWriter().print("window.history.go(-1);");
			response.getWriter().print("</script>");
		}

		return null;
	}

	// 分页查询所有出租房源信息(管理员后台)
	public ActionForward showRoomAdmin(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalAccessException,
			InvocationTargetException, IOException {
		int row = 8; // 每页所要显示的数据条数

		int state = 2;  //不显示审核未通过的
		show(row, state, form, request, response);// 调用show()方法，获得房源信息分页数据

		return mapping.findForward("showroom");
	}

	// 获得房源信息分页数据
	public void show(int row, int state, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException,
			FileNotFoundException, IOException {
		LeaseRoomForm leaseRoomForm = (LeaseRoomForm) form;
		LeaseRoomServer lserver = new LeaseRoomServerImpl();

		LeaseRoomBean lbean = new LeaseRoomBean(); // 条件javaBean
		lbean.setState(state);
		int showPage = leaseRoomForm.getShowPage(); // 获得所要显示的页码

		BeanUtils.copyProperties(lbean, leaseRoomForm); // 复制条件javabean

		if (row == 5) {
			int uid = ((Users) request.getSession().getAttribute("users"))
					.getUid(); // 获得当前用户id
			lbean.setUid(uid); // 根据用户id查询分页
		}
		PublicBean bean = lserver.getByPage(showPage, row, lbean);
		List<LeaseRoom> lrList = bean.getList();

		request.setAttribute("showPage", showPage);
		request.setAttribute("allPage", bean.getAllPage());
		request.setAttribute("allCount", bean.getAllCount());
		request.setAttribute("rlList", bean.getList());
		request.setAttribute("lbean", lbean); // 存储条件

	}

	// 分页查询所有出租房源信息(用户后台)
	public ActionForward showRoom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws FileNotFoundException, IllegalAccessException,
			InvocationTargetException, IOException {
		int row = 5; // 每页所要显示的数据条数

		int state = 0;
		show(row, state, form, request, response);// 调用show()方法，获得房源信息分页数据
		request.setAttribute("islist", "is");
		return mapping.findForward("show");
	}

	// 分页查询所有出租房源信息(前台首页)
	public ActionForward showRoomIndex(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException,
			FileNotFoundException, IOException {
		LeaseRoomServer server = new LeaseRoomServerImpl();
		int row = 8;
		int state = 3;
		show(row, state, form, request, response);// 调用show()方法，获得房源信息分页数据

		sel(request, response); // 获得区域和房源类别数据

		if (request.getSession().getAttribute("users") != null) { // 判断用户是否登录
			// 如果已登录，获得当前用户浏览过的房源信息
			getCookie(request, response);
		}

		List<LeaseRoom> list = server.topRoom(new LeaseRoomBean(), 5);
		request.setAttribute("list", list);
		return mapping.findForward("index");
	}

	// 获得用户浏览过的房源信息
	public void getCookie(HttpServletRequest request,
			HttpServletResponse response) {
		LeaseRoomServer server = new LeaseRoomServerImpl();
		int uid = ((Users) request.getSession().getAttribute("users")).getUid();// 获得当前登录用户id
		String cookieName = "roomList" + uid; // cookie名
		Cookie cookies[] = request.getCookies();

		if (cookies != null) {
			Cookie cookie = null;
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) {
					cookie = c;
					break;
				}
			}
			if (cookie != null) {
				String strs[] = cookie.getValue().split(",");// 获得每一个房源id并存入数组
				List<LeaseRoom> cookieRoom = new ArrayList<LeaseRoom>();
				for (String str : strs) {
					// 加载房源信息
					LeaseRoom room = server.getRoom(Integer.parseInt(str));
					// 存入list集合
					if (room != null) {
						cookieRoom.add(room);
					}
				}
				request.setAttribute("cookieRoom", cookieRoom);
			}
		}

	}

	// 获得出租房源信息额及图片
	public LeaseRoom getisRoom(ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws IllegalAccessException,
			InvocationTargetException, FileNotFoundException, IOException {
		LeaseRoomForm leaseform = (LeaseRoomForm) form;

		LeaseRoomServer server = new LeaseRoomServerImpl();
		ImageTableServer imgserver = new ImageTableServerImpl();

		int rid = leaseform.getId();
		LeaseRoom room = server.getRoom(rid); // 加载该房源对象
		List<ImageTable> img = imgserver.selImage(rid); // 获得图片集合
		int size = 0;
		if (img != null) {
			size = img.size();
		}
		request.setAttribute("image", img);

		request.setAttribute("imgSize", size);
		return room;

	}

	// 获得出租房源信息(前台查看)
	public ActionForward getleaseRoom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException,
			FileNotFoundException, IOException {
		LeaseRoomServer server = new LeaseRoomServerImpl();

		LeaseRoom room = getisRoom(form, request, response);
		LeaseRoomBean bean = new LeaseRoomBean();
		bean.setUid(room.getUsers().getUid()); // 用户id,这里为房东
		bean.setId(room.getId());
		List<LeaseRoom> list = server.topRoom(bean, 8); // 获得该房东其他出租房源信息

		request.setAttribute("rlist", list);
		request.setAttribute("room", room);

		if (request.getSession().getAttribute("users") != null) { // 判断用户是否登录
			// 如果已登录，把用户浏览的房源信息存入cookie
			setCookie(request, response, room.getId() + "");
		}

		return mapping.findForward("info");

	}

	// 设置用户浏览过房源信息
	public void setCookie(HttpServletRequest request,
			HttpServletResponse response, String rid) {

		Cookie cookies[] = request.getCookies();
		String roomList = "";
		String iscookie = "n";
		int uid = ((Users) request.getSession().getAttribute("users")).getUid();// 获得当前登录用户id
		String cookieName = "roomList" + uid; // 设置cookie名
		Cookie cookie = null;
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(cookieName)) { // 找到该cookie对象
					cookie = c;

					roomList = cookie.getValue();
					String strs[] = roomList.split(",");
					String isrid = "n";
					for (String str : strs) {
						if (str.equals(rid)) {
							isrid = "y";
							break;
						}
					}

					if (isrid.equals("n")) {
						roomList = rid + "," + roomList;
						cookie.setValue(roomList);
						response.addCookie(cookie);
						iscookie = "y";
						break;
					}
				}
			}
		}
		if (iscookie.equals("n")) { // 没有找到对应cookie对象,创建一个新的
			roomList = rid;
			cookie = new Cookie(cookieName, roomList);
			cookie.setMaxAge(60 * 60 * 24 * 15); // 设置cookie的有效存活期为15天
			cookie.setPath("/");
			response.addCookie(cookie);

		}
	}

	// 获得出租房源信息(修改)
	public ActionForward getRoom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException,
			FileNotFoundException, IOException {
		LeaseRoomForm leaseRoomForm = (LeaseRoomForm) form;

		LeaseRoom room = getisRoom(form, request, response); // 获得房源信息及图片
		sel(request, response);
		String esthment = room.getEsthment();
		BeanUtils.copyProperties(leaseRoomForm, room); // 复制javaBean属性

		if (esthment != null && !esthment.equals("")) {
			String esthments[] = esthment.split(",");
			leaseRoomForm.setEsthments(esthments);
		}
		leaseRoomForm.setAreaId(room.getAreaType().getGid());
		leaseRoomForm.setHtypeId(room.getHouseType().getId());

		return mapping.findForward("update");

	}

	// 修改
	public ActionForward updateRoom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException,
			FileNotFoundException, IOException {
		LeaseRoomForm leaseform = (LeaseRoomForm) form;

		LeaseRoomServer lserver = new LeaseRoomServerImpl();
		AreaTypeServer aserver = new AreaTypeServerImpl();
		HouseTypeServer hserver = new HouseTypeServerimpl();
		UserServer user = new UserServerImpl();

		Users users = (Users) request.getSession().getAttribute("users");// 获得当前用户
		LeaseRoom room = lserver.getRoom(leaseform.getId()); // 加载出所要修改的房源

		BeanUtils.copyProperties(room, leaseform); // 复制javaBean属性
		room.setAreaType(aserver.getthis(leaseform.getAreaId())); // 加载并设置一个区域对象
		room.setHouseType(hserver.getHouse_type(leaseform.getHtypeId())); // 加载并设置一个房源类别对象
		// 房源基础设施
		if (leaseform.getEsthments() != null) {
			String esthment = "";
			for (String ment : leaseform.getEsthments()) {
				esthment += ment + ",";
			}
			esthment = esthment.substring(0, esthment.length() - 1);
			room.setEsthment(esthment);
		}

		room.setTime(new Date().toLocaleString());
		room.setState(1);

		// 判断用户联系方式是否有改变
		if (!users.getPhone().equals(leaseform.getTelePhone())
				|| !users.getEmail().endsWith(leaseform.getEmail())) {
			// 有改变，修改当前用户信息
			users.setPhone(leaseform.getTelePhone());
			users.setEmail(leaseform.getEmail());
			user.update(users);
		}
		boolean isroom = false;
		boolean isimg = true;
		int isimgCount = 0;

		// 获得上传文件保存在服务器上的文件夹路径
		String path = this.servlet.getServletContext()
				.getRealPath("/uploadIMG");

		for (int i = 0; i < leaseform.getFile().length; i++) {
			FormFile file = leaseform.getFile()[i];
			if (file != null && !file.getFileName().equals("")) { // 需要上传图片的情况

				String date = new SimpleDateFormat("yyyyMMddhhmmss")
						.format(new Date());
				String fileName = file.getFileName(); // 获得上传文件名
				fileName = users.getUname() + "_" + date
						+ fileName.substring(fileName.lastIndexOf(".")); // 重命名上传文件名

				if (isimgCount == 0) {
					room.setImg(fileName); // 设置封面
					isroom = lserver.update(room);// 修改该条房源信息
				}
				if (!isroom) { // 房源信息修改失败，停止图片上传
					break;
				}
				// 获得上传文件数据
				byte[] data = file.getFileData();
				// 创建文件对象
				File uploadFile = new File(path + "\\" + fileName);
				// 创建文件输出流
				FileOutputStream stream = new FileOutputStream(uploadFile);
				stream.write(data);

				// 添加图片到数据库表
				ImageTableServer iserver = new ImageTableServerImpl();
				ImageTable image = new ImageTable();
				image.setImage(fileName);
				image.setLeaseRoom(room);
				if (!iserver.add(image)) { // 添加图片出错
					isimg = false;
					break;
				} else {
					isimgCount++; // 添加的图片数
				}

			}
		}

		if (isimgCount == 0) {// 不需要上传图片的情况，
			room.setImg("");
			isroom = lserver.update(room);// 直接修改该条房源信息
		}

		if (isroom && isimg) {
			if (isimgCount == 0) { // 没有上传图片
				response.getWriter().print("<script>");
				response.getWriter().print("alert('出租房源修改成功！');");
				response.getWriter().print("window.location='room.jsp';");
				response.getWriter().print("</script>");

			} else { // 图片全部成功上传
				response.getWriter().print("<script>");
				response.getWriter().print("alert('出租房源修改成功！图片已被成功上传');");
				response.getWriter().print("window.location='room.jsp';");
				response.getWriter().print("</script>");
			}

		} else if (isroom && isimg == false && isimgCount > 0) { // 部分图片上传成功
			response.getWriter().print("<script>");
			response.getWriter().print(
					"alert('出租房源修改成功！" + isimgCount + "张图片已被成功上传');");
			response.getWriter().print("window.location='room.jsp';");
			response.getWriter().print("</script>");
		} else if (isroom && isimg == false && isimgCount == 0) { // 图片上传失败
			response.getWriter().print("<script>");
			response.getWriter().print("alert('出租房源修改成功！图片上传失败');");
			response.getWriter().print("window.location='room.jsp';");
			response.getWriter().print("</script>");
		} else { // 发布出租房源失败(图片不被地传)
			response.getWriter().print("<script>");
			response.getWriter().print("alert('出租房源修改失败，请重新再试！');");
			response.getWriter().print("window.history.go(-1);");
			response.getWriter().print("</script>");
		}

		return null;
	}

	public ActionForward delRoom(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IllegalAccessException, InvocationTargetException,
			FileNotFoundException, IOException {
		LeaseRoomForm leaseform = (LeaseRoomForm) form;
		LeaseRoomServer server = new LeaseRoomServerImpl();

		String fromto = leaseform.getFromto();

		int id = leaseform.getId(); // 获得所要删除的房源id

		boolean flag = false;

		if (fromto != null && fromto.equals("admin")) { // 后台管理员删除
			LeaseRoom room = server.getRoom(id);
			room.setState(2);          //修改状态为审核未通过
			flag = server.update(room);
		}// 前台用户删除
		else {
			flag = server.delRoom(id);
		}

		if (!flag) {
			response.getWriter().print("<script>");
			response.getWriter().print("alert('房源删除失败，请重新再试！');");
			response.getWriter().print("window.history.go(-1);");
			response.getWriter().print("</script>");
			return null;
		} else {
			response.getWriter().print("<script>");
			
			if(fromto != null && fromto.equals("admin")){  //返回后台管理
				response.getWriter().print("window.location='leaseRoom.do?method=showRoomAdmin&showPage=1';");
			}else{     
				//返回前台用户管理
				response.getWriter().print("window.location='leaseRoom.do?method=showRoom&showPage=1';");
			}
			
			response.getWriter().print("</script>");
			return null;
		}
	}
}