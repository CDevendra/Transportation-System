package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

class add_driver extends JFrame implements ActionListener
{
	Connection con,con1;
	PreparedStatement pst;
	ResultSet rs;
	
	Date date;
	GregorianCalendar cal;
	
	JPanel jpanel;
	
	JLabel l=new JLabel("Adding New Driver");
	
	JLabel jlabeldriver_no=new JLabel("NO");
	JLabel jlabeldriver_name=new JLabel("NAME");
	JLabel jlabeldriver_address=new JLabel("ADDRESS");
	JLabel jlabeldriver_phone_no=new JLabel("PHONE NO");
	JLabel jlabeldriver_licence_no=new JLabel("LICENCE NO");
		
	JTextField jtextdriver_no=new JTextField();
	JTextField jtextdriver_name=new JTextField();
	JTextField jtextdriver_address=new JTextField();
	JTextField jtextdriver_phone_no=new JTextField();
	JTextField jtextdriver_licence_no=new JTextField();
	
	JButton jbuttonsave=new JButton("SAVE");
	JButton jbuttoncancel=new JButton("CANCEL");
	JButton jbuttonreset=new JButton("RESET");
	
	public add_driver()
	{
    	super("Driver Information Form");
    	
   		setBounds(280,150,500,450);
		setLayout(null);
		setResizable(false);
		
		jpanel=new JPanel();
		jpanel.setLayout(null);
		jpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel.setBackground(new Color(255,255,204));
        getContentPane().add(jpanel);
        jpanel.setBounds(10,10,475,400);
   	
		l.setBounds(130,20,300,30);
		jlabeldriver_no.setBounds(30,80,90,30);
		jlabeldriver_name.setBounds(30,120,90,30);
		jlabeldriver_address.setBounds(30,160,90,30);
		jlabeldriver_phone_no.setBounds(30,200,90,30);
		jlabeldriver_licence_no.setBounds(30,240,90,30);

		jpanel.add(l);
		l.setFont(new Font("Arial",1,24));
		jpanel.add(jlabeldriver_no);
		jpanel.add(jlabeldriver_name);
		jpanel.add(jlabeldriver_address);
		jpanel.add(jlabeldriver_phone_no);
		jpanel.add(jlabeldriver_licence_no);
		
		jtextdriver_no.setFont(new Font("Courier New", 1, 16));
		jtextdriver_name.setFont(new Font("Courier New", 1, 16));
		jtextdriver_address.setFont(new Font("Courier New", 1, 16));
		jtextdriver_phone_no.setFont(new Font("Courier New", 1, 16));
		jtextdriver_licence_no.setFont(new Font("Courier New", 1, 16));
		
		jtextdriver_no.setBounds(130,80,300,30);
		jtextdriver_name.setBounds(130,120,300,30);
		jtextdriver_address.setBounds(130,160,300,30);
		jtextdriver_phone_no.setBounds(130,200,300,30);
		jtextdriver_licence_no.setBounds(130,240,300,30);
		
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//    		con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
       		Statement st=con.createStatement();
        	ResultSet rs;
        
        	st.executeQuery("SELECT MAX(d_no) FROM driver");
        
        	rs=st.getResultSet();
        	int driver_no=0;
        	while(rs.next())	
        	{
        		driver_no=rs.getInt(1);
        		driver_no++;
        	}
        	jtextdriver_no.setEditable(false);
        	jtextdriver_no.setText(Integer.toString(driver_no));
       		con.setAutoCommit(false);
        }
        catch(Exception e)
        {
        }
        
        
		
		jpanel.add(jtextdriver_no);
		jpanel.add(jtextdriver_name);
		jpanel.add(jtextdriver_address);
		jpanel.add(jtextdriver_phone_no);
		jpanel.add(jtextdriver_licence_no);
		
		jbuttonsave.setBounds(50,310,100,60);		
		jbuttonsave.setBackground(Color.black);
		jbuttonsave.setForeground(Color.white);
		jpanel.add(jbuttonsave);
		jbuttonsave.addActionListener(this);
		
		jbuttoncancel.setBounds(180,310,100,60);
		jbuttoncancel.setBackground(Color.black);
		jbuttoncancel.setForeground(Color.white);		
		jpanel.add(jbuttoncancel);
		jbuttoncancel.addActionListener(this);
		
		jbuttonreset.setBounds(310,310,100,60);
		jbuttonreset.setBackground(Color.black);
		jbuttonreset.setForeground(Color.white);		
		jpanel.add(jbuttonreset);
		jbuttonreset.addActionListener(this);

		setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
    //	Object source = event.getSource();
        if(event.getSource()==jbuttonsave)
        {
				String driver_no = jtextdriver_no.getText();
				String driver_name = jtextdriver_name.getText();
				String driver_address = jtextdriver_address.getText();
				String driver_phoenNumber = jtextdriver_phone_no.getText();
				String lisenNo = jtextdriver_licence_no.getText();
				
				if(driver_name.matches("") || driver_address.matches("") ||  driver_phoenNumber.matches("") || lisenNo.matches(""))  
	        	{
	        		String dt="ERROR";
					String dm="ALL FIELDS ARE NECESSARY...!";
					int dtype=JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
	        	}  
	            else
	            {
	            	try{
//							Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//							con1=DriverManager.getConnection("jdbc:odbc:transportationDSN");
					
						con1=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");								
						pst=con1.prepareStatement("insert into driver (d_no,d_name,d_addr,d_phone_no,d_license_no,d_available) values(?,?,?,?,?,?)");
						
						pst.setString(1,jtextdriver_no.getText());
						pst.setString(2,jtextdriver_name.getText());
						pst.setString(3,jtextdriver_address.getText());
						pst.setString(4,jtextdriver_phone_no.getText());
						pst.setString(5,jtextdriver_licence_no.getText());
						pst.setString(6,"yes");					
						pst.executeUpdate();
						
						PreparedStatement pst1 = con1.prepareStatement("INSERT INTO attendance(dr_no,days) values(?,?)");
						pst1.setString(1,jtextdriver_no.getText());
						pst1.setString(2,"0");
						pst1.executeUpdate();
						
						String dt="SUCCESS";
						String dm="RECORD INSERTED SUCCESSFULLY";
						int dtype=JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
					
						dispose();
						new add_driver();
						con1.setAutoCommit(false);
		            }

					catch(Exception e)
	        			{
	           				System.out.println(""+e);
	        			}
				}	
        }
        
        if(event.getSource()==jbuttonreset)
        {
			jtextdriver_name.setText("");
			jtextdriver_address.setText("");
			jtextdriver_phone_no.setText("");
			jtextdriver_licence_no.setText("");
				
        }
        
        if(event.getSource()==jbuttoncancel)
        {
        	dispose();
        } 
    }}