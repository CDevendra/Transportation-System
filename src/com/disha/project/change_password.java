package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

class change_password extends JFrame implements ActionListener
{
	Connection con;
	ResultSet rs;
	PreparedStatement pst;
	
	JPanel jpanel1;
	
	JLabel jlabelold_password=new JLabel("Old  Password");
	JLabel jlabelnew_password=new JLabel("New  Passward");
	JLabel jlabelconfirm_password=new JLabel("Confirm  Passward");
	
	JPasswordField jpasswordfield_old_password=new JPasswordField();
	JPasswordField jpasswordfield_new_password=new JPasswordField();
	JPasswordField jpasswordfield_confirm_password=new JPasswordField();
		
	JButton jbuttonsave=new JButton("SAVE");
	JButton jbuttoncancel=new JButton("CANCEL");
		
	public change_password()
	{
       	super("Password Security.....");
		setBounds(320,200,400,250);
		setLayout(null);
		setResizable(false);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
     	jpanel1.setBorder(new BevelBorder(BevelBorder.RAISED));
     	jpanel1.setBackground(Color.gray);
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 5, 375, 210);
	
    	jlabelold_password.setBounds(30,20,110,30);
    	jlabelold_password.setForeground(Color.white);
		jpanel1.add(jlabelold_password);
		
		jlabelnew_password.setBounds(30,60,110,30);
		jlabelnew_password.setForeground(Color.white);
		jpanel1.add(jlabelnew_password);
		
		jlabelconfirm_password.setBounds(30,100,110,30);
		jlabelconfirm_password.setForeground(Color.white);
		jpanel1.add(jlabelconfirm_password);
		
		jpasswordfield_old_password.setBounds(145,20,200,30);
		jpanel1.add(jpasswordfield_old_password);
		
		jpasswordfield_new_password.setBounds(145,60,200,30);
		jpanel1.add(jpasswordfield_new_password);
		
		jpasswordfield_confirm_password.setBounds(145,100,200,30);
		jpanel1.add(jpasswordfield_confirm_password);
		
	
		jbuttonsave.setBounds(80,150,100,50);	
		jbuttonsave.setBackground(Color.black);
		jbuttonsave.setForeground(Color.white);
		jpanel1.add(jbuttonsave);
		jbuttonsave.addActionListener(this);
		
		jbuttoncancel.setBounds(220,150,100,50);
		jbuttoncancel.setBackground(Color.black);
		jbuttoncancel.setForeground(Color.white);		
		jpanel1.add(jbuttoncancel);
	    jbuttoncancel.addActionListener(this);
	    
	    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        if(source.equals(jbuttonsave))
        {
        	try
        	{
        		setconnection();
        		
        		Statement st1;
        		Statement st2;
        		Statement st3;
        		
        		st1=con.createStatement();
        		st2=con.createStatement();
        		st3=con.createStatement();
        		
        		String sql1="SELECT password FROM Login";
        		
        		st1.executeQuery(sql1);
        		rs=st1.getResultSet();

        		Object pass;
        		while(rs.next())
        		{
        			pass=rs.getString("password");
        			
        			if( (jpasswordfield_old_password.getText()) .equals (pass) )
        			{
        				if((jpasswordfield_new_password.getText()).equals(jpasswordfield_confirm_password.getText()))
        				{
        					st2.executeUpdate("DELETE * FROM Login");
        					
        					pst=con.prepareStatement("INSERT INTO Login VALUES (?,?)");	
        		
        					pst.setString(1,"secret");
        					pst.setString(2,jpasswordfield_new_password.getText());

        					pst.executeUpdate();
        					con.commit();
        					con.close();
        					
        					String dt="SUCCESS";
							String dm="PASSWORD  CHANGED  SUCCESSFULLY";
							int dtype=JOptionPane.INFORMATION_MESSAGE;
							JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
							rs.close();
							dispose();
        				}
        				else
        				{
        					String dt="ERROR";
							String dm="ENTER  SAME  PASSWORD  IN  BOTH  FIELD.";
							int dtype=JOptionPane.INFORMATION_MESSAGE;
							JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        				}
        			}
        			else
        			{
        				String dt="ERROR";
						String dm="OLD  PASSWORD  NOT  MATCHING."+jpasswordfield_old_password.getText();
						int dtype=JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        			}
        		}
        		con.commit();
        		con.close();
        	}
        	catch(Exception e)
        	{
        		dispose();
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
}