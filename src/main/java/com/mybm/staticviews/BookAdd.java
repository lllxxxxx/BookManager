package com.mybm.staticviews;

import com.mybm.dao.BookDAO;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class BookAdd extends JFrame {
	private JPanel panel,bookPanel,btnPanel;
	private JLabel labISBN,labType,labName,labAuthor,
	labPublish,labPublishDate,labPrice;
	private JTextField[] field;
	JComboBox<String> cmbBookType;
	private JButton btnAdd,btnReset,btnExit;
	public BookAdd(String s)
	{
		super(s);
		field=new JTextField[6];
		for (int i = 0; i < field.length; i++) {
			field[i]=new JTextField(12);
		}
		setSize(400,200);
		setLocationRelativeTo(null);
		panel=new JPanel(new BorderLayout());
		setContentPane(panel);
		GridLayout grid1=new GridLayout(4,4);
		grid1.setHgap(5);
		grid1.setVgap(5);
		bookPanel=new JPanel(grid1);
		labISBN=new JLabel("ISBN:");
		labISBN.setHorizontalAlignment(SwingConstants.CENTER);

		labType=new JLabel("图书类型");
		cmbBookType=new JComboBox<>();
		cmbBookType.addItem("计算机类");
		cmbBookType.addItem("what");
		labName=new JLabel("书名");
		labAuthor=new JLabel("作者");
		labPublish=new JLabel("出版社");
		labPublishDate=new JLabel("出版日期");
		labPrice=new JLabel("价格");


		bookPanel.add(labISBN);
		bookPanel.add(field[0]);
		bookPanel.add(labType);
		bookPanel.add(cmbBookType);
		bookPanel.add(labName);
		bookPanel.add(field[1]);
		bookPanel.add(labAuthor);
		bookPanel.add(field[2]);
		bookPanel.add(labPublish);
		bookPanel.add(field[3]);
		bookPanel.add(labPublishDate);
		bookPanel.add(field[4]);
		bookPanel.add(labPrice);
		bookPanel.add(field[5]);

		panel.add(bookPanel,BorderLayout.CENTER);
		btnPanel=new JPanel();
		btnAdd=new JButton("增加");
		btnReset=new JButton("重置");
		btnExit=new JButton("退出");
		btnPanel.add(btnAdd);
		btnPanel.add(btnReset);
		btnPanel.add(btnExit);
		btnReset.addActionListener(e -> {
			String[] s1=new String[6];
			for (int i = 0; i < 6; i++) {
				s1[i]=field[i].getText();
			}
			String com= (String) cmbBookType.getSelectedItem();
			Boolean is=false;
			try {
				is=BookDAO.AddBook(s1,com);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			if(is){
				JOptionPane.showMessageDialog(null,"succ");
			}else {
				JOptionPane.showMessageDialog(null,"error");
			}
		});
		btnExit.addActionListener(e -> {
			this.dispose();
		});
		btnReset.addActionListener(e -> {
			for(JTextField f:field){
				f.setText("");
			}
		});
		panel.add(btnPanel,BorderLayout.SOUTH);
		
		setVisible(true);		
	}


}
