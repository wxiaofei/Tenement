package com.niit.dao.test;

import java.util.ArrayList;

import com.niit.dao.impl.EmployeeDao;
import com.niit.entity.Employee;

public class EmployeeDaoTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		EmployeeDao employeeDao=new EmployeeDao();
		
		/**
		 * ����Ա��
		 */
//		Employee employee=new Employee();
//		employee.setEmployeeid(4);
//		employee.setEmployeename("A");
//		employee.setJob("ˮ");
//		employee.setPhone("12345678932");
//		boolean flag=employeeDao.addEmployee(employee);
//		if(flag)
//		{
//			System.out.println("����Ա���ɹ�");
//		}
//		else
//		{
//			System.out.println("����Ա��ʧ��");
//		}
		/**
		 * ɾ��Ա��
		 */
//		boolean flag=employeeDao.deleteEmployee(4);
//		System.out.println(flag?"ɾ��Ա���ɹ�":"ɾ��Ա��ʧ��");
		
		/**
		 * �޸�Ա����Ϣ
		 * �޸�2003����Ϣ
		 * ��Ҫ�޸ĵ��޸ı�����������ֵ�������޸ľ���employee1.*����ԭ����ֵ
		 */
//		Employee employee1=employeeDao.findEmployeeByEmployeeid(2003);
//		Employee employee=new Employee();
//		employee.setEmployeeid(employee1.getEmployeeid());
//		employee.setEmployeename("jack");
//		employee.setJob(employee1.getJob());
//		employee.setPhone(employee1.getPhone());
//		boolean flag=employeeDao.modifyEmployee(employee);
//		System.out.println(flag?"�޸�Ա���ɹ�":"�޸�Ա��ʧ��");
		
		
		/**
		 * ����Ա��id����Ա��
		 */
//		Employee employee=employeeDao.findEmployeeByEmployeeid(2001);
//		if(employee==null)
//		{
//			System.out.println("������Ա��");
//		}
//		else
//		{
//			System.out.println(employee.getEmployeeid()+"\t"+employee.getEmployeename()+"\t"+employee.getJob()+"\t"+employee.getPhone());
//		}
		/**
		 * ����Ա����������
		 */
//		Employee employee=employeeDao.findEmployeeByEmployeename("jack");
//		if(employee==null)
//		{
//			System.out.println("������Ա��");
//		}
//		else
//		{
//			System.out.println(employee.getEmployeeid()+"\t"+employee.getEmployeename()+"\t"+employee.getJob()+"\t"+employee.getPhone());
//		}
		/**
		 * ���ݹ�����ѯԱ�������ܷ��ض��ֵ
		 */
//		ArrayList<Employee> list=employeeDao.findEmployeeByJob("ˮ");
//		for(Employee e:list)
//		{
//			System.out.println(e.getEmployeeid()+"\t"+e.getEmployeename()+"\t"+e.getJob()+"\t"+e.getPhone());
//		}
		
		/**
		 * ��ѯ����Ա��
		 */
//		ArrayList<Employee> list=employeeDao.findAllEmployee();
//		for(Employee e:list)
//		{
//			System.out.println(e.getEmployeeid()+"\t"+e.getEmployeename()+"\t"+e.getJob()+"\t"+e.getPhone());
//		}
		

	}

}
