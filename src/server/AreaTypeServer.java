package server;

import java.io.Serializable;
import java.util.List;

import entity.AreaType;

public interface AreaTypeServer {
	
	public boolean addArea(AreaType areaType);//添加区域	
	public boolean delArea(AreaType areaType);//删除区域
	public List<AreaType> selArea();//查询区域
	public AreaType getthis(Serializable id);//加载
}
