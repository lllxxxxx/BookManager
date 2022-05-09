package com.mybm.staticviews;

import com.mybm.dao.UserDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
	private JPanel myPanel;
	private JLabel labName,labPassword;
	private JTextField txtName;
	private JPasswordField txtPassword;
	private JButton btnConfirm,btnReset;

	public Login(String name)
	{
		super(name);//框架类设标题
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(200,300);
		setLocationRelativeTo(null);
		myPanel=new JPanel();
		setContentPane(myPanel);
		labName=new JLabel("用户名：");
		labPassword=new JLabel("密  码：");
		txtName=new JTextField(12);
		txtPassword=new JPasswordField(12);
		txtPassword.setEchoChar('*');
		btnConfirm=new JButton("登录");
		btnReset=new JButton("重置");
		btnConfirm.addActionListener(this);
		btnReset.addActionListener(this);
		myPanel.add(labName);
		myPanel.add(txtName);
		myPanel.add(labPassword);
		myPanel.add(txtPassword);
		myPanel.add(btnConfirm);
		myPanel.add(btnReset);
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnConfirm){
			String  password = String.valueOf(txtPassword.getPassword());

			String name=txtName.getText();
			Boolean is=false;
			try {
				is= UserDAO.login(name,password);
				if(is==true){
					Library library=new Library("管理");
				}else{
					JOptionPane.showMessageDialog(null,"error");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}
}