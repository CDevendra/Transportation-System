package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

class delete_vehicle extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	JPanel jpanel;
	
	JLabel l=new JLabel("Deleting Vehicle Information");
	JLabel jlabelvehicle_no=new JLabel("NO.");
	JLabel jlabelvehicle_name=new JLabel("TYPE");
	JLabel jlabelvehicle_capacity=new JLabel("CAPACITY");
	JLabel jlabelvehicle_puc=new JLabel("PUC  NO.");
	JLabel box=new JLabel("Boxes");
	
	JComboBox jcombovehicle_no=new JComboBox();
	
	JTextField jtextvehicle_capacity=new JTextField();
	JTextField jtextvehicle_puc=new JTextField();
	JTextField jtextvehicle_name=new JTextField();
	
	JButton jbuttondelete=new JButton("DELETE");
	JButton jbuttoncancel=new JButton("CANCEL");
		
	public delete_vehicle()
	{
    	super("Vehicle Information DELETION Form");
   		setBounds(280,150,510,455);
		setLayout(null);
		setResizable(false);
		
		jpanel=new JPanel();
		jpanel.setLayout(null);
     	jpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
     	jpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel.setBackground(new Color(153,153,255));
        getContentPane().add(jpanel);
        jpanel.setBounds(10,10,475,400);
   	
		l.setBounds(70,20,400,30);
    	jlabelvehicle_no.setBounds(30,80,90,30);
		jlabelvehicle_name.setBounds(30,120,90,30);
		jlabelvehicle_capacity.setBounds(30,160,90,30);
		jlabelvehicle_puc.setBounds(30,200,90,30);
		box.setBounds(395,150,50,45);
		
		jpanel.add(l);
		l.setFont(new Font("Arial",1,24));
		jpanel.add(jlabelvehicle_no);
		jpanel.add(jlabelvehicle_name);
		jpanel.add(jlabelvehicle_capacity);
		jpanel.add(jlabelvehicle_puc);
		jpanel.add(box);
		
		jcombovehicle_no.setFont(new Font("Courier New", 1, 16));
		jtextvehicle_name.setFont(new Font("Courier New", 1, 16));
		jtextvehicle_capacity.setFont(new Font("Courier New", 1, 16));
		jtextvehicle_puc.setFont(new Font("Courier New", 1, 16));
		
		jtextvehicle_name.setEditable(false);
		jtextvehicle_capacity.setEditable(false);
		jtextvehicle_puc.setEditable(false);
		
		jcombovehicle_no.setBounds(130,80,250,30);
		jtextvehicle_name.setBounds(130,120,250,30);
		jtextvehicle_capacity.setBounds(130,160,250,30);
		jtextvehicle_puc.setBounds(130,200,250,30);
		
		try
		{
			setconnection();
		
			String sql="SELECT v_no FROM vehicle ORDER BY v_no";
			st.executeQuery(sql);
		
			rs=st.getResultSet();
			
			jcombovehicle_no.addItem("SELECT VEHICLE NUMBER");
			while(rs.next())
			{
				jcombovehicle_no.addItem(rs.getInt("v_no"));
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

		jpanel.add(jcombovehicle_no);
		jpanel.add(jtextvehicle_name);
		jpanel.add(jtextvehicle_capacity);
		jpanel.add(jtextvehicle_puc);
	
		jbuttondelete.setBounds(100,310,100,60);
		jbuttondelete.setBackground(Color.black);
		jbuttondelete.setForeground(Color.white);
		jpanel.add(jbuttondelete);
		jbuttondelete.addActionListener(this);
		
		jbuttoncancel.setBounds(280,310,100,60);
		jbuttoncancel.setBackground(Color.black);
		jbuttoncancel.setForeground(Color.white);		
		jpanel.add(jbuttoncancel);
		jbuttoncancel.addActionListener(this);

		jcombovehicle_no.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
             {
				try
				{
					setconnection();
					
					String sql1="SELECT v_name,capacity,puc_no FROM vehicle WHERE v_no="+jcombovehicle_no.getSelectedItem();
					st.executeQuery(sql1);
		
					rs=st.getResultSet();
		
					while(rs.next())
					{
						jtextvehicle_name.setText(rs.getString("v_name"));
						jtextvehicle_capacity.setText(rs.getString("capacity"));
						jtextvehicle_puc.setText(rs.getString("puc_no"));
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
				int reply = JOptionPane.showConfirmDialog(this,"Are you sure to Delete...?","Transportation System V. 1.0",
												  JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
				if (reply == JOptionPane.YES_OPTION)
				{
			
					String sql2="DELETE * FROM vehicle WHERE v_no="+jcombovehicle_no.getSelectedItem();
					st.executeUpdate(sql2);
					
					String dt="SUCCESS";
					String dm="RECORD DELETED SUCCESSFULLY.";
					int dtype=JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
					
					dispose();
					new delete_first();
				}
				con.commit();
   				con.close();
			}
			catch(Exception e)
			{
				String dt="ERROR";
				String dm="PLEASE... SELECT VEHICLE NO.";
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
		jtextvehicle_name.setText(""); 
		jtextvehicle_capacity.setText(""); 
		jtextvehicle_puc.setText(""); 
    }
}