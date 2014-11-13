package server;

import java.io.Serializable;
import java.util.List;

import entity.ActTable;

public interface ActTableServer {
	public boolean add(ActTable actTable); //添加
	public boolean delete(ActTable actTable); //删除
	public List<ActTable> select();  //查询
	public ActTable getAct(Serializable id);  //加载
	
	public List<ActTable> getactTable(int id);//加载ActTable集合

}
