package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

class add_vehicle extends JFrame implements ActionListener
{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	JPanel jpanel;
		
	JLabel l=new JLabel("Adding New Vehicle ");
	JLabel jlabelvehicle_no=new JLabel("NO.");
	JLabel jlabelvehicle_name=new JLabel("TYPE");
	JLabel jlabelvehicle_capacity=new JLabel("CAPACITY");
	JLabel jlabelvehicle_puc=new JLabel("PUC  NO.");
	JLabel tons=new JLabel("Boxes");
		
	JTextField jtextvehicle_no=new JTextField();
	JTextField jtextvehicle_capacity=new JTextField();
	JTextField jtextvehicle_puc=new JTextField();
	JTextField jtextvehicle_name=new JTextField();
		
	JButton jbuttonsave=new JButton("SAVE");
	JButton jbuttoncancel=new JButton("CANCEL");
	JButton jbuttonreset=new JButton("RESET");
	
	public add_vehicle()
	{
    	super("Vehicle Information Form");
    	
   		setBounds(280,150,500,450);
		setLayout(null);
		setResizable(false);
		
		jpanel=new JPanel();
		jpanel.setLayout(null);
     	jpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel.setBackground(new Color(255,255,204));
        getContentPane().add(jpanel);
        jpanel.setBounds(10,10,475,400);
        
		l.setBounds(130,20,250,30);
    	jlabelvehicle_no.setBounds(30,80,90,30);
		jlabelvehicle_name.setBounds(30,120,90,30);
		jlabelvehicle_capacity.setBounds(30,160,90,30);
		jlabelvehicle_puc.setBounds(30,200,90,30);
		tons.setBounds(395,150,50,45);
		
		jpanel.add(l);
		l.setFont(new Font("Arial",1,24));
		jpanel.add(jlabelvehicle_no);
		jpanel.add(jlabelvehicle_name);
		jpanel.add(jlabelvehicle_capacity);
		jpanel.add(jlabelvehicle_puc);
		jpanel.add(tons);
		
		jtextvehicle_no.setFont(new Font("Courier New", 1, 16));
		jtextvehicle_name.setFont(new Font("Courier New", 1, 16));
		jtextvehicle_capacity.setFont(new Font("Courier New", 1, 16));
		jtextvehicle_puc.setFont(new Font("Courier New", 1, 16));
		
		jtextvehicle_no.setBounds(130,80,250,30);
		jtextvehicle_name.setBounds(130,120,250,30);
		jtextvehicle_capacity.setBounds(130,160,250,30);
		jtextvehicle_puc.setBounds(130,200,250,30);
		
		
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//    		con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
       		Statement st=con.createStatement();
        	ResultSet rs;
        
        	st.executeQuery("SELECT MAX(v_no) FROM vehicle");
        
        	rs=st.getResultSet();
        	int vehicle_no=0;
        	while(rs.next())	
        	{
        		vehicle_no=rs.getInt(1);
        		vehicle_no++;
        	}
        	jtextvehicle_no.setEditable(false);
        	jtextvehicle_no.setText(Integer.toString(vehicle_no));
       		con.setAutoCommit(false);
        }
        catch(Exception e)
        {
        }
		
		
		jpanel.add(jtextvehicle_no);
		jpanel.add(jtextvehicle_name);
		jpanel.add(jtextvehicle_capacity);
		jpanel.add(jtextvehicle_puc);
		
		jbuttonsave.setBounds(50,310,100,60);
		jpanel.add(jbuttonsave);
		jbuttonsave.addActionListener(this);
		
		jbuttoncancel.setBounds(180,310,100,60);
		jpanel.add(jbuttoncancel);
		jbuttoncancel.addActionListener(this);
		
		jbuttonreset.setBounds(310,310,100,60);	
		jpanel.add(jbuttonreset);
		jbuttonreset.addActionListener(this);
	
		setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        if(source.equals(jbuttonsave))
        {
        	int vehicle_no=Integer.parseInt(jtextvehicle_no.getText());
        	String vehicle_name=jtextvehicle_name.getText();
        	String vehicle_capacity=jtextvehicle_capacity.getText();
        	String vehicle_puc=jtextvehicle_puc.getText();
        	String availabel="yes";
        	
        	if(vehicle_name.matches("") || vehicle_capacity.matches("") ||  vehicle_puc.matches(""))  
        	{
        		String dt="ERROR";
				String dm="ALL FIELDS ARE NECESSARY...!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        	}
        	else
        	if(!(vehicle_capacity.matches("[0-9]*")))
            {
            	String dt="ERROR";
				String dm="INVALID CAPACITY...!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
            }    
            else
        	{
        		try
        		{
//        			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//    				con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
        			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
        			pst=con.prepareStatement("INSERT INTO vehicle VALUES (?,?,?,?,?)");	
        		
        			pst.setInt(1,vehicle_no);
        			pst.setString(2,vehicle_name);
        			pst.setString(3,vehicle_capacity);
        			pst.setString(4,vehicle_puc);
        			pst.setString(5,availabel);
        		
        			pst.executeUpdate();
        			con.setAutoCommit(false);
        			con.commit();
        			con.close();
        		
        			String dt="SUCCESS";
					String dm="RECORD INSERTED SUCCESSFULLY";
					int dtype=JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
				
					dispose();
					new add_vehicle();
        		}
        		catch(Exception e)
        		{
        			String dt="ERROR";
					String dm="ERROR : Vehicle  Number  Already  Present. " + e;
					int dtype=JOptionPane.ERROR_MESSAGE;
					JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        		}
           	}	
        }
        else       
        if(source.equals(jbuttonreset))
        {
        		resetrecord();
        }
        else
        if(source.equals(jbuttoncancel))
        {
        	dispose();
        } 
    }
    
    private void resetrecord()
    {
		jtextvehicle_name.setText(""); 
		jtextvehicle_capacity.setText(""); 
		jtextvehicle_puc.setText(""); 
    }
}