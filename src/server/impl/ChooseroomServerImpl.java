package server.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.ChooseroomServer;
import server.LeaseRoomServer;
import server.UserServer;
import bean.PublicBean;
import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;
import entity.ChooseRoom;
import entity.LeaseRoom;
import entity.Users;

public class ChooseroomServerImpl implements ChooseroomServer {
	private ProjectDao projectDao = new ProjectDaoimpl();

	public boolean deletechooseroom(int id) {
		ChooseRoom chooseroom = getChooseroom(id);
		return projectDao.delete(chooseroom);
	}

	public ChooseRoom getChooseroom(int id) {
		// TODO Auto-generated method stub
		return (ChooseRoom) projectDao.getPojo(ChooseRoom.class, id);
	}

	public boolean insertchooseroom(ChooseRoom chooseroom) {

		return projectDao.add(chooseroom);
	}

	public List<ChooseRoom> select(int lid) {
		String hql = "select c from ChooseRoom c where c.leaseRoom.id=?";
		List args = new ArrayList();
		args.add(lid);
		List<ChooseRoom> clist = projectDao.select(hql, args);
		return clist;
	}

	public boolean updatechooseroom(ChooseRoom chooseroom) {

		return projectDao.delete(chooseroom);
	}

	public PublicBean getByPage(int page,int uid) {
		// TODO Auto-generated method stub
		String hql = "select cr from ChooseRoom cr where 1=1";
		String count_hql = "select count(cr) from ChooseRoom cr where 1=1";
		List args=new ArrayList();
		if(uid!=0){
			hql+=" and cr.users.uid=?";
			count_hql+=" and cr.users.uid=?";
			args.add(uid);
		}
		 
		int row = 5;
		List<ChooseRoom> list = projectDao.getByPage(hql, page, args, row);
		int allCount = (Integer) projectDao.uniqueSelect(count_hql, args);
		int allPage = 0;
		if (allCount % row == 0) {
			allPage = allCount / row;
		} else {
			allPage = (allCount / row) + 1;
		}

		PublicBean bean = new PublicBean();
		bean.setAllCount(allCount);
		bean.setAllPage(allPage);
		bean.setShowPage(page);
		bean.setList(list);
		return bean;
	}

	public String add(int roomid, int uid) {
		// TODO Auto-generated method stubo
		String msg = "";
		List<ChooseRoom> clist = select(roomid);
		if (clist.size() > 0) {
			msg = "您已经收藏了该房源!";
		} else {
			LeaseRoomServer server = new LeaseRoomServerImpl();
			UserServer userver = new UserServerImpl();
			LeaseRoom room = server.getRoom(roomid); // 加载所要收藏的出租房源对象
			Users users = userver.getUser(uid);// 加载当前用户对象

			ChooseRoom chooseRoom = new ChooseRoom();
			chooseRoom.setLeaseRoom(room);
			chooseRoom.setState(1);
			chooseRoom.setTime(new Date().toLocaleString());
			chooseRoom.setUsers(users);
			if(insertchooseroom(chooseRoom)){
				msg = "收藏成功!";
			}else{
				msg = "收藏失败!";
			}
			
		}

		return msg;
	}

}
