package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class status_first extends JFrame implements ActionListener
{
	JButton jbuttondriver,jbuttondvehicle,jbuttoncustomer;
	JLabel l;
	
	JPanel jpanel1;
	
	public status_first()
	{
		super("Reports  Section");
		setBounds(220,200,610,305);
		setLayout(null);
		setResizable(false);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new BevelBorder(BevelBorder.RAISED));
		jpanel1.setBackground(new Color(255,255,204));
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 10, 575, 250);
				
		l=new JLabel("REPORTS  SECTION");
		l.setFont(new Font("MS Sans Serif",1,24));
		l.setForeground(Color.black);
		l.setBounds(170,-20,250,120);
		jpanel1.add(l);
		
		jbuttondriver=new JButton("DRIVER");
        jbuttondriver.setToolTipText("Displays  DRIVER  Information.");
        jbuttondriver.setBackground(Color.black);
        jbuttondriver.setForeground(Color.white);
        jpanel1.add(jbuttondriver);
        jbuttondriver.setBounds(35,110,140,60);
        jbuttondriver.addActionListener(this);
     
        jbuttondvehicle=new JButton("VEHICLE");
        jbuttondvehicle.setToolTipText("Displays  VEHICLE  Information.");
        jbuttondvehicle.setBackground(Color.black);
        jbuttondvehicle.setForeground(Color.white);
        jpanel1.add(jbuttondvehicle);
        jbuttondvehicle.setBounds(220,110,140,60);
		jbuttondvehicle.addActionListener(this);	
		
		jbuttoncustomer=new JButton("CUSTOMER");
        jbuttoncustomer.setToolTipText("Displays  CUSTOMER  Information.");
        jbuttoncustomer.setBackground(Color.black);
        jbuttoncustomer.setForeground(Color.white);
        jpanel1.add(jbuttoncustomer);
        jbuttoncustomer.setBounds(400,110,140,60);
		jbuttoncustomer.addActionListener(this);

		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jbuttondriver)
		{
			new driver_status();
		}
		else
		if(e.getSource()==jbuttondvehicle)
		{
			new vehicle_status();
		}
		else
		if(e.getSource()==jbuttoncustomer)
		{
			new customer_status();
		}
	}
}
