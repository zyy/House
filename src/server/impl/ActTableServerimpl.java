package server.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;

import entity.ActTable;
import server.ActTableServer;

public class ActTableServerimpl implements ActTableServer {
	ProjectDao projectDao=new ProjectDaoimpl();

	public boolean add(ActTable actTable) {  //添加
		
		return projectDao.add(actTable);
	}

	
	public List<ActTable> getactTable(int id) {//加载ActTable集合

		String hql="select act from ActTable as act where act.state=1 and act.leaseRoom.id=?";
		List list=new ArrayList();
		list.add(id);
		List<ActTable> acttable=projectDao.select(hql, list);
		return acttable;
	}
	public boolean delete(ActTable actTable) {  //删除
		
		return projectDao.delete(actTable);
	}

	public List<ActTable> select() {   //查询
		String hql="select act from ActTable act ";
		List<ActTable> alist=projectDao.select(hql, null);
		return alist;
	}

	public ActTable getAct(Serializable id) {  //加载
		
		return (ActTable) projectDao.getPojo(ActTable.class, id);
	}

}
