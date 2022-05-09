package com.mybm.staticviews;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Library extends JFrame implements ActionListener {
	private JMenuBar bar;
	private JMenu menuBook;
	private JMenuItem itemBookAdd,itemBookSelect,libdel,readadd,readdelete,borrow,retur;
	public Library(String s)
	{
		super(s);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,800);
		setLocationRelativeTo(null);
		bar=new JMenuBar();
		setJMenuBar(bar);
		menuBook=new JMenu("哈哈哈");
		itemBookAdd=new JMenuItem("图书增加");
		itemBookSelect=new JMenuItem("图书查询");
		libdel=new JMenuItem("图书删除");
		readadd=new JMenuItem("读者增加");
		readdelete=new JMenuItem("读者删除");
		borrow=new JMenuItem("借书");
		retur=new JMenuItem("还书");
		menuBook.add(libdel);
		menuBook.add(readadd);
		menuBook.add(readdelete);
		menuBook.add(borrow);
		menuBook.add(retur);
		menuBook.add(itemBookAdd);
		menuBook.add(itemBookSelect);
		itemBookAdd.addActionListener(this);
		itemBookSelect.addActionListener(this);
		libdel.addActionListener(this);
		readadd.addActionListener(this);
		readdelete.addActionListener(this);
		borrow.addActionListener(this);
		retur.addActionListener(this);
		bar.add(menuBook);

		setVisible(true);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem jMenuItem= (JMenuItem) e.getSource();
		String text = jMenuItem.getText();
		System.out.println(text);
		switch (text){
			case "图书增加":
				BookAdd bookAdd=new BookAdd("图书添加");
				break;
			case "图书查询":
				BookSelectModify bookSelectModify=new BookSelectModify();
		}
	}

	public static void main(String[] args) {
		Library library=new Library("");
	}
}
