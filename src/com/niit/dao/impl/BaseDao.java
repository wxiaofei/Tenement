package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BaseDao
{
	private Connection con;
	/**
	 * ������
	 */
	public Connection getConnection()
	{
		//��ȡ�����ļ�
		ResourceBundle bundle=ResourceBundle.getBundle("ConDB");
		
		String driver=bundle.getString("driver");
		String url=bundle.getString("url");
		String username=bundle.getString("username");
		String pwd=bundle.getString("pwd");
		
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,pwd);
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ��");
		}
		System.out.println("��ϲ�㣬���ݿ����ӳɹ�");
		return con;
	}
	
	public void closeAll(ResultSet rs,Statement stmt,Connection con)
	{
		try
		{
			if(rs!=null)
			{
				rs.close();
				rs=null;
			}
			if(stmt!=null)
			{
				stmt.close();
				stmt=null;
			}
			if(con!=null)
			{
				con.close();
				con=null;
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
