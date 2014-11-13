package dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.ProjectDao;

public class ProjectDaoimpl implements ProjectDao {

	public boolean add(Object obj) { // 添加
		boolean flag = false;
		Session session = GetSession.getSession(); // 获得session对象

		Transaction transaction = null; // 声明事务
		try {
			transaction = session.beginTransaction(); // 开始一个事务
			session.save(obj); // 执行添加方法
			transaction.commit(); // 成功后提交事务
			flag = true;
		} catch (HibernateException e) {

			transaction.rollback(); // 失败后回滚事务
			e.printStackTrace();

		} finally {

			session.close(); // 关闭Session
		}

		return flag;
	}

	public boolean delete(Object obj) { // 删除
		boolean flag = false;
		Session session = GetSession.getSession(); // 获取Session对象

		Transaction transaction = null; // 定义一个事务

		try {
			transaction = session.beginTransaction(); // 打开事务

			session.delete(obj); // 执行删除操作

			transaction.commit(); // 成功提交事务

			flag = true;

		} catch (HibernateException e) {
			transaction.rollback(); // 失败后回滚事务
			e.printStackTrace();
		} finally {

			session.close();

		}

		return flag;
	}

	public Object getPojo(Class clazz, Serializable id) { // 加载

		Session session = GetSession.getSession(); // 获得session对象
		Object obj = null;
		Transaction tran = null;
		try {
			tran = session.beginTransaction();
			obj = session.get(clazz, id);
			tran.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			tran.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

		return obj;
	}

	public List select(String hql, List args) { // 查询
		Session session = GetSession.getSession(); // 获得session对象
		List list = new ArrayList();
		try {
			Query query = session.createQuery(hql); // 获得Query对象、

			if (args != null) { // 判断是否有参数
				for (int i = 0; i < args.size(); i++) {
					query.setParameter(i, args.get(i)); // 有参数，给hql语句的参数设置值
				}
			}
			list = query.list(); // 执行查询操作
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close(); // 关闭session对象
		}

		return list;
	}

	public boolean update(Object obj) { // 修改

		boolean flag = false;

		Session session = GetSession.getSession();
		Transaction transaction = null; // 定义一个事务

		try {
			transaction = session.beginTransaction(); // 打开事务

			session.update(obj); // 执行修改操作

			transaction.commit(); // 成功提交事务

			flag = true;

		} catch (HibernateException e) {
			transaction.rollback(); // 失败后回滚事务
			e.printStackTrace();
		} finally {

			session.close();

		}
		return flag;
	}

	public Object uniqueSelect(String hql, List args) { // 获得统计数据
		Object obj = null;
		Session session = GetSession.getSession(); // 获得session对象
		try {
			Query query = session.createQuery(hql);// 获得Query对象
			if (args != null) { // 判断是否有参数
				for (int i = 0; i < args.size(); i++) {
					query.setParameter(i, args.get(i)); // 给hql语句的参数设置值
				}
			}
			obj = query.uniqueResult();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return obj;
	}

	public List getByPage(String hql, int showPage, List args, int row) { // 分页查询

		List list = new ArrayList();
		Session session = GetSession.getSession();
		try {
			Query query = session.createQuery(hql); // 获得Query对象、

			if (args != null) { // 判断是否有参数
				for (int i = 0; i < args.size(); i++) {
					query.setParameter(i, args.get(i)); // 有参数，给hql语句的参数设置值
				}
			}
			int firstIndex = row * (showPage - 1);
			query.setFirstResult(firstIndex); // 设置开始编号
			query.setMaxResults(row); // 每页显示的行数
			list = query.list(); // 执行查询操作
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

	public List getByTop(String hql, List args, int count) {
		List list = new ArrayList();
		Session session = GetSession.getSession();
		try {
			Query query = session.createQuery(hql); // 获得Query对象、

			if (args != null) { // 判断是否有参数
				for (int i = 0; i < args.size(); i++) {
					query.setParameter(i, args.get(i)); // 有参数，给hql语句的参数设置值
				}
			}
			query.setFirstResult(0); // 设置开始编号
			query.setMaxResults(count); // 所要显示的行数
			list = query.list(); // 执行查询操作
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			session.close();
		}
		return list;
	}

}
