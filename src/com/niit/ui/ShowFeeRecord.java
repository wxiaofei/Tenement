package com.niit.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

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

import com.niit.dao.impl.FeeRecordDao;
import com.niit.entity.FeeRecord;

public class ShowFeeRecord extends JFrame
{
	private FeeRecordDao feeRecordDao;
	
	
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
	//�ı���
	private JTextField identityTextField;
	//�Ҽ���ݲ˵�
	private JPopupMenu pop;
	private JMenuItem yesItem;
	
	//
	private JPanel pnl;
	
	private ArrayList<FeeRecord> list;
	
	public ShowFeeRecord()
	{
		feeRecordDao=new FeeRecordDao();
		this.setBounds(300, 200, 800, 500);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�ɷѼ�¼");
//		this.setLayout(null);
		
		String[] values={"���нɷѼ�¼","��ͨ�����","δͨ�����"};
		passBoxModel=new DefaultComboBoxModel(values);
		passBox=new JComboBox(passBoxModel);
//		passBox.setBounds(20, 20, 120, 20);
		
		identityTextField=new JTextField(20);
//		identityTextField.setBounds(450, 20, 100, 20);
		
		passBtn=new JButton("�������״̬����");
//		passBtn.setBounds(150, 20, 185, 20);
		identityBtn=new JButton("����ҵ��id����");
//		identityBtn.setBounds(560, 20, 185, 20);
		columnNames=new String[]{"�ɷ�id","ҵ��id","�ɷѽ��","�Ƿ�ͨ��","�ɷ�ʱ��","���ʱ��"};
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
		yesItem=new JMenuItem("ͨ��");
		pop.add(yesItem);
		tab.setComponentPopupMenu(pop);
		
		
		
		identityBtn.addActionListener(new MyBtnListener());
		passBtn.addActionListener(new MyBtnListener());
		tab.addMouseListener(new MyMouseListener());
		yesItem.addActionListener(new MyItemListener());
		
		
		this.add(pane,BorderLayout.CENTER);
//		this.add(pane,BorderLayout.SOUTH);
//		this.getContentPane().add(pane);
		
//		this.add(identityTextField);
//		this.add(identityBtn);
//		this.add(passBtn);
//		this.add(passBox);
		this.add(pnl,BorderLayout.NORTH);
		
		
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
//			feeRecordDao=new FeeRecordDao();
			if(btn==passBtn)
			{
				int pass=0;
				String select=passBox.getSelectedItem().toString();
				if(select.equals("��ͨ�����"))
				{
					pass=1;
					list=feeRecordDao.findFeeRecordByPass(pass);
					
				}
				else if(select.equals("δͨ�����"))
				{
					pass=0;
					list=feeRecordDao.findFeeRecordByPass(pass);
				}
				else if(select.equals("���нɷѼ�¼"))
				{
					list=feeRecordDao.findAllFeeRecord();
					
				}
				
				
			}
			else if(btn==identityBtn)
			{
				String identity=identityTextField.getText();
				list=feeRecordDao.findFeeRecordByIdentity(identity);
			}
		
			
			
			int num=list.size();
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
				
				
//				data[i][3]=list.get(i).getPass();
				data[i][4]=list.get(i).getFeetime();
				data[i][5]=list.get(i).getExamtime();
			}
			tableModel.setDataVector(data, columnNames);
			
			
			
		}
		
	}
	
	//���˫��ʱ�ļ�����
	public class MyMouseListener implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			int count=e.getClickCount();
			if(count==2)
			{
				int row=tab.getSelectedRow();
				FeeRecord feeRecord=list.get(row);
				JOptionPane.showMessageDialog(null, feeRecord.getFeeid());
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	
	
	
	
	//�Ҽ���ݵļ�����
	public class MyItemListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			AbstractButton itm=(AbstractButton)e.getSource();
			feeRecordDao=new FeeRecordDao();
			
			
			if(itm==yesItem)
			{
				//ͨ�����޸ĽɷѼ�¼���passΪ1
				
				//���ѡ�еĽɷѼ�¼ ��feeid
				//����д��
//				int row=tab.getSelectedRow();
//				ArrayList<FeeRecord> list=feeRecordDao.findAllFeeRecord();
//				int id=list.get(row).getFeeid();
				
				//��ȷд��
				int row=tab.getSelectedRow();
				FeeRecord feeRecord=list.get(row);
				int feeid=feeRecord.getFeeid();

				FeeRecord feeRecord1=feeRecordDao.findFeeRecordByFeeid(feeid);
				FeeRecord feeRecord2=new FeeRecord();//newһ���޸�֮���feerecord
				feeRecord2.setFeeid(feeRecord1.getFeeid());
				feeRecord2.setIdentity(feeRecord1.getIdentity());
				feeRecord2.setFee(feeRecord1.getFee());
				feeRecord2.setPass(1);
				feeRecord2.setFeetime(feeRecord1.getFeetime());
				feeRecord2.setExamtime(new Timestamp(new Date().getTime()));
				
				boolean flag=feeRecordDao.modifyFeeRecord(feeRecord2);
				JOptionPane.showMessageDialog(null, flag?"�޸ĽɷѼ�¼�ɹ�":"�޸ĽɷѼ�¼ʧ��");
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args)
//	{
//		new ShowFeeRecord();
//	}
}
