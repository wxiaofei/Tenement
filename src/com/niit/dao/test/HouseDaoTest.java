package com.niit.dao.test;

import java.util.ArrayList;

import com.niit.dao.impl.HouseDao;
import com.niit.entity.House;

public class HouseDaoTest 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		HouseDao houseDao=new HouseDao();
		/**
		 * ��ѯ���з���
		 */
//		ArrayList<House> list=houseDao.findAllHouse();
//		for(House h:list)
//		{
//			System.out.println(h.getHouseid()+"\t"+h.getArea()+"\t"+h.getAdress()+"\t"+h.getPrice()+"\t"+h.getIdentity());
//		}
		
		/**
		 * ��������
		 */
//		House house=new House();
//		house.setHouseid(7001);
//		house.setArea(700);
//		house.setAdress("���ݳ���");
//		house.setPrice(7000000);
//		house.setIdentity("101");
//		boolean flag=houseDao.addHouse(house);
//		System.out.println(flag?"�������ݳɹ�":"��������ʧ��");
		
		/**
		 * ���ݷ���id���ҷ���
		 */
//		House house=houseDao.findHouseByHouseid(5001);
//		if(house==null)
//		{
//			System.out.println("�����ڸ÷���");
//		}
//		else
//		{
//			System.out.println(house.getHouseid()+"\t"+house.getArea()+"\t"+house.getAdress()+"\t"+house.getPrice()+"\t"+house.getIdentity());
//		}
		
		/**
		 * �޸ķ�����Ϣ��ֻ�����޸Ļ���id
		 */
//		House house1=houseDao.findHouseByHouseid(6001);
//		House house=new House();
//		house.setHouseid(house1.getHouseid());
//		house.setArea(house1.getArea());
//		house.setAdress(house1.getAdress());
//		house.setPrice(house1.getPrice());
//		house.setIdentity("106");
//		
//		boolean flag=houseDao.modifyHouse(house);
//		System.out.println(flag?"�޸ķ�����Ϣ�ɹ�":"�޸ķ�����Ϣʧ��");
		
		/**
		 * ����identity���ҷ��ݣ����ܷ��ض��ֵ
		 */
//		ArrayList<House> list=houseDao.findHouseByIdentity("101");
//		for(House h:list)
//		{
//			System.out.println(h.getHouseid()+"\t"+h.getArea()+"\t"+h.getAdress()+"\t"+h.getPrice()+"\t"+h.getIdentity());
//		}
		
		
		

	}

}
