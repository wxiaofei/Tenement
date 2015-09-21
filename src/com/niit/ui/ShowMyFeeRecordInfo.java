package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.FeeRecordDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.FeeRecord;
import com.niit.entity.Users;

public class ShowMyFeeRecordInfo extends JFrame 
{
	private Users users;
	private UsersDao usersDao;
//	private UserMain userMain;
	private FeeRecordDao feeRecordDao;
	
	//���
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//�������
	private JScrollPane pane;
	//���ģ��
	private DefaultTableModel tableModel;
	
	public ShowMyFeeRecordInfo(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		
		
		feeRecordDao=new FeeRecordDao();
		
		this.setBounds(200, 100, 800, 500);
		this.setTitle("�ҵĽ��Ѽ�¼");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ArrayList<FeeRecord> list=feeRecordDao.findFeeRecordByIdentity(users.getIdentity());
		int num=list.size();//��ҵ���м�����¼
		data=new Object[num][6];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getFeeid();
			data[i][1]=list.get(i).getIdentity();
			data[i][2]=list.get(i).getFee();
			
			String pass="";
			if(list.get(i).getPass()==0)
			{
				pass="δͨ��";
			}
			else if(list.get(i).getPass()==1)
			{
				pass="ͨ��";
			}
			data[i][3]=pass;
			
//			data[i][3]=list.get(i).getPass();
			data[i][4]=list.get(i).getFeetime();
			data[i][5]=list.get(i).getExamtime();
		}
		columnNames=new String[]{"�ɷ�id","ҵ��id","�ɷѽ��","�Ƿ�ͨ��","�ɷ�ʱ��","���ʱ��"};
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
