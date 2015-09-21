package com.niit.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;

public class AddMoney extends JFrame
{
//	private UserMain userMain;
	private Users users;
//	private String identity;
	private UsersDao usersDao;
	
	private JLabel moneyLabel,errorLabel;
	private JTextField moneyTextField;
	private JButton submitBtn;
	public AddMoney(String identity)
	{
		usersDao=new UsersDao();
//		this.identity=identity;
		this.users=usersDao.findUsersByIdentity(identity);
//		this.userMain=userMain;
		this.setBounds(500, 400, 300, 300);
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("��ֵ:"+users.getUsername());
		this.setLayout(null);
		
		moneyLabel=new JLabel("�������ֵ��");
		moneyLabel.setBounds(20, 20, 130, 20);
		errorLabel=new JLabel("");
		errorLabel.setBounds(150, 40, 100, 20);
		errorLabel.setForeground(Color.red);
		
		
		moneyTextField=new JTextField(20);
		moneyTextField.setBounds(150, 20, 100, 20);
		submitBtn=new JButton("�ύ");
		submitBtn.setBounds(120, 150, 85, 20);
		
		submitBtn.addActionListener(new MyBtnListener());
		moneyTextField.addKeyListener(new MyKeyListener());
		this.add(submitBtn);
		this.add(moneyTextField);
		this.add(errorLabel);
		this.add(moneyLabel);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
//			usersDao=new UsersDao();
//			Users users=usersDao.findUsersByIdentity(identity);
			if(btn==submitBtn)
			{
				if(!errorLabel.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "���벻�����ַ�");
					return;
				}
				
				
//				JOptionPane.showMessageDialog(null, "ԭ��"+users.getBalance()+"�¼�Ǯ��"+moneyTextField.getText());
				
				UsersDao usersDao=new UsersDao();
//				Users user1=usersDao.findUsersByIdentity(users.getIdentity());
				Users user=new Users();
				user.setIdentity(users.getIdentity());
				user.setUsername(users.getUsername());
				user.setPwd(users.getPwd());
				user.setPhone(users.getPhone());
				//��ֵʱԭ����Ǯ�����³��Ǯ�����ʼ򵥵��޸�
				int oldMoney=0;
				try
				{
					oldMoney = users.getBalance();
				} catch (NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(null, "��������");
				}
				int balance=oldMoney+Integer.parseInt(moneyTextField.getText());
				user.setBalance(balance);
				boolean flag=usersDao.modifyUsers(user);
				JOptionPane.showMessageDialog(null, flag?"��ֵ�ɹ�":"��ֵʧ��");
			}
			
		}
	}
	
	/**
	 * �Ƿ��ַ�
	 * @author Administrator
	 *
	 */
	private class MyKeyListener implements KeyListener
	{
		/**
		 * �ɿ���ʱ��
		 * 
		 */
		@Override
		public void keyReleased(KeyEvent e)
		{
			String myTxt=moneyTextField.getText();
			errorLabel.setText("");
			if(myTxt.length()!=0)
			{	
				for(int i=0;i<myTxt.length();i++)
				{
					char ch=myTxt.charAt(i);
					if(!((ch>='0'&&ch<='9')||ch=='.'))
					{
						errorLabel.setText("����Ľ������");
					}
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e)
		{
		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}
	}
	
	
}
