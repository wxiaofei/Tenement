package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.House;

public interface IHouseDao 
{
	/**
	 * �鿴���з���
	 */
	public abstract ArrayList<House> findAllHouse();
	
	/**
	 * ���ݷ���id���ҷ���
	 * @param houseid
	 * @return
	 */
	public abstract House findHouseByHouseid(int houseid);
	
	/**
	 * ����ҵ��id���ҷ���
	 */
	public abstract ArrayList<House> findHouseByIdentity(String identity);
	
	/**
	 * �޸ķ�����Ϣ��ֻ�����޸ķ��ݵĻ���id
	 * @param house
	 * @return
	 */
	public abstract boolean modifyHouse(House house);
	
	/**
	 * ��������
	 * @param house
	 * @return
	 */
	public abstract boolean addHouse(House house);
	
	
}
