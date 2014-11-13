package dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetSession {
	public static Session getSession()
	{
	  Session session=null;
	  Configuration configuration=new Configuration().configure();  //读取配置文件
	  
	  SessionFactory factory=configuration.buildSessionFactory();   //创建Session工厂
	  
	  session=factory.openSession();  // 打开Session
	  return session;
	}

}
