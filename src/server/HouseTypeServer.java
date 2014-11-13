package server;

import java.io.Serializable;
import java.util.List;

import entity.HouseType;

public interface HouseTypeServer {
	public boolean insert(HouseType houseType);   //添加
	
	public boolean delObj(int id);   //删除
	
	public boolean update(HouseType houseType);   //修改
	
	public List<HouseType> select();   //查询
	
	public HouseType getHouse_type(int id);   //加载
	
	public HouseType getType(String type);   //根据类型获得一个JavaBean
	
	
	public boolean selectType(String type);  //查询是否已有该类型的数据
	
	
	

}
