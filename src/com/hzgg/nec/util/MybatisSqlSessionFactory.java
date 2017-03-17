/**
 * 
 */
package com.hzgg.nec.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author Mr.H
 *
 * create date  2017��3��1��  ����1:18:00
 */
public class MybatisSqlSessionFactory {
	
	private static SqlSessionFactory factory;
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();
	
	static{
		factory = bulidSqlSessionFactory();
	}
	
	/**
	 * ͨ��xml�����ļ���ȡSqlSessionFactory����
	 * @return SqlSessionFactory����
	 */
	private static SqlSessionFactory bulidSqlSessionFactory(){
		InputStream inputStream = null;
		try {
			String configFile = "mybatisconfig.xml";
			inputStream = Resources.getResourceAsStream(configFile);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(inputStream != null){
					inputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return factory;
	}
	
	
	/**
	 * ��ȡSqlSession ����
	 * @return SqlSession
	 */
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession == null){
			if(factory == null){
				factory = bulidSqlSessionFactory();
			}
			sqlSession = factory.openSession();
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}
	
	/**
	 * �ر�SqlSession
	 */
	public static void closeSqlSession(){
		SqlSession sqlSession = threadLocal.get();
		if(sqlSession != null){
			sqlSession.close();
			threadLocal.remove();
		}
	}
}
