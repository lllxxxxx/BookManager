package com.mybm.staticviews;

/**
 * @author: lllxxx
 * @date: 5.11
 */

import com.mybm.staticviews.ldbw.BookRT;
import com.mybm.staticviews.ldbw.BowBook;
import com.mybm.staticviews.redaermanager.BookCate;
import com.mybm.staticviews.redaermanager.ReadCate;
import com.mybm.staticviews.redaermanager.ReaderAdd;
import com.mybm.staticviews.redaermanager.SelectAndUpadte;
import com.mybm.staticviews.user.AddUser;
import com.mybm.staticviews.user.DeleteUser;
import com.mybm.staticviews.user.ModPsw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Library extends JFrame implements ActionListener {
	private JMenuBar bar;
	private JMenu menuBook;
	private JMenuItem[] jMenuItems;
	public Library(String s)
	{
		super(s);
		String[] sl=new String[]{"删除用户","添加用户","图书类型管理","读者信息查询与修改","读者类型管理","修改密码",
				"读者信息添加","图书借阅","图书归还", "图书增加","图书查询与修改"};
		setSize(1000,800);
		setLocationRelativeTo(null);
		bar=new JMenuBar();
		setJMenuBar(bar);
		menuBook=new JMenu("哈哈哈");
		jMenuItems=new JMenuItem[11];
		for (int i = 0; i < jMenuItems.length; i++) {
			jMenuItems[i]=new JMenuItem(sl[i]);
			menuBook.add(jMenuItems[i]);
			jMenuItems[i].addActionListener(this);
		}
		bar.add(menuBook);

		setVisible(true);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem jMenuItem= (JMenuItem) e.getSource();
		String text = jMenuItem.getText();
		System.out.println(text);
		switch (text){
			case "删除用户":
				new DeleteUser("删除用户");
				break;
			case "添加用户":
				new AddUser("添加用户");
				break;
			case "图书类型管理":
				new BookCate("图书类型管理");
				break;
			case "读者信息查询与修改":
				new SelectAndUpadte("读者信息查询与修改");
				break;
			case "读者类型管理":
				new ReadCate("读者类型管理");
				break;
			case "修改密码":
				new ModPsw("修改密码");
				break;
			case "读者信息添加":
				new ReaderAdd("读者信息添加");
				break;
			case "图书借阅":
				new BowBook("图书借阅");
				break;
			case "图书归还":
				new BookRT("图书归还");
				break;
			case "图书增加":
				new BookAdd("图书增加");
				break;
			case "图书查询与修改":
				new BookSelectModify();
				break;
		}
	}

	public static void main(String[] args) {
		Library library=new Library("");
	}
}
