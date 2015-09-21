package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.HouseDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.House;
import com.niit.entity.Users;

public class ShowAllHouse extends JFrame
{
	private HouseDao houseDao;
	private UsersDao usersDao;
	
	//���
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//�������
	private JScrollPane pane;
	//���ģ��
	private DefaultTableModel tableModel;
	
	public ShowAllHouse()
	{
		houseDao=new HouseDao();
		usersDao=new UsersDao();
		
		this.setBounds(300, 200, 800, 500);
		this.setTitle("���з�����Ϣ");
		
		ArrayList<House> list=houseDao.findAllHouse();
		int num=list.size();
		data=new Object[num][5];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getHouseid();
			data[i][1]=list.get(i).getArea();
			data[i][2]=list.get(i).getAdress();
			data[i][3]=list.get(i).getPrice();
			data[i][4]=list.get(i).getIdentity();
			//��ҵ����id����������ʾ
//			String identity=list.get(i).getIdentity();
//			Users users=usersDao.findUsersByIdentity(identity);
//			String name=users.getUsername();
//			data[i][4]=name;
		}
		columnNames=new String[]{"����id","���","��ַ","�۸�","ҵ��id"};
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
