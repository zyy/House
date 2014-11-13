package dao;

import java.io.Serializable;
import java.util.List;

public interface ProjectDao {
	//添加
	public boolean add(Object obj);
	//删除
	public boolean delete(Object obj);
	//修改
	public boolean update(Object obj);
	//一般查询
	public List select(String hql,List args);
	//加载一个JAVABEAN对象
	public Object getPojo(Class clazz,Serializable id);
	// 获得统计数据
	public Object uniqueSelect(String hql, List args);
	//分页查询
	public List getByPage(String hql, int showPage, List args, int row);
	//带TOP的查询
	public List getByTop(String hql,List args,int count);

}
