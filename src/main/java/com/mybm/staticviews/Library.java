package com.mybm.staticviews;

import javax.swing.*;

public class Library extends JFrame {
	private JMenuBar bar;
	private JMenu menuBook;
	private JMenuItem itemBookAdd,itemBookSelect;
	public Library(String s)
	{
		super(s);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,800);
		setLocationRelativeTo(null);
		bar=new JMenuBar();
		setJMenuBar(bar);
		menuBook=new JMenu("ͼ����Ϣ����");
		itemBookAdd=new JMenuItem("ͼ������");
		itemBookSelect=new JMenuItem("ͼ���ѯ���޸�");
		menuBook.add(itemBookAdd);
		menuBook.add(itemBookSelect);
		bar.add(menuBook);
		setVisible(true);			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Library("ͼ�����ϵͳ");
	}
}
