package server.impl;

import java.util.ArrayList;
import java.util.List;

import server.LeaseRoomServer;
import bean.LeaseRoomBean;
import bean.PublicBean;
import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;
import entity.LeaseRoom;

public class LeaseRoomServerImpl implements LeaseRoomServer {

	private ProjectDao dao = new ProjectDaoimpl();

	public boolean addRoom(LeaseRoom room) {
		// TODO Auto-generated method stub
		return dao.add(room);
	}

	public boolean delRoom(int id) {
		// TODO Auto-generated method stub
		LeaseRoom room=getRoom(id);
		room.setState(0);
		return update(room);
	}
	
	// 分页查询
	public PublicBean getByPage(int page,int row, LeaseRoomBean bean) { 
		 
		String hql = "select room from LeaseRoom room where 1=1 ";
		String count_hql = "select count(id) from LeaseRoom room where 1=1 ";

		List args = new ArrayList();
		
		/** * 判断是否有以下条件,对查询语句进行拼接 ** */
		if (bean.getState()==0) {  //前台用户管理
			hql += " and room.state>0";
			count_hql+= " and room.state>0";
		}if (bean.getState()==2) {   //后台管理员查看，不显示审核未通过的
			hql += " and room.state<>2 and room.state>0";
			count_hql+= " and room.state<>2 and room.state>0";
		}if (bean.getState()==3) {  //前台首页显示
			hql += " and room.state>=3";
			count_hql+= " and room.state>=3";
		}
		
		
		if (bean.getUid()!=0) {
			hql += " and room.users.uid=?";
			count_hql+= " and room.users.uid=?";
			args.add(bean.getUid());
		}
		
		if (bean.getAreaName() != null && !bean.getAreaName().equals("")) {
			hql += " and room.areaType.area=?";
			count_hql+= " and room.areaType.area=?";
			args.add(bean.getAreaName());
		}
		if (bean.getTitle() != null && !bean.getTitle().equals("")) {
			
			hql += " and room.title like ?";
			count_hql+= " and room.title like ?";
			args.add("%"+bean.getTitle()+"%");
		}
		if (bean.getChamber()!=null&&bean.getChamber()!=0) {
			hql += " and room.chamber=?";
			count_hql += " and room.chamber=?";
			args.add(bean.getChamber());
		}
		if (bean.getHouseType() != null && !bean.getHouseType().equals("")) {
			hql += " and room.houseType.type=?";
			count_hql += " and room.houseType.type=?";
			args.add(bean.getHouseType());
		}
		if (bean.getStartPrice()!=null && bean.getStartPrice()!=0) {
			hql += " and room.pirce>=?";
			count_hql += " and room.pirce>=?";
			args.add(bean.getStartPrice());
		}
		if (bean.getEndPrice()!=null && bean.getEndPrice()!=0) {
			hql += " and room.pirce<=?";
			count_hql += " and room.pirce<=?";
			args.add(bean.getEndPrice());
		}
		 
		
	
		//始终按时间倒序排序
		if(bean.getOrderBy() != null && bean.getOrderBy().equals("time")){//按时间升序
			hql+=" order by room.time ";
		}else{
			hql+=" order by room.time desc";  //按时间降序，默认
		}
		

		//-----------------------判断排序------------------------//
        if (bean.getOrderBy() != null && !bean.getOrderBy().equals("")) {
			if(bean.getOrderBy().equals("acreageDESC")){//面积从大到小
				hql+=",room.acreage desc";
			}
			if(bean.getOrderBy().equals("acreage")){//面积从小到大
				hql+=",room.acreage ";
			}
			if(bean.getOrderBy().equals("priceDESC")){//租金从高到低
				hql+=",room.pirce desc";
			}
			if(bean.getOrderBy().equals("price")){//租金从低到高
				hql+=",room.pirce";
			}
			
		} 
        /*** 返回值JavaBean ***/
        PublicBean pbean=new PublicBean();
        if(bean.getIslist()==null){
        	List<LeaseRoom> list=dao.getByPage(hql, page, args, row);  //获得每页所要显示的数据集合
            pbean.setList(list); 
        }
         
        int allCount=(Integer)dao.uniqueSelect(count_hql, args);  //获得数据库所有数据条数
        
      
        int allPage=0; //共有页码数
        if(allCount%row!=0){
			allPage=(allCount/row)+1;
		}else{
			allPage=allCount/row;
		}
        
       
        pbean.setAllCount(allCount);
        pbean.setAllPage(allPage);
        pbean.setShowPage(page);
        
		return pbean;
	}

	public LeaseRoom getRoom(int id) { // 加载
		// TODO Auto-generated method stub
		return (LeaseRoom) dao.getPojo(LeaseRoom.class, id);
	}

	public List<LeaseRoom> selectInfo(LeaseRoomBean bean) { // 一般查询
		// TODO Auto-generated method stub
		String hql = "select room from LeaseRoom room where room.state>0 ";
		List args = new ArrayList();
		/* 判断所带有的条件 */
		if (bean.getAreaName() != null && !bean.getAreaName().equals("")) {
			hql += " and room.areaType.area=?";
			args.add(bean.getAreaName());
		}
		 
		List<LeaseRoom> rlist = dao.select(hql, args);
		return rlist;
	}
	public boolean update(LeaseRoom room) {
		// TODO Auto-generated method stub
		return dao.update(room);
	}
//带TOP的查询
	public List<LeaseRoom> topRoom(LeaseRoomBean bean,int count) {
		String hql="select room from LeaseRoom room where room.state>2 ";
		List args=new ArrayList();
		if(bean.getUid()!=0){
			hql+=" and room.users.uid=?";
			args.add(bean.getUid());
		}
		if(bean.getId()!=0){
			hql+=" and room.id <>?";
			args.add(bean.getId());
		}
		hql+=" order by time desc";//排序
		List<LeaseRoom> list=dao.getByTop(hql, args, count);
		return  list;
	}

}
