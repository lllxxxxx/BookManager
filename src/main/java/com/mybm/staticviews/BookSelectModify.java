package com.mybm.staticviews;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.Border;

public class BookSelectModify extends JFrame {
	private JPanel panel,selectConditionPane,btnPanel,
	centerPanel,selectResultPane,bookPane;
	private JComboBox<String> cmbChoice,cmbType;
	private JTextField txtSelect,txtISBN,txtName,txtAuthor,
	txtPublish,txtPublishDate,txtPrice;
	private JLabel labISBN,labType,labName,labAuthor,
	labPublish,labPublishDate,labPrice;
	private JButton btnSelect,btnModify,btnDelete,btnExit;
	private JTable table;
	private JScrollPane scrollPane;
	
	public BookSelectModify()
	{
		setTitle("ͼ�����");//���ñ���
		setSize(500,500);
		setLocationRelativeTo(null);
		panel=new JPanel(new BorderLayout());
		setContentPane(panel);
		selectConditionPane=new JPanel();
		cmbChoice=new JComboBox<>();
		cmbChoice.addItem("ȫ��");
		cmbChoice.addItem("����");
		txtSelect=new JTextField(20);
		selectConditionPane.add(cmbChoice);
		selectConditionPane.add(txtSelect);
		panel.add(selectConditionPane,BorderLayout.NORTH);
		//�м����
		centerPanel=new JPanel();
		selectResultPane=new JPanel();
		table=new JTable();
		scrollPane=new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400,240));//���С
		selectResultPane.add(scrollPane);
		bookPane=new JPanel(new GridLayout(4,4));
		//4��4�У���Ҫ����ÿ��������ӵ�bookPane�У�����6���κ����
		labISBN=new JLabel("ISBN��");
		labType=new JLabel("ͼ������");
		labName=new JLabel("����");
		labAuthor=new JLabel("����");
		labPublish=new JLabel("������");
		labPublishDate=new JLabel("��������");
		labPrice=new JLabel("�۸�");
		txtISBN=new JTextField(8);
		cmbType=new JComboBox<>();
		cmbType.addItem("�������");
		cmbType.addItem("������");
		txtName=new JTextField(8);
		txtAuthor=new JTextField(8);
		txtPublish=new JTextField(8);
		txtPublishDate=new JTextField(8);
		txtPrice=new JTextField(8);
		bookPane.add(labISBN);		
		bookPane.add(txtISBN);
		bookPane.add(labType);		
		bookPane.add(cmbType);
		bookPane.add(labName);		
		bookPane.add(txtName);
		bookPane.add(labAuthor);		
		bookPane.add(txtAuthor);
		bookPane.add(labPublish);		
		bookPane.add(txtPublish);
		bookPane.add(labPublishDate);		
		bookPane.add(txtPublishDate);
		bookPane.add(labPrice);		
		bookPane.add(txtPrice);
		centerPanel.add(selectResultPane);
		centerPanel.add(bookPane);
		panel.add(centerPanel,BorderLayout.CENTER);
		btnPanel=new JPanel();
		btnSelect=new JButton("��ѯ");
		btnModify=new JButton("�޸�");
		btnDelete=new JButton("ɾ��");
		btnExit=new JButton("�˳�");
		btnPanel.add(btnSelect);
		btnPanel.add(btnModify);
		btnPanel.add(btnDelete);
		btnPanel.add(btnExit);
		panel.add(btnPanel,BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
	}	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BookSelectModify();
	}

}
