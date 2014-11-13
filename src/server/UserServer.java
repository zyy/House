package server;


import java.io.Serializable;
import java.util.List;

import bean.PublicBean;

import entity.Users;

public interface UserServer {
	public boolean add(Users users);//添加
	
	public boolean delete(int uid);//删除
	
	public Users login(String uname,String upwd);  //用户登录
	
	public boolean update(Users users);//修改
	
	public List<Users> select(List args);//一般查询
	
	public PublicBean selectByPage(int page,String uname);//分页查询
	
	public Users getUser(Serializable uid);//加载
	
	public Users getUsers(String uname); //根据Uname获得一个JavaBean对象

}
