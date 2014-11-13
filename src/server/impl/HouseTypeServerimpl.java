package server.impl;

import java.util.ArrayList;
import java.util.List;

import server.HouseTypeServer;
import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;
import entity.HouseType;

public class HouseTypeServerimpl implements HouseTypeServer {
	
	private static final Class Class = null;
	private ProjectDao projectDao=new ProjectDaoimpl();

	public boolean delObj(int id) { //删除
		HouseType type=getHouse_type(id);
	    type.setState(0);
		return update(type);
	}

	public HouseType getHouse_type(int id) {  //加载
		// TODO Auto-generated method stub
		return (HouseType) projectDao.getPojo(HouseType.class, id);
	}

	public HouseType getType(String type) {   //根据类型获得一个JavaBean
		String hql=" select ht from HouseType ht where ht.state>0 and ht.type=?";
		List list=new ArrayList();
		list.add(type);
		List<HouseType> list2=projectDao.select(hql, list);
		HouseType houseType=null;
		if(list2.size()>0)
		{
			houseType=list2.get(0);
		}
		return houseType;
	}

	public boolean insert(HouseType houseType) {   //添加
		// TODO Auto-generated method stub
		return projectDao.add(houseType);
	}

	public List<HouseType> select() {  //查询
		String hql="select htype from HouseType htype where htype.state>0";  //hql的查询语句
		
		List<HouseType> hlist=projectDao.select(hql,null);  //调DAO层的查询方法
		
		return hlist;
	} 

	public boolean selectType(String type) {  //查询是否已有该类型的数据
		boolean falg=false;
		String hql=" select ht from HouseType ht where ht.state>0 and ht.type=?";
		List list=new ArrayList();
		list.add(type);
		List<HouseType> list2=projectDao.select(hql, list);
		if(list2.size()>0)
		{
			 falg=false;
		}else
		{
			falg=true;
		}
		return falg;
	}
	
	
	
	public boolean update(HouseType houseType) {  //修改
		// TODO Auto-generated method stub
		return projectDao.update(houseType);
	}

}
