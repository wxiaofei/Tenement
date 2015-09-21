package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Users;

public interface IUsersDao
{
	/**
	 * ��������ҵ��
	 * @return
	 */
	public abstract ArrayList<Users> findAllUsers();
	
	/**
	 * ����ҵ����������
	 * @param username
	 * @return
	 */
	public abstract Users findUsersByUsername(String username);
	
	/**
	 * ͨ��ҵ�����֤����
	 * @param identity
	 * @return
	 */
	public abstract Users findUsersByIdentity(String identity);
	
	/**
	 * ͨ��balance����ҵ��
	 */
	public abstract ArrayList<Users> findUsersByBalance(int balance);
	
	/**
	 * ����ҵ��
	 * @param user
	 * @return
	 */
	public abstract boolean addUsers(Users user);
	
	/**
	 * �޸�ҵ��
	 * @param user
	 * @return
	 */
	public abstract boolean modifyUsers(Users user);
	
	/**
	 * ɾ��ҵ��
	 * @param identity
	 * @return
	 */
	public abstract boolean deleteUsers(String identity);
	
	
	
	
	
	
	
}
