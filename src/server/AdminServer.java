package server;

import java.util.List;

import entity.Admin;

public interface AdminServer {
	public boolean insertAdmin(Admin admin);// 添加管理员
	public boolean updateAdmin(Admin admin);// 修改管理员
	public boolean deleteAdmin(int aid);//删除管理员
	public List<Admin> getPage(int page);// 查看管理员
	public Admin loginAdmin(String aname);// 验证管理员登录
	public Admin getAdmin(int aid); // 加载
	public List<Admin> select();
	public Admin getAdmins(String aname);//获取一个JavaBean
	


}
