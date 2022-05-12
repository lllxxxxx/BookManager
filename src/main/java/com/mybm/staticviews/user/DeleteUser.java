package com.mybm.staticviews.user;

import com.mybm.dao.UserDAO;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;

/**
 * @author: lllxxx
 * @description: TODO
 * @date: 2022/5/8 20:00
 */
public class DeleteUser extends JFrame {

    private JTable table;

    private JScrollPane jScrollPane;

    private DefaultTableModel model;

    private JButton[] b;

    private JPanel panel;

    private Vector<Vector<Object>> o;

    {
        List<Object[]> list = null;
        try {
            list= UserDAO.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        o=new Vector<Vector<Object>>();
        for (int i = 0; i < list.size(); i++) {
            Vector<Object> v=new Vector<>();;
            for (int j = 0; j <3; j++) {
                v.add(list.get(i)[j]);
            }
            o.add(v);
        }
    }

    public DeleteUser(String s){
        super(s);
        Vector c=new Vector<>();
        c.add("用户编号");
        c.add("用户名");
        c.add("密码");
        table=new JTable(o,c);
        jScrollPane=new JScrollPane(table);
        panel=new JPanel();
        this.add(panel);
        panel.add(jScrollPane);
        b=new JButton[2];
        b[0]=new JButton("删除");
        b[1]=new JButton("退出");
        panel.add(b[0]);
        panel.add(b[1]);
        b[0].addActionListener(e -> {
            String valueAt = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
            System.out.println(table.getSelectedColumn());
            Boolean b=false;
            try {
                b=UserDAO.DelectCHoosen(valueAt,table.getSelectedColumn());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if(b==true){
                List<Object[]> list = null;
                try {
                    list= UserDAO.selectAll();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                o.removeAllElements();
                for (int i = 0; i < list.size(); i++) {
                    Vector<Object> v=new Vector<>();;
                    for (int j = 0; j <3; j++) {
                        v.add(list.get(i)[j]);
                    }
                    o.add(v);
                }
                AbstractTableModel model = (AbstractTableModel) table.getModel();
                model=new DefaultTableModel(o,c);
                table.setModel(model);
                jScrollPane.repaint();
                JOptionPane.showMessageDialog(null,"删除成功");
            }else {
                JOptionPane.showMessageDialog(null,"删除失败");
            }
        });
        b[1].addActionListener(e -> {
            this.dispose();
        });
        this.setSize(500,600);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }


}
