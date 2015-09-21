package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.FeeRecordDao;
import com.niit.dao.impl.HouseDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.FeeRecord;
import com.niit.entity.House;
import com.niit.entity.Users;

public class Fee extends JFrame
{
	private Users users;
//	private UserMain userMain;
	private Fee fee;
	private FeeRecordDao feeRecordDao;
	private HouseDao houseDao;
	private UsersDao usersDao;
	
									   //ÿƽ����ҵ��
	private JLabel feeLabel,houseLabel,priceLabel;
	private JTextField feeTextField;
	private JButton submitBtn;
	
	//�����б��
	private JComboBox box;
	//ģ��
	private DefaultComboBoxModel boxModel;
	public Fee(String identity)
	{
		usersDao=new UsersDao();
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		fee=this;
		feeRecordDao=new FeeRecordDao();
		houseDao=new HouseDao();
		this.setBounds(300, 200, 300,250);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�ɷ�:"+users.getUsername());
		this.setLayout(null);
		
		houseLabel=new JLabel("��Ҫ�ɷѵķ��ݣ�");
		houseLabel.setBounds(20, 20, 150, 20);
		feeLabel=new JLabel("����ǰӦ�ɷѵ������");
		feeLabel.setBounds(20, 60, 200, 20);
		
		//��ȡ��ǰ�û��ķ��ӣ����ܷ��ض��ֵ
		ArrayList<House> list=houseDao.findHouseByIdentity(users.getIdentity());
		
		int size=list.size();
		//������������ʱ��һ��Ҫȷ������ĳ��ȣ�����ᷢ������Խ�����
		String[] values;
		values=new String[size];
		for(int i=0;i<size;i++)
		{
			values[i]=list.get(i).getHouseid()+"";
		}
		
		boxModel=new DefaultComboBoxModel(values);
		box=new JComboBox(boxModel);
		box.setBounds(150, 20, 80, 20);
		
//		System.out.println(box.getSelectedItem());
		
		//��ȡѡ�еķ���
		House house=houseDao.findHouseByHouseid(Integer.parseInt( box.getSelectedItem().toString()));
		//��ȡ���ӵ����
		double area=house.getArea();

		
		feeTextField=new JTextField(20);
		feeTextField.setText(area+"");
		feeTextField.setEditable(false);
		feeTextField.setBounds(150, 60, 50, 20);
		priceLabel=new JLabel("ƽ��*1.5Ԫ/ƽ��");
		priceLabel.setBounds(200, 60, 100, 20);
		submitBtn=new JButton("ȷ�Ͻɷ�");
		submitBtn.setBounds(100, 100, 100, 20);
		
		//������
		submitBtn.addActionListener(new MyBtnListener());
		box.addItemListener(new MyItemListener());
		this.add(box);
		this.add(submitBtn);
		this.add(feeTextField);
		this.add(feeLabel);
		this.add(priceLabel);
		this.add(houseLabel);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton btn=(JButton)e.getSource();
			usersDao=new UsersDao();
			if(btn==submitBtn)
			{
				//���ӵ����
				double myarea=Double.parseDouble(feeTextField.getText());
				//������Լ۸��ݶ�1.5Ԫÿƽ����
				//��ҵ��
				int money=(int)(myarea*1.5);
				if((users.getBalance()>money)&&(users.getBalance()>0))
				{
					FeeRecord feeRecord=new FeeRecord();
					feeRecord.setIdentity(users.getIdentity());
					feeRecord.setFee(money);
					//״̬д��0��ʾδ����
					feeRecord.setPass(0);
					//�ɷ�ʱ��д�뵱ǰϵͳʱ��
					feeRecord.setFeetime(new Timestamp(new Date().getTime()));
					//����ʱ��д��null
					feeRecord.setExamtime(null);
					
					boolean flag=feeRecordDao.addFeeRecord(feeRecord);
					JOptionPane.showMessageDialog(null, flag?"�ɷѳɹ�":"�ɷ�ʧ��");
					
					//�ɷѳɹ���Ҫ�۳�ҵ����Ӧ�ķ���
					if(flag)
					{
						//�޸�ҵ����balance��Ϣ
						Users user=new Users();
						user.setIdentity(users.getIdentity());
						user.setUsername(users.getUsername());
						user.setPwd(users.getPwd());
						user.setPhone(users.getPhone());
						user.setBalance(users.getBalance()-money);//�۵�Ӧ�ɵķ���
						//�޸Ĳ���
						usersDao.modifyUsers(user);
						
					}
					fee.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "���㣬���ֵ");
				}
				
				
				
			}
			
		}
		
	}
	
	public class MyItemListener implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent e)
		{
			if(e.getStateChange()==ItemEvent.SELECTED)
			{
				int num=box.getSelectedIndex();
			
				House house=houseDao.findHouseByHouseid(Integer.parseInt( box.getSelectedItem().toString()));
				//��ȡ���ӵ����
				double area=house.getArea();
				//��textfile��������
				feeTextField.setText(area+"");
			}
			
		}
		
	}
	
	
	
	
	
}
