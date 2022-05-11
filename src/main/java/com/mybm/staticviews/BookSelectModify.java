package com.mybm.staticviews;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookSelectModify extends JFrame {
	private JPanel panel,selectConditionPane,btnPanel,
			centerPanel,selectResultPanel,bookPanel;
	private JComboBox<String> cmbChoice,cmbType;
	private JLabel labISBN,labType,labName,labAuthor,labPublish,labPublishDate,labPrice;
	private JTextField txtSelect,txtISBN,txtName,txtAuthor,txtPublish,txtPublishDate,txtPrice;
	private JButton btnSelect,btnModify,btnDelect,btnExit;
	private JTable table;
	private JScrollPane scrollPane;

	public BookSelectModify() {
		setTitle("图书查询和修改");
		setSize(700, 500);
		setLocationRelativeTo(null);
		panel=new JPanel(new BorderLayout());
		setContentPane(panel);

		selectConditionPane=new JPanel();
		cmbChoice=new JComboBox<>();
		cmbChoice.addItem("全部");
		cmbChoice.addItem("书名");
		txtSelect=new JTextField(20);
		selectConditionPane.add(cmbChoice);
		selectConditionPane.add(txtSelect);
		panel.add(selectConditionPane,BorderLayout.NORTH);

		centerPanel=new JPanel();
		selectResultPanel=new JPanel();
		table=new JTable();
		scrollPane=new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600,200));
		selectResultPanel.add(scrollPane);
		bookPanel=new JPanel(new GridLayout(4,4));
		labISBN=new JLabel("ISBN");
		txtISBN=new JTextField(15);
		labType=new JLabel("图书类型");
		cmbType=new JComboBox<>();
		cmbType.addItem("计算机类");
		cmbType.addItem("管理类");
		labName=new JLabel("名字");
		txtName=new JTextField(15);
		labAuthor=new JLabel("作者名");
		txtAuthor=new JTextField(15);
		labPublish=new JLabel("出版社");
		txtPublish=new JTextField(15);
		labPublishDate=new JLabel("出版社日期");
		txtPublishDate=new JTextField(15);
		labPrice=new JLabel("价格");
		txtPrice=new JTextField(15);
		bookPanel.add(labISBN);
		bookPanel.add(txtISBN);
		bookPanel.add(labType);
		bookPanel.add(cmbType);
		bookPanel.add(labName);
		bookPanel.add(txtName);
		bookPanel.add(labAuthor);
		bookPanel.add(txtAuthor);
		bookPanel.add(labPublish);
		bookPanel.add(txtPublish);
		bookPanel.add(labPublishDate);
		bookPanel.add(txtPublishDate);
		bookPanel.add(labPrice);
		bookPanel.add(txtPrice);
		centerPanel.add(selectResultPanel);
		centerPanel.add(bookPanel);
		panel.add(centerPanel,BorderLayout.CENTER);

		btnPanel=new JPanel();
		btnSelect=new JButton("查询");
		btnModify=new JButton("修改");
		btnDelect=new JButton("删除");
		btnExit=new JButton("退出");

		btnPanel.add(btnSelect);
		btnPanel.add(btnModify);
		btnPanel.add(btnDelect);
		btnPanel.add(btnExit);
		panel.add(btnPanel,BorderLayout.SOUTH);

		setVisible(true);
	}


}
