package server.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bean.BegRentBean;
import bean.PublicBean;

import dao.ProjectDao;
import dao.impl.ProjectDaoimpl;

import entity.BegRent;
import server.BegRentServer;

public class BegRentServerImpl implements BegRentServer {
	private ProjectDao dao = new ProjectDaoimpl();

	public boolean addBegRent(BegRent begRent) {
		// TODO Auto-generated method stub
		return dao.add(begRent);
	}

	public boolean delBegRent(BegRent begRent) {
		// TODO Auto-generated method stub
		return dao.delete(begRent);
	}

	public List<BegRent> selBegRent() {

		String hql = "select br from BegRent br";

		return dao.select(hql, null);
	}

	public boolean upBegRent(BegRent begRent) {
		// TODO Auto-generated method stub
		return dao.update(begRent);
	}

	public PublicBean selectBegRentByPage(int showpage, int row,BegRentBean begRentBea) {

		String hql = "select br from  BegRent br where 1=1";
		String count_hql = "select count(br) from BegRent br where 1=1";
		List args=new ArrayList();
		if(begRentBea.getUid()!=0){
			hql+=" and br.users.uid=?";
			count_hql+=" and br.users.uid=?";
			args.add(begRentBea.getUid());
		}
		PublicBean bean = new PublicBean();

		if(begRentBea.getIslist()==null){
			List<BegRent> list = dao.getByPage(hql, showpage, args, row);
			bean.setList(list);
		}
		
		int allcount = (Integer) dao.uniqueSelect(count_hql, args);
		 
		int allpage = 0;
		if (allcount % row == 0) {
			allpage = allcount / row;
		} else {
			allpage = (allcount / row) + 1;
		}

		bean.setAllCount(allcount);
		bean.setAllPage(allpage);
		
		bean.setShowPage(showpage);

		return bean;
	}

	public BegRent getthis(Serializable id) {
		// TODO Auto-generated method stub
		return (BegRent) dao.getPojo(BegRent.class, id);
	}

	public PublicBean selectQianByPage(int showpage, int row,
			BegRentBean begRentBean) {

		String hql = "select br from  BegRent br where 1=1 and br.state=1 ";
		String count_hql = "select count(br) from BegRent br where 1=1 and br.state=1 ";
		List args = new ArrayList();

		if (begRentBean.getAid() != 0) {
			hql += "and br.areaType.gid=? ";
			count_hql += "and br.areaType.gid=? ";
			args.add(begRentBean.getAid());
		}
		if (begRentBean.getHid() != 0) {
			hql += "and br.chamber=? ";
			count_hql += "and br.chamber=? ";
			args.add(begRentBean.getHid());
		}
		if (begRentBean.getMinprice() != 0) {

			hql += "and br.maxprice<=? ";
			count_hql += "and br.maxprice=? ";
			args.add(begRentBean.getMinprice());
		}
		if (begRentBean.getMaxprice() != 0) {
			hql += "and br.minprice>=? ";
			count_hql += "and br.minprice=? ";
			args.add(begRentBean.getMaxprice());
		}
		if (begRentBean.getMinprice() != 0 && begRentBean.getMaxprice() != 0) {
			hql += " and br.minprice>=? and  br.maxprice<=? ";
			count_hql += " and br.minprice>=? and  br.maxprice<=? ";
			args.add(begRentBean.getMinprice());
			args.add(begRentBean.getMaxprice());
		}
		if (begRentBean.getHouseid() != 0) {
			hql += " and br.houseType.id=? ";
			count_hql += " and br.houseType.id=? ";
			args.add(begRentBean.getHouseid());
		}
		PublicBean bean = new PublicBean();

		int allcount = (Integer) dao.uniqueSelect(count_hql, args);

		List<BegRent> list = dao.getByPage(hql, showpage, args, row);
		bean.setList(list);

		int allpage = 0;
		if (allcount % row == 0) {
			allpage = allcount / row;
		} else {
			allpage = (allcount / row) + 1;
		}

		bean.setAllCount(allcount);
		bean.setAllPage(allpage);
		bean.setShowPage(showpage);
		return bean;
	}
}
