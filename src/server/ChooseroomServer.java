package server;

import java.util.List;

import bean.PublicBean;

import entity.ChooseRoom;

public interface ChooseroomServer {
	
	public boolean insertchooseroom(ChooseRoom chooseroom);
	
	public boolean deletechooseroom(int id);
	
	public ChooseRoom getChooseroom(int id);
	
	public boolean updatechooseroom(ChooseRoom chooseroom);
	
	public List<ChooseRoom> select(int lid);
	
	public PublicBean getByPage(int page,int uid);
	
	public String add(int roomid,int uid);  //添加(dwr)
}
