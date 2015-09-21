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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.niit.dao.impl.RepairRecordDao;
import com.niit.entity.RepairRecord;

public class ShowRepairRecord extends JFrame
{
	private RepairRecordDao repairRecordDao;
	//�����б��
	private JComboBox passBox;
	//ģ��
	private DefaultComboBoxModel passBoxModel;
	
	private JButton passBtn,identityBtn;
	
	//���
	private JTable tab;
	Object[][] data;
	String[] columnNames;
	//�������
	private JScrollPane pane;
	//���ģ��
	private DefaultTableModel tableModel;
	private JPanel pnl;
	private JTextField identityTextField;
	private ArrayList<RepairRecord> list;
	
	//�Ҽ���ݲ˵�
	private JPopupMenu pop;
	private JMenuItem waterItem,eleItem,gasItem,otherItem;
	
	public ShowRepairRecord()
	{
		this.setBounds(300, 200, 800, 500);
		this.setTitle("���޼�¼");
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setLayout(null);
		
		String[] values={"���б��޼�¼","�Ѵ���","δ����"};
		passBoxModel=new DefaultComboBoxModel(values);
		passBox=new JComboBox(passBoxModel);
//		passBox.setBounds(20, 20, 120, 20);
		
		identityTextField=new JTextField(20);
//		identityTextField.setBounds(450, 20, 100, 20);
		
		passBtn=new JButton("���ݴ���״̬����");
//		passBtn.setBounds(150, 20, 185, 20);
		identityBtn=new JButton("����ҵ��id����");
//		identityBtn.setBounds(560, 20, 185, 20);
		
		columnNames=new String[]{"����id","ҵ��id","��������","����ʱ��","״̬","����ʱ��","ָ��Ա��id"};
		tableModel=new DefaultTableModel(data,columnNames)
		{
			//����ģ�͵�ʱ����дһ������
			public boolean isCellEditable(int row, int column)
			{
				return false;
			}
		};
		
		tab=new JTable(tableModel);
		tab.getTableHeader().setReorderingAllowed(false);
		pane=new JScrollPane(tab);
//		pane.setBounds(0, 50, 800, 450);
		
		pnl=new JPanel();
		pnl.add(passBox);
		pnl.add(passBtn);
		pnl.add(identityTextField);
		pnl.add(identityBtn);
		
		
		
		//�Ҽ���ݲ˵�
		pop=new JPopupMenu();
		waterItem=new JMenuItem("ˮ");
		eleItem=new JMenuItem("��");
		gasItem=new JMenuItem("ú");
		otherItem=new JMenuItem("����");
		pop.add(waterItem);
		pop.add(eleItem);
		pop.add(gasItem);
		pop.add(otherItem);
		tab.setComponentPopupMenu(pop);
		
		
		
		passBtn.addActionListener(new MyBtnListener());
		identityBtn.addActionListener(new MyBtnListener());
		waterItem.addActionListener(new MyItemListener());
		eleItem.addActionListener(new MyItemListener());
		gasItem.addActionListener(new MyItemListener());
		otherItem.addActionListener(new MyItemListener());
		
		this.add(pane,BorderLayout.CENTER);
		this.add(pnl,BorderLayout.NORTH);
//		this.add(identityBtn);
//		this.add(identityTextField);
//		this.add(passBtn);
//		this.add(passBox);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
			repairRecordDao=new RepairRecordDao();
			if(btn==passBtn)
			{
				int pass=0;
				String select=passBox.getSelectedItem().toString();
				if(select.equals("�Ѵ���"))
				{
					pass=1;
					list=repairRecordDao.findRepairRecordByState(pass);
				}
				else if(select.equals("δ����"))
				{
					pass=0;
					list=repairRecordDao.findRepairRecordByState(pass);
				}
				else if(select.equals("���б��޼�¼"))
				{
					list=repairRecordDao.findAllRepairRecord();
				}
				
				
			}
			else if(btn==identityBtn)
			{
				String identity=identityTextField.getText();
				list=repairRecordDao.findRepairRecordByIdentity(identity);
			}
			int num=list.size();
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
//				data[i][4]=list.get(i).getState();
				data[i][5]=list.get(i).getDealtime();
				data[i][6]=list.get(i).getEmployeeid();
			}
			tableModel.setDataVector(data, columnNames);	
			
			
		}
		
	}
	
	//�Ҽ���ݷ�ʽ�ļ�����
	public class MyItemListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AbstractButton itm=(AbstractButton)e.getSource();
			
			
			//��ȡѡ�еı���id����������޸�
			int row=tab.getSelectedRow();
			RepairRecord repairRecord=list.get(row);
			int repairId=repairRecord.getRepairid();
			
			if(itm==waterItem)
			{
				new ShowEmployeeByJob(repairId,"ˮ");
			}
			else if(itm==eleItem)
			{
				new ShowEmployeeByJob(repairId,"��");
			}
			else if(itm==gasItem)
			{
				new ShowEmployeeByJob(repairId,"ú");
			}
			else if(itm==otherItem)
			{
				new ShowEmployeeByJob(repairId,"����");
			}
		}
		
	}
//	public static void main(String[] args)
//	{
//		new ShowRepairRecord();
//	}
}
