package com.niit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.niit.dao.iface.IHouseDao;
import com.niit.entity.House;

public class HouseDao extends BaseDao implements IHouseDao 
{
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Connection con;

	@Override
	public ArrayList<House> findAllHouse() 
	{
		ArrayList<House> list=new ArrayList<House>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from house");
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					House house=new House();
					house.setHouseid(rs.getInt(1));
					house.setArea(rs.getDouble(2));
					house.setAdress(rs.getString(3));
					house.setPrice(rs.getDouble(4));
					house.setIdentity(rs.getString(5));
					list.add(house);
					
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return list;
	}

	@Override
	public House findHouseByHouseid(int houseid) 
	{
		House house=null;
		
		try
		{
			con=getConnection();
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from house where houseid=?");
				pstmt.setInt(1, houseid);
				
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					house=new House(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return house;
	}

	@Override
	public boolean modifyHouse(House house) 
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				// ʹ��Ԥ������
				pstmt=con.prepareStatement("update house set identity=? where houseid=?");
				//ע�����
				pstmt.setString(1, house.getIdentity());
				pstmt.setInt(2, house.getHouseid());
				//ִ��SQL���
				int count=pstmt.executeUpdate();
				if(count==1)
				{
					flag=true;
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	@Override
	public boolean addHouse(House house) 
	{
		boolean flag=false;
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				//ʹ��Ԥ������
				pstmt=con.prepareStatement("insert into house values(?,?,?,?,?)");
				//ע�����
				pstmt.setInt(1, house.getHouseid());
				pstmt.setDouble(2, house.getArea());
				pstmt.setString(3, house.getAdress());
				pstmt.setDouble(4, house.getPrice());
				pstmt.setString(5, house.getIdentity());
				
				//ִ��SQL���
				int count=pstmt.executeUpdate();
				if(count==1)
				{
					flag=true;
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return flag;
	}

	@Override
	public ArrayList<House> findHouseByIdentity(String identity)
	{
		ArrayList<House> list=new ArrayList<House>();
		
		try
		{
			con=getConnection();
			
			if(con!=null)
			{
				pstmt=con.prepareStatement("select * from house where identity=?");
				//ע�����
				pstmt.setString(1, identity);
				//ִ��
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					House house=new House();
					house.setHouseid(rs.getInt(1));
					house.setArea(rs.getDouble(2));
					house.setAdress(rs.getString(3));
					house.setPrice(rs.getDouble(4));
					house.setIdentity(rs.getString(5));
					list.add(house);
					
				}
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeAll(rs, pstmt, con);
		}
		return list;
	}

}
