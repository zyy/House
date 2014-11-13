package server.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bean.PublicBean;

import server.UserServer;
import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;
import entity.Users;

public class UserServerImpl implements UserServer {
	private ProjectDao dao = new ProjectDaoimpl();

	public boolean add(Users users) {// 添加

		return dao.add(users);
	}

	public boolean delete(int uid) { // 假删除
		Users users = (Users) getUser(uid);
		users.setState(0); // 删除后的状态为"0"
		return update(users);// 修改状态
	}

	public Users getUser(Serializable uid) { // 加载

		// TODO Auto-generated method stub
		return (Users) dao.getPojo(Users.class, uid);
	}

	public Users getUsers(String uname) { // 根据Uname获得一个JavaBean对象
		Users users = null;
		String hql = "select us from Users us where uname=?";
		List args = new ArrayList<Users>();
		args.add(uname);
		List<Users> ulist = dao.select(hql, args);
		if (ulist.size() > 0) {
			users = ulist.get(0);
		}
		return users;
	}

	public List<Users> select(List args) { // 一般查询
		String hql = "select us from Users us";
		List<Users> ulist = dao.select(hql, args);
		return ulist;
	}

	public boolean update(Users users) { // 修改

		return dao.update(users);
	}

	public boolean addUser(Users users) {
		// TODO Auto-generated method stub
		return dao.add(users);
	}

	public boolean delUser(Users users) {
		// TODO Auto-generated method stub
		return dao.delete(users);
	}

	public Users login(String uname, String upwd) {
		String hql = " select us from Users us where uname=? and upwd=?";
		List args = new ArrayList();
		args.add(uname);
		args.add(upwd);
		List<Users> list = dao.select(hql, args);
		Users users = null;
		if (list.size() > 0) {
			users = list.get(0);
		}
		return users;
	}

	public PublicBean selectByPage(int page, String uname) {
		String hql = "select us from Users us where state>0";
		String count_hql = "select count(us) from Users us where state>0";
		 
		List args = new ArrayList();
		if (uname != null && !uname.equals("")) {
			hql += " and us.uname like ?";
			count_hql += " and us.uname like ?";
			args.add("%"+uname+"%");
		}

		hql += " order by uid desc";
        System.out.println("ccc:"+count_hql);
		int row = 8;

		List list = dao.getByPage(hql, page, args, row);

		int allCount=(Integer)dao.uniqueSelect(count_hql, args);  //获得数据库所有数据条数
		int allPage = 0;
		if (allCount % row != 0) {
			allPage = (allCount / row) + 1;
		} else {
			allPage = allCount / row;
		}

		PublicBean bean = new PublicBean();
		bean.setList(list);
		bean.setShowPage(page);
		bean.setAllCount(allCount);
		bean.setAllPage(allPage);
		return bean;
	}

}
