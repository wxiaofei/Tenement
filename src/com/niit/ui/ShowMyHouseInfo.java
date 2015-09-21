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

public class ShowMyHouseInfo extends JFrame 
{
	private Users users;
	private UsersDao usersDao;
//	private UserMain userMain;
	private HouseDao houseDao;
	
	//���
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//�������
	private JScrollPane pane;
	//���ģ��
	private DefaultTableModel tableModel;
	
	
	public ShowMyHouseInfo(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		
		houseDao=new HouseDao();
		
		this.setBounds(200, 100, 800, 500);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�ҵķ�����Ϣ:"+users.getUsername());
		
		ArrayList<House> list=houseDao.findHouseByIdentity(users.getIdentity());
		int num=list.size();//��ҵ���м��׷���
		data=new Object[num][5];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getHouseid();
			data[i][1]=list.get(i).getArea();
			data[i][2]=list.get(i).getAdress();
			data[i][3]=list.get(i).getPrice();
			data[i][4]=list.get(i).getIdentity();
		}
		columnNames=new String[]{"����id","���","��ַ","�ܼ�","����id"};
		tableModel=new DefaultTableModel(data, columnNames)
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
