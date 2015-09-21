package com.niit.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.niit.dao.impl.ManagerDao;
import com.niit.entity.Manager;

public class UpdateManagerInfo extends JFrame
{
	private ManagerDao managerDao;
	private Manager manager;
	
	private UpdateManagerInfo updateManagerInfo;
	
	private JLabel idLabel,nameLabel,pwdLabel;
	private JTextField idTextField,nameTextField,pwdTextField;
	private JButton submitBtn;
	
	public UpdateManagerInfo(int managerid)
	{
		updateManagerInfo=this;
		managerDao=new ManagerDao();
		this.manager=managerDao.findManagerByManagerid(managerid);
		this.setBounds(500, 400, 300, 300);
		this.setTitle("����Ա�޸���Ϣ:"+manager.getManagername());
		this.setLayout(null);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		idLabel=new JLabel("����Աid");
		idLabel.setBounds(0, 20, 70, 20);
		nameLabel=new JLabel("����");
		nameLabel.setBounds(20, 50, 50, 20);
		pwdLabel=new JLabel("����");
		pwdLabel.setBounds(20, 80, 50, 20);
		
		idTextField=new JTextField(20);
		idTextField.setText(manager.getManagerid()+"");
		idTextField.setEditable(false);
		idTextField.setBounds(80, 20, 150, 20);
		nameTextField=new JTextField(20);
		nameTextField.setText(manager.getManagername());
		nameTextField.setBounds(80, 50, 150, 20);
		pwdTextField=new JTextField(20);
		pwdTextField.setText(manager.getPwd());
		pwdTextField.setBounds(80, 80, 150, 20);
		
		submitBtn=new JButton("�ύ");
		submitBtn.setBounds(100, 120, 85, 20);
		
		//������
		submitBtn.addActionListener(new MyBtnListener());
		this.add(submitBtn);
		this.add(pwdTextField);
		this.add(nameTextField);
		this.add(idTextField);
		this.add(pwdLabel);
		this.add(nameLabel);
		this.add(idLabel);
		this.setVisible(true);
	}
	
	public class MyBtnListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton btn=(JButton)e.getSource();

			if(btn==submitBtn)
			{

				
				Manager manager1=managerDao.findManagerByManagerid(Integer.parseInt(idTextField.getText()));
				Manager manager=new Manager();
				manager.setManagerid(manager1.getManagerid());
				manager.setManagername(nameTextField.getText());
				manager.setPwd(pwdTextField.getText());
				
				boolean flag=managerDao.modifyManager(manager);
				JOptionPane.showMessageDialog(null, flag?"�޸ĳɹ�,�����µ�¼":"�޸�ʧ��");
				updateManagerInfo.dispose();
				new Login();
//				if(manager1.getPwd().equals(pwdTextField.getText()))
//				{
//					//û�и�����
//					System.out.println("�޸ĳɹ�");
//					updateManagerInfo.dispose();
//					
//				}
//				else
//				{
//					//���뷢�����޸�
//					JOptionPane.showMessageDialog(null, "�����޸������룬�����µ�¼");
//					new Login();
//					updateManagerInfo.dispose();
//					
//				}
			}
			
		}
		
	}
}
