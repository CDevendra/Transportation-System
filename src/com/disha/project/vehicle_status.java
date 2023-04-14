package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

class vehicle_status extends JFrame implements ActionListener
{
	int count=0;
	
	Connection con;
	ResultSet rs;
	Statement st;
	
	JButton bprint=new JButton("BACK");
	JButton bhome=new JButton("HOME");
	
	JPanel jpanel=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	JLabel label=new JLabel("Vehicle Information");
	
	public vehicle_status()
	{
		super("Reports  of  VEHICLES");
		setSize(1024,768);
		Container c=getContentPane();
		
		jpanel.setBounds(300,5,380,60);
		jpanel.setBorder(new BevelBorder(BevelBorder.RAISED));
		jpanel.setBackground(Color.yellow);
		jpanel.setLayout(new BorderLayout());
		c.add(jpanel);
		
		label.setFont(new Font("MS Sans Serif",1,40));
		label.setForeground(Color.black);
		jpanel.add(label);
		
		p1.setBounds(0,80,1014,500);
		p1.setBorder(new BevelBorder(BevelBorder.RAISED));
		p1.setLayout(new BorderLayout());
		c.add(p1);
		
		p2.setBounds(0,700,1024,40);
		p2.setBorder(new BevelBorder(BevelBorder.RAISED));
		p2.setLayout(null);
		c.add(p2);
		
		bprint.setBounds(350,630,100,50);
		p2.add(bprint);
		bprint.addActionListener(this);
		
		bhome.setBounds(500,630,100,50);
		p2.add(bhome);
		bhome.addActionListener(this);
		
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con=DriverManager.getConnection("jdbc:odbc:transportationDSN");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			String[] colheads={"Vehicle No","Vehicle Name","Capacity","PUC No","Available"};
			
			rs=st.executeQuery("SELECT v_no,v_name,capacity,puc_no,v_available FROM vehicle ORDER BY v_no");
			
			while(rs.next())
			{
				count++;
			}
			
			Object [][]results=new Object[count][5];
			
			rs.first();
			
			for(int i=0;i<count;i++)
			{
				
				results[i][0]=rs.getInt(1);
				results[i][1]=rs.getString(2);
				results[i][2]=rs.getString(3);
				results[i][3]=rs.getString(4);
				results[i][4]=rs.getString(5);
				rs.next();
			}

   			con.setAutoCommit(false);
			con.commit();
   			con.close();
			
			JTable table=new JTable(results,colheads);
			
			table.setFont(new Font("Times New Roman", 0, 16));
			table.setBackground(new Color(51, 153, 255));
       		table.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			table.setSelectionBackground(new Color(255, 0, 51));
        	table.setSelectionForeground(new Color(0, 0, 0));
        	table.setRowHeight(20);
        	table.setEnabled(false);
        
			int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
			int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
			
			JScrollPane jsp=new JScrollPane(table,v,h);
			
			p1.add(jsp,BorderLayout.CENTER);
		}
		catch(Exception e)
		{
			String dt="ERROR";
			String dm="ERROR"+e;
			int dtype=JOptionPane.ERROR_MESSAGE;
			JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
		}
	
		c.setBackground(new Color(254,223,254));
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent a)
	{
		String s=a.getActionCommand();
		if(s.equals("HOME"))
		{
			dispose();
		}
		else
		if(s.equals("BACK"))
		{
			dispose();
		}
	}
}