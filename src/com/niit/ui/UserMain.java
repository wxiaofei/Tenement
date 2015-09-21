package com.niit.ui;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import com.niit.dao.impl.HouseDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.House;
import com.niit.entity.Users;




public class UserMain extends JFrame
{
	private UsersDao usersDao;
//	private Login login;
	private Users users;
	private UserMain userMain;
	
	
	private JToolBar toolBarUp;
	private JButton myInfoBtn,cancleBtn,myHouseInfoBtn,feeInfoBtn,repairInfoBtn,feeBtn,repairBtn,addmoneyBtn;
	private JPanel pnl;
	
	
	public UserMain(String userName)
	{
		usersDao=new UsersDao();
//		this.login=login;
		userMain=this;
		this.users=usersDao.findUsersByUsername(userName);
//		this.setBounds(200, 100, 800, 500);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ҵ����"+users.getUsername());
//		this.setLayout(null);
		
		toolBarUp=new JToolBar();
//		toolBarUp.setBounds(0, 0, 800, 40);
		myInfoBtn=new JButton("�ҵ���Ϣ");
		myHouseInfoBtn=new JButton("�ҵķ���");
		feeInfoBtn=new JButton("�ҵĽɷ���Ϣ");
		repairInfoBtn=new JButton("�ҵı�����Ϣ");
		feeBtn=new JButton("�ɷ� ");
		repairBtn=new JButton("����");
		addmoneyBtn=new JButton("��ֵ");
		cancleBtn=new JButton("�˳�");
		
		toolBarUp.add(myInfoBtn);
		toolBarUp.add(myHouseInfoBtn);
		toolBarUp.add(feeInfoBtn);
		toolBarUp.add(repairInfoBtn);
		toolBarUp.add(feeBtn);
		toolBarUp.add(repairBtn);
		toolBarUp.add(addmoneyBtn);
		toolBarUp.add(cancleBtn);
		//����toolBar���ɸ���
		toolBarUp.setFloatable(false);
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Image image=tool.getImage("image//user.jpg");
		this.setIconImage(image);
		
		pnl=new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				Image image=Toolkit.getDefaultToolkit().getImage("image//10.jpg");
				g.drawImage(image, 0, 0, userMain.getWidth(),userMain.getHeight(),userMain);
			}
		};
		
		
		
		
		//��Ӽ�����
		myInfoBtn.addActionListener(new MyBtnListener());
		myHouseInfoBtn.addActionListener(new MyBtnListener());
		feeInfoBtn.addActionListener(new MyBtnListener());
		repairInfoBtn.addActionListener(new MyBtnListener());
		feeBtn.addActionListener(new MyBtnListener());
		repairBtn.addActionListener(new MyBtnListener());
		addmoneyBtn.addActionListener(new MyBtnListener());
		cancleBtn.addActionListener(new MyBtnListener());
		
		this.add(pnl,BorderLayout.CENTER);
		this.add(toolBarUp,BorderLayout.NORTH);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
//			users=login.getUsersDao().findUsersByUsername(login.getName());//�õ�����д����ֵ����ǰȫ�ֱ���users
			if(btn==myInfoBtn)
			{
				//�鿴�ҵ���Ϣ
				new ShowMyInfo(users.getIdentity());
			}
			else if(btn==myHouseInfoBtn)
			{
				//�鿴�ҵķ�����Ϣ
				new ShowMyHouseInfo(users.getIdentity());
			}
			else if(btn==feeInfoBtn)
			{
				//�鿴�ҵĽɷ���Ϣ
				new ShowMyFeeRecordInfo(users.getIdentity());
			}
			else if(btn==repairInfoBtn)
			{
				//�鿴�ҵı�����Ϣ
				new ShowMyRepaireRecordInfo(users.getIdentity());
			}
			else if(btn==feeBtn)
			{
				//�ɷѰ�ť
				new Fee(users.getIdentity());
			}
			else if(btn==repairBtn)
			{
				//���ް�ť
				new Repair(users.getIdentity());
			}
			else if(btn==addmoneyBtn)
			{
				//��ֵ��ť
				new AddMoney(users.getIdentity());
			}
			else if(btn==cancleBtn)
			{
				System.exit(0);
			}
		}
		
	}

//	public Users getUsers()
//	{
//		return users;
//	}
//
//	public void setUsers(Users users)
//	{
//		this.users = users;
//	}
	

}
