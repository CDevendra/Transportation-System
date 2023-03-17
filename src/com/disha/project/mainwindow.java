package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;

class mainwindow extends JFrame implements ActionListener
{
	JPanel jpanel1;
	JPanel jpanel2;
	JPanel jpanel3;
	
	JTextField text=new JTextField();
	
	JLabel jlabel1;
	
	JButton jbuttonadd;
 	JButton jbuttondelete;
  	JButton jbuttonallocate;
  	JButton jbuttonupdate;
    JButton jbuttonattendance;
    JButton jbuttoncalc;
    JButton jbuttonsalary;
    JButton jbuttonnote;
    JButton jbuttonstatus;
    JButton jbutton_change_password;
    JButton jbuttonlogout;
    JButton jbuttonexit;
        
    Calendar cal;
    
	public mainwindow()
	{	
		setTitle("Transportation System [Version 1.0]");
		setBounds(60,40,910,630);
		setLayout(null);
		setResizable(false);
		
		cal=Calendar.getInstance();
    	String sdate = " DATE: "+String.valueOf(cal.get(Calendar.DATE)) + "-" + (String.valueOf(cal.get(Calendar.MONTH)+1) )+ "-" + String.valueOf(cal.get(Calendar.YEAR));
		
		text.setBounds(680,20,170,30);
		text.setFont(new Font("Courier New", 1, 16));
		text.setBackground(Color.WHITE);
		text.setText(sdate);
		text.setEditable(false);
		getContentPane().add(text);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new LineBorder(new Color(255, 0, 51)));		
		jpanel1.setBackground(Color.gray);
        getContentPane().add(jpanel1);
        jpanel1.setBounds(50, 55, 800, 170);
        
        jlabel1=new JLabel();
        jlabel1.setFont(new Font("MS Sans Serif", 1, 60));
        jlabel1.setText("Transportation System");
        jlabel1.setForeground(Color.cyan);
        jpanel1.add(jlabel1);
        jlabel1.setBounds(80 ,-20, 670, 200);
        
        
        jpanel2=new JPanel();
		jpanel2.setLayout(null);
		jpanel2.setBorder(new LineBorder(new Color(255, 0, 51)));		
		jpanel2.setBackground(Color.gray);
        getContentPane().add(jpanel2);
        jpanel2.setBounds(50, 250, 800, 185);
        
        jbuttonadd=new JButton("NEW  RECORD");
        jbuttonadd.setToolTipText("Add Vehicle or Driver's Information into Database.");
        jbuttonadd.setBackground(Color.black);
        jbuttonadd.setForeground(Color.white);
        jbuttonadd.setBounds(60, 20, 120, 50);
        jbuttonadd.setMnemonic('n');
        jpanel2.add(jbuttonadd);
        jbuttonadd.addActionListener(this);
        
        jbuttondelete=new JButton();
        jbuttondelete.setText("DELETE");
        jbuttondelete.setToolTipText("Delete Vehicle or Driver's Information from Database.");
        jbuttondelete.setBackground(Color.black);
        jbuttondelete.setForeground(Color.white);
        jbuttondelete.setBounds(60, 110, 120, 50);
        jbuttondelete.setMnemonic('d');
        jpanel2.add(jbuttondelete);
        jbuttondelete.addActionListener(this);
        
        jbuttonallocate=new JButton();
        jbuttonallocate.setText("ALLOCATE");
        jbuttonallocate.setToolTipText("Issue Vehicle to the Customer.");
        jbuttonallocate.setBackground(Color.black);
        jbuttonallocate.setForeground(Color.white);
        jbuttonallocate.setBounds(255, 20, 120, 50);
        jbuttonallocate.setMnemonic('a');
        jpanel2.add(jbuttonallocate);
        jbuttonallocate.addActionListener(this);
        
        jbuttonupdate=new JButton();
        jbuttonupdate.setText("UPDATE");
        jbuttonupdate.setToolTipText("Update Vehicle & Drivers Database at the time of returning.");
        jbuttonupdate.setBackground(Color.black);
        jbuttonupdate.setForeground(Color.white);
        jbuttonupdate.setBounds(255, 110, 120, 50);
        jbuttonupdate.setMnemonic('u');
        jpanel2.add(jbuttonupdate);
        jbuttonupdate.addActionListener(this);
        
        jbuttonattendance=new JButton();
        jbuttonattendance.setText("ATTENDANCE");
        jbuttonattendance.setToolTipText("Attendance Sheet of Drivers.");
        jbuttonattendance.setBackground(Color.black);
        jbuttonattendance.setForeground(Color.white);
        jbuttonattendance.setBounds(450, 20, 120, 50);
        jbuttonattendance.setMnemonic('e');
        jpanel2.add(jbuttonattendance);
        jbuttonattendance.addActionListener(this);
        
        jbuttoncalc=new JButton();
        jbuttoncalc.setText("CALCULATOR");
        jbuttoncalc.setToolTipText("Opens CALCULATOR.");
        jbuttoncalc.setBackground(Color.black);
        jbuttoncalc.setForeground(Color.white);
        jbuttoncalc.setBounds(640, 20, 120, 50);
        jbuttoncalc.setMnemonic('c');
        jpanel2.add(jbuttoncalc);
        jbuttoncalc.addActionListener(this);
        
