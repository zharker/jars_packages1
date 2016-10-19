package com.bamboo.dashboard;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bamboo.dashboard.util.HibernateUtil;

public class DashboardExport {

	private static Logger logger = Logger.getLogger(DashboardExport.class);
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(args));
		mysqlConnectTest();
	}

	private static void mysqlConnectTest() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
        session.beginTransaction();
        
        List ls = session.createSQLQuery("SELECT * from jiraissue").list();
        
        System.out.println(ls.size());
        System.out.println(Arrays.toString(ls.toArray()));
		
        session.close();
        
        HibernateUtil.shutdown();
	}
}
