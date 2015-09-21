package com.niit.dao.iface;

import com.niit.entity.Manager;

public interface IManagerDao
{
	/**
	 * ���ݹ���Ա��������
	 * @param managername
	 * @return
	 */
	public abstract Manager findManagerByManagername(String managername);
	/**
	 * ����managerid���ҹ���Ա 
	 * @param managerid
	 * @return
	 */
	public abstract Manager findManagerByManagerid(int managerid);
	/**
	 * ����Ա�޸�������Ϣ
	 * @param manager
	 * @return
	 */
	public abstract boolean modifyManager(Manager manager);
}