        jbuttonsalary=new JButton();
        jbuttonsalary.setText("SALARY");
        jbuttonsalary.setToolTipText("Calculate SALARY of the Drivers.");
        jbuttonsalary.setBackground(Color.black);
        jbuttonsalary.setForeground(Color.white);
        jbuttonsalary.setBounds(450, 110, 120 , 50);
        jbuttonsalary.setMnemonic('s');
        jpanel2.add(jbuttonsalary);
        jbuttonsalary.addActionListener(this);
        
        jbuttonnote=new JButton("NOTES");
        jbuttonnote.setToolTipText("Opens NOTEPAD.");
        jbuttonnote.setBackground(Color.black);
        jbuttonnote.setForeground(Color.white);
        jbuttonnote.setBounds(640, 110, 120, 50);
        jbuttonnote.setMnemonic('o');
        jpanel2.add(jbuttonnote);
        jbuttonnote.addActionListener(this);
        
        jpanel3=new JPanel();
		jpanel3.setLayout(null);
		jpanel3.setBorder(new LineBorder(new Color(255, 0, 51)));		
		jpanel3.setBackground(Color.gray);
        getContentPane().add(jpanel3);
        jpanel3.setBounds(50, 460, 800, 80);
        
	    jbuttonstatus=new JButton();
        jbuttonstatus.setText("STATUS");
        jbuttonstatus.setToolTipText("Displays Vehicles,Drivers & Customers current status. ");
        jbuttonstatus.setBackground(Color.black);
        jbuttonstatus.setForeground(Color.white);
        jbuttonstatus.setBounds(60, 15, 120, 50);
        jbuttonstatus.setMnemonic('t');
        jpanel3.add(jbuttonstatus);
        jbuttonstatus.addActionListener(this);
        
	    jbutton_change_password=new JButton();
        jbutton_change_password.setText("SECURITY");
        jbutton_change_password.setToolTipText("Change the System Operator's Password");
        jbutton_change_password.setBackground(Color.black);
        jbutton_change_password.setForeground(Color.white);
        jbutton_change_password.setBounds(255, 15, 120, 50);
        jbutton_change_password.setMnemonic('r');
        jpanel3.add(jbutton_change_password);
        jbutton_change_password.addActionListener(this);
        
        jbuttonlogout=new JButton("LOGOUT");
        jbuttonlogout.setToolTipText("Logout from the System.");
        jbuttonlogout.setBackground(Color.black);
        jbuttonlogout.setForeground(Color.white);
        jbuttonlogout.setBounds(450, 15, 120, 50);
        jbuttonlogout.setMnemonic('l');
        jpanel3.add(jbuttonlogout);
		jbuttonlogout.addActionListener(this);
        
        jbuttonexit=new JButton("EXIT",new ImageIcon(mainwindow.class.getResource("../../../images/exit.png")));
        jbuttonexit.setToolTipText("Exit the System.");
        jbuttonexit.setBackground(Color.black);
        jbuttonexit.setForeground(Color.white);
        jbuttonexit.setBounds(640, 15, 120, 50);
        jbuttonexit.setMnemonic('x');
        jpanel3.add(jbuttonexit);
        jbuttonexit.addActionListener(this);
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        if(source.equals(jbuttonadd))
    	{
    		new add_first();
    	}
    	else if(source.equals(jbuttonallocate))
    	{
    		new allocate_first();
    	}
    	else if(source.equals(jbuttonattendance))
    	{
    		new attendance();
    	}
    	else if(source.equals(jbuttoncalc))
    	{
    		runComponents("Calc.exe");
    	}
    	else if(source.equals(jbuttondelete))
    	{
    		new delete_first();
    	}
    	else if(source.equals(jbuttonupdate))
    	{
    		new update();
    	}
    	else if(source.equals(jbuttonsalary))
    	{
   			new salary();
    	}
    	else if(source.equals(jbuttonnote))
    	{
    		runComponents("Notepad.exe");
    	}
    	else if(source.equals(jbuttonstatus))
    	{
    		new status_first();
    	}
    	else if(source.equals(jbutton_change_password))
    	{
    		new change_password();
       	}
    	else if(source.equals(jbuttonlogout))
    	{
    		dispose();
    		new login();
    	}
    	else if(source.equals(jbuttonexit))
    	{
    		CloseWindow();
    	}
    }
    	
    
        
                
  protected void runComponents(String sComponents)
	{
		Runtime rt = Runtime.getRuntime();
		try{rt.exec(sComponents);}
		catch(IOException evt){JOptionPane.showMessageDialog(null,evt.getMessage(),"Error Found",JOptionPane.ERROR_MESSAGE);}
	}           
    
    void CloseWindow()
	{
		try
   		{
			int reply = JOptionPane.showConfirmDialog(this,"Are you sure to exit?","Transportation System V. 1.0",
													  JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
			if (reply == JOptionPane.YES_OPTION)
			{
				dispose();
				System.exit(0);
			}
   		}
		catch(Exception e)
		{}
	}
}
