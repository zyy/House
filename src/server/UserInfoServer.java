package server;

import java.util.List;

import entity.UsersInfo;

public interface UserInfoServer {

	public UsersInfo selectUsersInfoName(int uid);//查询真实姓名
	
	public boolean add(UsersInfo usersInfo); //添加
	
	public boolean update(UsersInfo usersInfo);//修改
	

	public List<UsersInfo> select();//查询
	public UsersInfo getuInfo(int uid);//加载
		

}
