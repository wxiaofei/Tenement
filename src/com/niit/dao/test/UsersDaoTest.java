package com.niit.dao.test;

import java.util.ArrayList;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;

public class UsersDaoTest
{
	public static void main(String[] args)
	{
		UsersDao usersDao=new UsersDao();
		
		/**
		 * ��������ҵ��
		 */
//		ArrayList<Users> list=usersDao.findAllUsers();
//		for(Users u:list)
//		{
//			System.out.println(u.getIdentity()+"\t"+u.getUsername()+"\t"+u.getPwd()+"\t"+u.getPhone()+"\t"+u.getBalance());
//		}
		/**
		 * ����ҵ����������
		 */
//		Users user=usersDao.findUsersByUsername("B");
//		if(user==null)
//		{
//			System.out.println("�����ڸ�ҵ��");
//		}
//		else
//		{
//			System.out.println(user.getIdentity()+"\t"+user.getUsername()+"\t"+user.getPwd()+"\t"+user.getPhone()+"\t"+user.getBalance());
//		}
		
		/**
		 * ����ҵ�����֤����
		 */
//		Users user=usersDao.findUsersByIdentity("102");
//		if(user==null)
//		{
//			System.out.println("�����ڸ�ҵ��");
//		}
//		else
//		{
//			System.out.println(user.getIdentity()+"\t"+user.getUsername()+"\t"+user.getPwd()+"\t"+user.getPhone()+"\t"+user.getBalance());
//		}
		
		/**
		 * ����balance����ҵ��
		 */
//		ArrayList<Users> list=usersDao.findUsersByBalance(10);
//		for(Users u:list)
//		{
//			System.out.println(u.getIdentity()+"\t"+u.getUsername()+"\t"+u.getPwd()+"\t"+u.getPhone()+"\t"+u.getBalance());
//		}
		
		/**
		 * ����ҵ��
		 */
//		Users user=new Users();
//		user.setIdentity("107");
//		user.setUsername("G");
//		user.setPwd("123456");
//		user.setPhone("1213213355");
//		user.setBalance(0);
//		boolean flag=usersDao.addUsers(user);
//		if(flag)
//		{
//			System.out.println("����ҵ���ɹ�");
//		}
//		else
//		{
//			System.out.println("����ҵ��ʧ��");
//		}
		
		/**
		 * �޸�ҵ����Ϣ
		 * �޸�106����Ϣ
		 * ��Ҫ�޸ĵ��޸ı�����������ֵ�������޸ľ���user1.*����ԭ����ֵ
		 */
//		Users user1=usersDao.findUsersByIdentity("106");
//		Users user=new Users();
//		user.setIdentity(user1.getIdentity());
//		user.setUsername(user1.getUsername());
//		user.setPwd("123456");
//		user.setPhone(user1.getPhone());
//		user.setBalance(user1.getBalance());
//		
//		boolean flag=usersDao.modifyUsers(user);
//		if(flag)
//		{
//			System.out.println("�޸ĳɹ�");
//		}
//		else
//		{
//			System.out.println("�޸�ʧ��");
//		}
		/**
		 * ɾ��ҵ��
		 */
//		boolean flag=usersDao.deleteUsers("121212");
//		System.out.println(flag?"ɾ��ҵ���ɹ�":"ɾ��ҵ��ʧ��");
		
		
	}
}
