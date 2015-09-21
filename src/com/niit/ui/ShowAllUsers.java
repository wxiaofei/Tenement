package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;

public class ShowAllUsers extends JFrame
{
	private UsersDao usersDao;
	
	
	//���
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//�������
	private JScrollPane pane;
	//���ģ��
	private DefaultTableModel tableModel;
	
	
	public ShowAllUsers()
	{
		usersDao=new UsersDao();
		this.setBounds(300, 200, 800, 500);
		this.setTitle("����ҵ����Ϣ");

		
		ArrayList<Users> list=usersDao.findAllUsers();
		int num=list.size();
		data=new Object[num][5];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getIdentity();
			data[i][1]=list.get(i).getUsername();
			data[i][2]=list.get(i).getPwd();
			data[i][3]=list.get(i).getPhone();
			data[i][4]=list.get(i).getBalance();
		}
		columnNames=new String[]{"ҵ��id","����","����","�绰","���"};
		tableModel=new DefaultTableModel(data,columnNames)
		{
			//����ģ�͵�ʱ����дһ������
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		//ʵ�������
		tab=new JTable(tableModel);
		//�����������
		pane=new JScrollPane(tab);
		this.add(pane);
		this.setVisible(true);
	}
}
