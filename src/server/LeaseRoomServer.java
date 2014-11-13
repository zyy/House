package server;

import java.util.List;

import bean.LeaseRoomBean;
import bean.PublicBean;

import entity.LeaseRoom;

public interface LeaseRoomServer {

	public boolean addRoom(LeaseRoom room);  //添加
	
	public boolean delRoom(int id);//删除
	
	public boolean update(LeaseRoom room);//修改
	
	public LeaseRoom getRoom(int id);//加载
	
	public List<LeaseRoom> selectInfo(LeaseRoomBean bean); //一般查询
	
	public PublicBean getByPage(int page,int row,LeaseRoomBean bean);//分页查询
	
	public List<LeaseRoom> topRoom(LeaseRoomBean bean,int count);//带top的查询
}
