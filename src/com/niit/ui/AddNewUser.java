package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.UsersDao;
import com.niit.entity.Users;

public class AddNewUser extends JFrame
{
	private AddNewUser addNewUser;
	
	private UsersDao usersDao;
	
	private JLabel identityLabel,usernameLabel,pwdLabel,phoneLabel,balanceLabel;
	private JTextField identityTextField,userNameTextField,pwdTextField,phoneTextField,balanceTextField;
	private JButton submitBtn;
	public AddNewUser()
	{
		addNewUser=this;
		this.setBounds(500, 200, 300, 300);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("������ҵ��");
		this.setLayout(null);
		
		identityLabel=new JLabel("���֤��");
		identityLabel.setBounds(20, 20, 60, 20);
		usernameLabel=new JLabel("������");
		usernameLabel.setBounds(30, 50, 50, 20);
		pwdLabel=new JLabel("���룺");
		pwdLabel.setBounds(30, 80, 50, 20);
		phoneLabel=new JLabel("�绰��");
		phoneLabel.setBounds(30, 110, 50, 20);
		balanceLabel=new JLabel("��");
		balanceLabel.setBounds(30, 140, 50, 20);
		
		identityTextField=new JTextField(20);
		identityTextField.setBounds(80, 20, 150, 20);
		userNameTextField=new JTextField(20);
		userNameTextField.setBounds(80, 50, 150, 20);
		pwdTextField=new JTextField(20);
		pwdTextField.setBounds(80, 80, 150, 20);
		phoneTextField=new JTextField(20);
		phoneTextField.setBounds(80, 110, 150, 20);
		balanceTextField=new JTextField(20);
		balanceTextField.setBounds(80, 140, 150, 20);
		
		submitBtn=new JButton("�ύ");
		submitBtn.setBounds(100, 180, 85, 20);
		
		submitBtn.addActionListener(new MyBtnListener());
		this.add(submitBtn);
		this.add(balanceTextField);
		this.add(phoneTextField);
		this.add(pwdTextField);
		this.add(userNameTextField);
		this.add(identityTextField);
		this.add(balanceLabel);
		this.add(phoneLabel);
		this.add(pwdLabel);
		this.add(usernameLabel);
		this.add(identityLabel);
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
				Users user=new Users();
				user.setIdentity(identityTextField.getText());
				user.setUsername(userNameTextField.getText());
				user.setPwd(pwdTextField.getText());
				user.setPhone(phoneTextField.getText());
				user.setBalance(Integer.parseInt(balanceTextField.getText()));
				boolean flag=usersDao.addUsers(user);
				if(flag)
				{
					int result=JOptionPane.showConfirmDialog(null, "����ҵ���ɹ����������Ӹ�ҵ���ķ�����Ϣ", "�ɹ�", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					switch (result)
					{
					case JOptionPane.OK_OPTION:
						//��,��ӷ��ݣ���ҵ����identity����ȥ
						new AddNewHouse(user.getIdentity());
						addNewUser.dispose();
						break;
					case JOptionPane.NO_OPTION://��
						//û��ѡ����Ӹ�ҵ���ķ�����Ϣ��Ӧ��ɾ����ҵ��
						boolean delflag=usersDao.deleteUsers(user.getIdentity());
						if(delflag) JOptionPane.showMessageDialog(null, "��û����ӷ��ݣ���ҵ����ɾ��");
						break;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "������ҵ��ʧ��");
				}
			}
		}
		
	}
	
	
}
