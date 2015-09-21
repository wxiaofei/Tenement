package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.EmployeeDao;
import com.niit.dao.impl.RepairRecordDao;
import com.niit.entity.Employee;
import com.niit.entity.RepairRecord;

public class ShowEmployeeByJob extends JFrame
{
	private EmployeeDao employeeDao;
	private RepairRecordDao repairRecordDao;
	//���մ�������repairid��job
	private int repairId=0;
	private String job="";
	//���
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//�������
	private JScrollPane pane;
	//���ģ��
	private DefaultTableModel tableModel;
	//�Ҽ���ݷ�ʽ
	private JPopupMenu pop;
	private JMenuItem sendItem;
	
	
	ArrayList<Employee> list;
	
	public ShowEmployeeByJob(int repairId,String job)
	{
		this.repairId=repairId;
		this.job=job;
		this.setBounds(300, 200, 800, 500);
		this.setTitle("Ա����Ϣ");
		employeeDao=new EmployeeDao();
		list=employeeDao.findEmployeeByJob(job);
		int num=list.size();//�ҵ�����Ա��
		data=new Object[num][4];
		for(int i=0;i<num;i++)
		{
			data[i][0]=list.get(i).getEmployeeid();
			data[i][1]=list.get(i).getEmployeename();
			data[i][2]=list.get(i).getJob();
			data[i][3]=list.get(i).getPhone();
		}
		columnNames=new String[]{"Ա��id","Ա������","��������","�绰"};
		tableModel=new DefaultTableModel(data,columnNames)
		{
			//����ģ�͵�ʱ����дһ������
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		tab=new JTable(tableModel);
		pane=new JScrollPane(tab);
		
		//�Ҽ���ݲ˵�
		pop=new JPopupMenu();
		sendItem=new JMenuItem("ָ��");
		pop.add(sendItem);
		tab.setComponentPopupMenu(pop);
		
		
		
		
		sendItem.addActionListener(new MyItmListener());
		
		this.add(pane);
		this.setVisible(true);
	}
	//�Ҽ���ݲ˵��ļ�����
	public class MyItmListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AbstractButton itm=(AbstractButton)e.getSource();
			repairRecordDao=new RepairRecordDao();
			if(itm==sendItem)
			{
				//��ȡ��ǰѡ�е�Ա��
				int row=tab.getSelectedRow();
				Employee employee=list.get(row);
				int employeeId=employee.getEmployeeid();
				//�޸ı��޼�¼���е�����
				RepairRecord repairRecord1=repairRecordDao.findRepairRecordByRepairid(repairId);
				RepairRecord repairRecord=new RepairRecord();
				repairRecord.setRepairid(repairRecord1.getRepairid());
				repairRecord.setIdentity(repairRecord1.getIdentity());
				repairRecord.setRepairdetail(repairRecord1.getRepairdetail());
				repairRecord.setRepairtime(repairRecord1.getRepairtime());
				repairRecord.setState(1);
				repairRecord.setDealtime(new Timestamp(new Date().getTime()));
				repairRecord.setEmployeeid(employeeId);
				
				boolean flag=repairRecordDao.modifyRepairRecord(repairRecord);
				JOptionPane.showMessageDialog(null, flag?"ָ�ɳɹ�":"ָ��ʧ��");
				
			}
		}
		
	}
}
