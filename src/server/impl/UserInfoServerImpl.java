package server.impl;

import java.util.ArrayList;
import java.util.List;

import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;
import entity.UsersInfo;
import server.UserInfoServer;

public class UserInfoServerImpl implements UserInfoServer {
	private ProjectDao dao=new ProjectDaoimpl();
	public UsersInfo selectUsersInfoName(int uid) {
		
		String hql=" select ui from UsersInfo ui where uid=? ";
		List args=new ArrayList();
		args.add(uid);
		List<UsersInfo> list=dao.select(hql, args);
		UsersInfo info=null;
		if(list.size()>0)
		{
			info=list.get(0);
		}
		
		return info;
	}
	public boolean add(UsersInfo usersInfo) {
		
		return dao.add(usersInfo);
	}
	public boolean update(UsersInfo usersInfo) {
		// TODO Auto-generated method stub
		return dao.update(usersInfo);
	}
	public List<UsersInfo> select() {
		String hql="select info from UsersInfo info where 1=1";
		List<UsersInfo> infolist=dao.select(hql,null);
		return infolist;
	}
	
	public UsersInfo getuInfo(int uid) {
		// TODO Auto-generated method stub
		return (UsersInfo)dao.getPojo(UsersInfo.class, uid);
	}

}
