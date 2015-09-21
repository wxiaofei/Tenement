package com.niit.dao.iface;

import java.util.ArrayList;

import com.niit.entity.Employee;

public interface IEmployeeDao
{
	/**
	 * ����Ա��
	 */
	public abstract boolean addEmployee(Employee employee);
	/**
	 * ����Ա�����ɾ��Ա��
	 */
	public abstract boolean deleteEmployee(int employeeid);
	/**
	 * �޸�Ա����Ϣ
	 */
	public abstract boolean modifyEmployee(Employee employee);
	/**
	 * ��������Ա��
	 * @return
	 */
	public abstract ArrayList<Employee> findAllEmployee();
	/**
	 * ����Ա����Ų���Ա��
	 */
	public abstract Employee findEmployeeByEmployeeid(int employeeid);
	/**
	 * ����Ա����������Ա��
	 */
	public abstract Employee findEmployeeByEmployeename(String employeename);
	/**
	 * ����Ա���������Ͳ���Ա�������ܷ��ض��Ա��
	 */
	public abstract ArrayList<Employee> findEmployeeByJob(String job);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
