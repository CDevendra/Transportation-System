package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class add_first extends JFrame implements ActionListener
{
	JButton jbuttondriver,jbuttondvehicle;
	JLabel l;
	
	JPanel jpanel1;
	
	public add_first()
	{
		super("ADDING PROCESS");
		setBounds(320,200,410,305);
		setLayout(null);
		setResizable(false);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel1.setBackground(new Color(255,255,204));
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 10, 375, 250);
				
		l=new JLabel("ADDING PROCESS ");
		l.setFont(new Font("MS Sans Serif",1,24));
		l.setForeground(Color.black);
		l.setBounds(80,-20,250,120);
		jpanel1.add(l);
		
		jbuttondriver=new JButton("DRIVER");
        jbuttondriver.setToolTipText("Add new DRIVER Information into Database.");
        jbuttondriver.setBackground(Color.black);
        jbuttondriver.setForeground(Color.white);
        jpanel1.add(jbuttondriver);
        jbuttondriver.setBounds(25,110,140,60);
        jbuttondriver.addActionListener(this);
     
        jbuttondvehicle=new JButton("VEHICLE");
        jbuttondvehicle.setToolTipText("Add new VEHICLE Information into Database.");
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
			new add_driver();
		}
		else
		if(e.getSource()==jbuttondvehicle)
		{
			dispose();
			new add_vehicle();
		}
	}
}