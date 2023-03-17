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

class delete_driver extends JFrame implements ActionListener
{
	Connection con;
	Statement st,stmt;
	ResultSet rs;
	Date date;
	GregorianCalendar cal;
	
	JPanel jpanel;
	
	JLabel l=new JLabel("Deleting Driver Information");
	
	JLabel jlabeldriver_no=new JLabel("NO.");
	JLabel jlabeldriver_name=new JLabel("NAME");
	JLabel jlabeldriver_address=new JLabel("ADDRESS");
	JLabel jlabeldriver_phone_no=new JLabel("PHONE  NO.");
	JLabel jlabeldriver_licence_no=new JLabel("LICENCE  NO.");
	
	JComboBox jcombodriver_no=new JComboBox();
	
	JTextField jtextdriver_name=new JTextField();
	JTextField jtextdriver_address=new JTextField();
	JTextField jtextdriver_phone_no=new JTextField();
	JTextField jtextdriver_licence_no=new JTextField();
	
	JButton jbuttondelete=new JButton("DELETE");
	JButton jbuttoncancel=new JButton("CANCEL");
		
	public delete_driver()
	{
    	super("Driver Information DELETION Form.....");
    	
   		setBounds(280,150,510,455);
		setLayout(null);
		setResizable(false);
		
		jpanel=new JPanel();
		jpanel.setLayout(null);
		jpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel.setBackground(new Color(153,153,255));
        getContentPane().add(jpanel);
        jpanel.setBounds(10,10,475,400);
        
		l.setBounds(90,20,400,30);
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
		
		jcombodriver_no.setFont(new Font("Courier New", 1, 16));
		jtextdriver_name.setFont(new Font("Courier New", 1, 16));
		jtextdriver_address.setFont(new Font("Courier New", 1, 16));
		jtextdriver_phone_no.setFont(new Font("Courier New", 1, 16));
		jtextdriver_licence_no.setFont(new Font("Courier New", 1, 16));
		
		jtextdriver_name.setEditable(false);
		jtextdriver_address.setEditable(false);
		jtextdriver_phone_no.setEditable(false);
		jtextdriver_licence_no.setEditable(false);
		
		jcombodriver_no.setBounds(130,80,300,30);
		jtextdriver_name.setBounds(130,120,300,30);
		jtextdriver_address.setBounds(130,160,300,30);
		jtextdriver_phone_no.setBounds(130,200,300,30);
		jtextdriver_licence_no.setBounds(130,240,300,30);
		
		try
		{
			setconnection();
		
			String sql="SELECT d_no FROM driver ORDER BY d_no";
		
			st.executeQuery(sql);
		
			rs=st.getResultSet();
			
			jcombodriver_no.addItem("SELECT  DRIVER  NUMBER");
			while(rs.next())
			{
				jcombodriver_no.addItem(rs.getInt("d_no"));
			}
        	con.commit();
        	con.close();
		}
		catch(Exception e)
		{
			String dt="ERROR";
			String dm="ERROR"+e;
			int dtype=JOptionPane.ERROR_MESSAGE;
			JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
		}
		
		jpanel.add(jcombodriver_no);
		jpanel.add(jtextdriver_name);
		jpanel.add(jtextdriver_address);
		jpanel.add(jtextdriver_phone_no);
		jpanel.add(jtextdriver_licence_no);
		
		jbuttondelete.setBounds(100,310,100,60);		
		jpanel.add(jbuttondelete);
		jbuttondelete.addActionListener(this);
		
		jbuttoncancel.setBounds(260,310,100,60);		
		jpanel.add(jbuttoncancel);
		jbuttoncancel.addActionListener(this);
	
        jcombodriver_no.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
             {
				try
				{
					setconnection();
		
					String sql1="SELECT d_name,d_addr,d_phone_no,d_license_no FROM driver WHERE d_no="+jcombodriver_no.getSelectedItem();
		
					st.executeQuery(sql1);
		
					rs=st.getResultSet();

					while(rs.next())
					{
						jtextdriver_name.setText(rs.getString("d_name"));
						jtextdriver_address.setText(rs.getString("d_addr"));
						jtextdriver_phone_no.setText(rs.getString("d_phone_no"));
						jtextdriver_licence_no.setText(rs.getString("d_license_no"));
					}
					con.commit();
        			con.close();
				}
				catch(Exception e)
				{
					resetrecord();
				}
            }
        });
		
		setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        if(source.equals(jbuttondelete))
        {
        	try
			{
				setconnection();
				int reply = JOptionPane.showConfirmDialog(this,"Are you sure to Delete....?", "Transportation System V. 1.0",
												  JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (reply == JOptionPane.YES_OPTION)
				{
					String sql2="DELETE * FROM driver WHERE d_no="+jcombodriver_no.getSelectedItem();
		
					st.executeUpdate(sql2);
					
					stmt=con.createStatement();
			
					stmt.executeUpdate("DELETE * FROM attendance WHERE dr_no="+jcombodriver_no.getSelectedItem());
						
					String dt="SUCCESS";
					String dm="RECORD  DELETED  SUCCESSFULLY.";
					int dtype=JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
					
					con.commit();
	       			con.close();
				
					dispose();
					new delete_first();
				}
			}
			catch(Exception e)
			{
				String dt="ERROR";
				String dm="PLEASE... SELECT DRIVER NO.";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
			}
        }
        else
        if(source.equals(jbuttoncancel))
        {
        	dispose();
        } 
    }
    
   public void setconnection()
   {
   		try
   		{
//   			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//    		con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			st=con.createStatement();
			con.setAutoCommit(false);
   		}
   		catch(Exception e)
   		{
   			String dt="ERROR";
			String dm="ERROR"+e;
			int dtype=JOptionPane.ERROR_MESSAGE;
			JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
   		}
   }
   
    private void resetrecord()
    {
		jtextdriver_name.setText(""); 
		jtextdriver_address.setText(""); 
		jtextdriver_phone_no.setText(""); 
	    jtextdriver_licence_no.setText(""); 
    }
}