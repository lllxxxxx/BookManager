package com.mybm.staticviews.redaermanager;

import javax.swing.*;
import java.awt.*;

public class ReadCate {

    public static void rCate(){
        JFrame Jcate=new JFrame("读者类型管理");
        Jcate.setSize(600,730);
        JPanel pTop=new JPanel(null);
        JPanel pBot=new JPanel(null);


        pTop.setBounds(0,0,600,400);
        Jcate.add(pTop);
        pTop.setBackground(Color.yellow);
        SelectAndUpadte.top(pTop,new String[]{"读者类型编号","读者类型名称","可借图书数量","可借图书期限"});


        pBot.setBounds(10,400,600,330);
        Jcate.add(pBot);
        pBot.setBackground(Color.MAGENTA);
        bot(pBot);


        Jcate.setVisible(true);
        Jcate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void bot(JPanel jp){
        JLabel id=new JLabel("读者类型编号:");
        JLabel name=new JLabel("读者类型名称:");
        JLabel count=new JLabel("可借图书数量:");
        JLabel date=new JLabel("可借图书期限:");

        JTextField idTxt=new JTextField();
        JTextField nameTxt=new JTextField();
        JTextField countTxt=new JTextField();
        JTextField dateTxt=new JTextField();

        JButton add=new JButton("添加");
        JButton update=new JButton("修改");
        JButton delete=new JButton("删除");
        JButton exit=new JButton("退出");

        jp.add(id);
        id.setBounds(10,410,100,25);
        jp.add(name);
        name.setBounds(310,410,100,25);

        jp.add(count);
        count.setBounds(10,510,100,25);
        jp.add(date);
        date.setBounds(310,510,100,25);

        jp.add(idTxt);
        idTxt.setBounds(100,410,160,25);
        jp.add(nameTxt);
        nameTxt.setBounds(420,410,160,25);

        jp.add(countTxt);
        countTxt.setBounds(100,510,160,25);
        jp.add(dateTxt);
        dateTxt.setBounds(420,510,160,25);

        jp.add(add);
        jp.add(update);
        jp.add(delete);
        jp.add(exit);

        add.setBounds(165,610,60,25);
        update.setBounds(235,610,60,25);
        delete.setBounds(305,610,60,25);
        exit.setBounds(375,610,60,25);
    }

    public static void main(String[] args) {
        rCate();
    }

}
