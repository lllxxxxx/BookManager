package com.mybm.staticviews.redaermanager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReaderAdd extends JFrame implements ActionListener{

    private JLabel[] jLabels;
    private JButton[] buttons;
    private JPanel panel;
    private JTextField[] fields;

    public ReaderAdd(String s){
        super(s);
        String[] label=new String[]{"编号","xingm"};
        String[] btt=new String[]{"dd"};
        panel=new JPanel();
        ViewUtiles.bottom(label,btt,panel,jLabels,fields,buttons,2,1,  this);
        this.add(panel);
        this.setSize(300,200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        ReaderAdd add=new ReaderAdd("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
