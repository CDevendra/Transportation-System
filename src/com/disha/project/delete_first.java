package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class delete_first extends JFrame implements ActionListener
{
	JButton jbuttondriver,jbuttondvehicle;
	JLabel l;
	
	JPanel jpanel1;
	
	public delete_first()
	{
		super("DELETING PROCESS");
		setBounds(320,200,410,305);
		setLayout(null);
		setResizable(false);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel1.setBackground(new Color(255,255,204));
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 10, 375, 250);
				
		l=new JLabel("DELETING PROCESS ");
		l.setFont(new Font("MS Sans Serif",1,24));
		l.setForeground(Color.black);
		l.setBounds(60,-20,280,120);
		jpanel1.add(l);
		
		jbuttondriver=new JButton("DRIVER");
        jbuttondriver.setToolTipText("Delete specific driver.");
        jbuttondriver.setBackground(Color.black);
		jbuttondriver.setForeground(Color.white);
        jpanel1.add(jbuttondriver);
        jbuttondriver.setBounds(25,110,140,60);
        jbuttondriver.addActionListener(this);
     
        jbuttondvehicle=new JButton("VEHICLE");
        jbuttondvehicle.setToolTipText("Delete specific vehicle.");
        jbuttondvehicle.setBackground(Color.black);
		jbuttondvehicle.setForeground(Color.white);
        jpanel1.add(jbuttondvehicle);
        jbuttondvehicle.setBounds(210,110,140,60);
		jbuttondvehicle.addActionListener(this);		
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jbuttondriver)
		{
			dispose();
			new delete_driver();
		}
		else
		if(e.getSource()==jbuttondvehicle)
		{
			dispose();
			new delete_vehicle();
		}
	}
}