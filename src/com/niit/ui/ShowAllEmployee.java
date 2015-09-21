package com.niit.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.EmployeeDao;
import com.niit.entity.Employee;

public class ShowAllEmployee extends JFrame
{
	private EmployeeDao employeeDao;
	//�����б��
	private JComboBox jobBox;
	//ģ��
	private DefaultComboBoxModel jobBoxModel;
	//btn
	private JButton  jobBtn,addEmployeeBtn;
	
	//���
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//�������
	private JScrollPane pane,testPane;
	//���ģ��
	private DefaultTableModel tableModel;
	//�Ҽ���ݲ˵�
	private JPopupMenu pop;
	private JMenuItem deleteItem,modifyItem;
	
	private JPanel pnl;
	
	ArrayList<Employee> list;
	public ShowAllEmployee()
	{
		employeeDao=new EmployeeDao();
		this.setBounds(300, 200, 800, 500);
		this.setTitle("Ա����Ϣ");
//		this.setLayout(null);
		
		String[] values={"��ѯ����Ա��","ˮ","��","ú","����"};
		jobBoxModel=new DefaultComboBoxModel(values);
		jobBox=new JComboBox(jobBoxModel);
		jobBox.setBounds(20, 20, 120, 20);
		
		jobBtn=new JButton("���ݹ������Ͳ���");
		jobBtn.setBounds(150, 20, 185, 20);
		addEmployeeBtn=new JButton("����Ա��");
		addEmployeeBtn.setBounds(550, 20, 120, 20);
		
		columnNames=new String[]{"Ա��id","Ա������","����","�绰"};
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
		pane.setBounds(0, 50, 800, 500);
		
		pnl=new JPanel();
		pnl.add(jobBox);
		pnl.add(jobBtn);
		pnl.add(addEmployeeBtn);
		
		
		
		
		
		
		
		
		
		//�Ҽ���ݲ˵�
		pop=new JPopupMenu();
		deleteItem=new JMenuItem("ɾ��");
		modifyItem=new JMenuItem("�޸�");
		pop.add(deleteItem);
		pop.add(modifyItem);
		tab.setComponentPopupMenu(pop);
		
		
		
		jobBtn.addActionListener(new MyBtnListener());
		addEmployeeBtn.addActionListener(new MyBtnListener());
		deleteItem.addActionListener(new MyItmListener());
		modifyItem.addActionListener(new MyItmListener());
		this.add(pane,BorderLayout.CENTER);
		this.add(pnl,BorderLayout.NORTH);
//		this.add(addEmployeeBtn);
//		this.add(jobBtn);
//		this.add(jobBox);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
//			employeeDao=new EmployeeDao();
			if(btn==jobBtn)
			{
				//���ݹ������ͳ���Ա��
				String select=jobBox.getSelectedItem().toString();
				if(select.equals("��ѯ����Ա��"))
				{
					list=employeeDao.findAllEmployee();
				}
				else if(select.equals("ˮ"))
				{
					list=employeeDao.findEmployeeByJob("ˮ");
				}
				else if(select.equals("��"))
				{
					list=employeeDao.findEmployeeByJob("��");
				}
				else if(select.equals("ú"))
				{
					list=employeeDao.findEmployeeByJob("ú");
				}
				else if(select.equals("����"))
				{
					list=employeeDao.findEmployeeByJob("����");
				}
				int num=list.size();
				data=new Object[num][4];
				for(int i=0;i<num;i++)
				{
					data[i][0]=list.get(i).getEmployeeid();
					data[i][1]=list.get(i).getEmployeename();
					data[i][2]=list.get(i).getJob();
					data[i][3]=list.get(i).getPhone();
				}
				tableModel.setDataVector(data, columnNames);
			}
			else if(btn==addEmployeeBtn)
			{
				//����Ա����ʱ��
				new AddNewEmployee();
			}
			
		}
		
	}
	
	public class MyItmListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AbstractButton itm=(AbstractButton)e.getSource();
			employeeDao=new EmployeeDao();
			//��ȡѡ�е�Ա��id������idɾ����Ա��
			int row=tab.getSelectedRow();
			Employee employee=list.get(row);
			int employeeId=employee.getEmployeeid();
			if(itm==deleteItem)
			{
				boolean flag=employeeDao.deleteEmployee(employeeId);
				JOptionPane.showMessageDialog(null, flag?"ɾ��Ա���ɹ�":"ɾ��Ա��ʧ��");
			}
			else if(itm==modifyItem)
			{
				new ModifyEmployee(employeeId);
			}
				
			
		}
		
	}
	
	
	
	
}
