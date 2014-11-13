package server;

import java.io.Serializable;
import java.util.List;

import bean.BegRentBean;
import bean.PublicBean;

import entity.BegRent;

public interface BegRentServer {

	public boolean addBegRent(BegRent begRent);// 添加求租

	public boolean delBegRent(BegRent begRent);// 删除求租

	public boolean upBegRent(BegRent begRent);// 修改求租

	public List<BegRent> selBegRent();// 查询求租

	public PublicBean selectBegRentByPage(int showpage, int row,
			BegRentBean begRentBean);// 查询分页

	public BegRent getthis(Serializable id); // 加载

	public PublicBean selectQianByPage(int showpage, int row,
			BegRentBean begRentBean);

}
