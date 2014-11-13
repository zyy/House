package server.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;

import entity.Admin;
import server.AdminServer;
import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

public class AdminServerImpl implements AdminServer {

	private ProjectDao projectDao=new ProjectDaoimpl();
	public boolean deleteAdmin(int aid) {//删除
		Admin admin=getAdmin(aid);
		return projectDao.delete(admin);
	}

	public boolean insertAdmin(Admin admin) { //添加
	
		return projectDao.add(admin);
	}
    public boolean updateAdmin(Admin admin) { //修改
		
		return projectDao.update(admin);
	}
    public Admin getAdmin(int aid) {//加载
		
		return (Admin) projectDao.getPojo(Admin.class, aid);
	}

	public Admin loginAdmin(String aname) {// 验证管理员登录
		String sql = "from Admin where aname=?";
		Admin admin = null;
		List args = new ArrayList();
		args.add(aname);
		List<Admin> alist = projectDao.select(sql, args);
		if (alist.size() > 0) {
			admin = alist.get(0);
		}
		return admin;

	}

	public List<Admin> getPage(int page) {// 查看管理员
		// TODO Auto-generated method stub
		return null;
	}

	public List<Admin> select() {
		String hql="select adm from Admin adm";
		List<Admin> alist=projectDao.select(hql, null);
		return alist;
	}

	public Admin getAdmins(String aname) {
		Admin admin = null;
		String hql = "select a from Admin a where a.aname=?";
		List values = new ArrayList();
		values.add(aname);
		List<Admin> alist = projectDao.select(hql, values);
		if (alist.size() > 0) {
			admin = alist.get(0);
		}
		return admin;
	}

	public Admin getSessionAdmin() {
		WebContext cnt = WebContextFactory.get(); // 获得JS请求流对象
		HttpServletRequest request = cnt.getHttpServletRequest();// 获得request
		HttpSession session = request.getSession();
		Admin admin = (Admin) session.getAttribute("admin"); // 获得当前存入session中的管理员
		return admin;
	}


}
