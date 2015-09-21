package com.niit.ui;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.niit.dao.impl.EmployeeDao;
import com.niit.dao.impl.FeeRecordDao;
import com.niit.dao.impl.HouseDao;
import com.niit.dao.impl.ManagerDao;
import com.niit.dao.impl.RepairRecordDao;
import com.niit.dao.impl.UsersDao;
import com.niit.entity.Manager;
import com.niit.entity.Users;

public class Login extends JFrame
{
//	private String name;
	private Login login;
	private UsersDao usersDao;
	private ManagerDao managerDao;

//	private Users users;
//	private Manager manager;
	
	private JLabel usernameLabel,pwdLabel;
	private JTextField userTextField;
	private JPasswordField pwdPasswordField;
	private JRadioButton userRadioButton,managerRadioButton;
	private ButtonGroup group;
	private JButton submitBtn,cancleBtn;
	public Login()
	{
		login=this;
		usersDao=new UsersDao();
		managerDao=new ManagerDao();

		
		this.setBounds(300, 200, 300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("��½");
		this.setLayout(null);
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Image image=tool.getImage("image//about.jpg");
		this.setIconImage(image);
		
		usernameLabel=new JLabel("�û�����");
		usernameLabel.setBounds(20, 20, 70, 25);
		pwdLabel=new JLabel("���룺");
		pwdLabel.setBounds(20, 50, 70, 25);
		userTextField=new JTextField(20);
		userTextField.setBounds(100, 20, 150, 20);
		pwdPasswordField=new JPasswordField(20);
		pwdPasswordField.setBounds(100, 50, 150, 20);
		userRadioButton=new JRadioButton("ҵ��");
		userRadioButton.setBounds(50, 80, 80, 50);
		managerRadioButton=new JRadioButton("����Ա");
		managerRadioButton.setBounds(150, 80, 80, 50);
		group=new ButtonGroup();
		group.add(userRadioButton);
		group.add(managerRadioButton);
		submitBtn=new JButton("��¼");
		submitBtn.setBounds(50, 150, 85, 20);
		cancleBtn=new JButton("�˳�");
		cancleBtn.setBounds(150, 150, 85, 20);
		
		//��ť������
		submitBtn.addActionListener(new MyBtnListener());
		cancleBtn.addActionListener(new MyBtnListener());
		this.add(cancleBtn);
		this.add(submitBtn);
		this.add(userRadioButton);
		this.add(managerRadioButton);
		this.add(pwdPasswordField);
		this.add(userTextField);
		this.add(pwdLabel);
		this.add(usernameLabel);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();
			String username=userTextField.getText();
			String pwd=pwdPasswordField.getText();
//			name=username;
			if(btn==submitBtn)
			{
				//��½��ť
				if(userRadioButton.isSelected())
				{
					Users users=usersDao.findUsersByUsername(username);
					
					if(users==null)
					{
						JOptionPane.showMessageDialog(null, "ҵ�������ڣ������򷿰ɣ�");
					}
					else
					{
						if(users.getPwd().equals(pwd))
						{
							login.dispose();
							new UserMain(username);
							
						}
						else
						{
							JOptionPane.showMessageDialog(null, "���벻��ȷ");
						}
					}
				}
				else if(managerRadioButton.isSelected())
				{
					Manager manager=managerDao.findManagerByManagername(username);
					if(manager==null)
					{
						JOptionPane.showMessageDialog(null, "����Ա������");
					}
					else
					{
						if(manager.getPwd().equals(pwd))
						{
							login.dispose();
							new ManagerMain(username);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "���벻��ȷ");
						}
					}
				}
			}
			else if(btn==cancleBtn)
			{
				System.exit(0);
			}
		}
		
	}

//	public UsersDao getUsersDao()
//	{
//		return usersDao;
//	}
//
//	public void setUsersDao(UsersDao usersDao)
//	{
//		this.usersDao = usersDao;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public ManagerDao getManagerDao() {
//		return managerDao;
//	}
//
//	public void setManagerDao(ManagerDao managerDao) {
//		this.managerDao = managerDao;
//	}

	
	
	
	
	
}
