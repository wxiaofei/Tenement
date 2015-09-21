package com.niit.ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.RepairRecordDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.RepairRecord;
import com.niit.entity.Users;

public class ShowMyRepaireRecordInfo extends JFrame
{
	private Users users;
	private UsersDao usersDao;
	
//	private UserMain userMain;
	
	private RepairRecordDao repairRecordDao;
	
	//���
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//�������
	private JScrollPane pane;
	//���ģ��
	private DefaultTableModel tableModel;
	
	public ShowMyRepaireRecordInfo(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		repairRecordDao=new RepairRecordDao();
		
		this.setBounds(200, 100, 800, 500);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�ҵı��޼�¼:"+users.getUsername());
		
		ArrayList<RepairRecord> list=repairRecordDao.findRepairRecordByIdentity(users.getIdentity());
		int num=list.size();//��ҵ���м������޼�¼
		data=new Object[num][7];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getRepairid();
			data[i][1]=list.get(i).getIdentity();
			data[i][2]=list.get(i).getRepairdetail();
			data[i][3]=list.get(i).getRepairtime();
			
			String state="";
			if(list.get(i).getState()==0)
			{
				state="δ����";
			}
			else if(list.get(i).getState()==1)
			{
				state="�Ѵ���";
			}
			data[i][4]=state;
			
//			data[i][4]=list.get(i).getState();
			data[i][5]=list.get(i).getDealtime();
			data[i][6]=list.get(i).getEmployeeid();
		}
		columnNames=new String[]{"����id","ҵ��id","��������","����ʱ��","״̬","����ʱ��","ָ��Ա��id"};
		tableModel=new DefaultTableModel(data,columnNames)
		{
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		//ʵ�������
		tab=new JTable(tableModel);
		//ʵ�����������
		pane=new JScrollPane(tab);
		this.add(pane);
		this.setVisible(true);
	}
}
