package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

class customer_status extends JFrame implements ActionListener
{
	int count=0;
	
	Connection con;
	ResultSet rs;
	Statement st;
	
	JButton bprint=new JButton("PRINT");
	JButton bhome;
	JButton more=new JButton("MORE");
	JButton single=new JButton("RECEIPT OF SINGLE CUSTOMER");
	
	JPanel jpanel=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();

	JLabel label=new JLabel("Customer  Information");
		
	public customer_status()
	{
		super("Reports  of  CUSTOMERS....");
		setSize(1024,768);
		Container c=getContentPane();
		
		jpanel.setBounds(280,5,430,60);
     	jpanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		jpanel.setBackground(new Color(255,255,134));
		jpanel.setLayout(new BorderLayout());
		c.add(jpanel);
		
		label.setFont(new Font("MS Sans Serif",1,40));
		label.setForeground(Color.black);
		jpanel.add(label);
		
		p1.setBounds(0,80,1014,500);
		p1.setBorder(new BevelBorder(BevelBorder.RAISED));
		p1.setLayout(new BorderLayout());
		c.add(p1);
		
		p2.setBounds(0,480,1024,40);
		p2.setBorder(new BevelBorder(BevelBorder.RAISED));
		p2.setLayout(null);
		c.add(p2);
		
		bprint.setBounds(100,630,100,50);
		p2.add(bprint);
		bprint.addActionListener(this);

        bhome=new JButton("HOME");
		bhome.setBounds(250,630,100,50);
		p2.add(bhome);
		bhome.addActionListener(this);
		
		more.setBounds(400,630,100,50);
		p2.add(more);
		more.addActionListener(this);
		
		single.setBounds(550,630,300,50);
		p2.add(single);
		single.addActionListener(this);
		
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con=DriverManager.getConnection("jdbc:odbc:transportationDSN");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			String[] colheads={"Customer No","Customer Name","Customer Adrress","Phone No","Party Name","Party Address","Party Phone No","Item Name","Quantity","Rate","Amount"};
			
			rs=st.executeQuery("SELECT c_no,c_name,c_addr,c_phone_no,front_party_name,front_party_addr,front_party_phone_no,i_name,quantity,rate,total_amount FROM customer ORDER BY c_no");
			
			while(rs.next())
			{
				count++;
			}

			Object [][]results=new Object[count][11];
			
			rs.first();
			
			for(int i=0;i<count;i++)
			{
				results[i][0]=rs.getInt(1);
				results[i][1]=rs.getString(2);
				results[i][2]=rs.getString(3);
				results[i][3]=rs.getString(4);
				results[i][4]=rs.getString(5);
				results[i][5]=rs.getString(6);
				results[i][6]=rs.getString(7);
				results[i][7]=rs.getString(8);
				results[i][8]=rs.getInt(9);
				results[i][9]=rs.getInt(10);
				results[i][10]=rs.getInt(11);
				rs.next();
			}

        	con.setAutoCommit(false);
			con.commit();
        	con.close();
			
			JTable table=new JTable(results,colheads);
			
			table.setFont(new java.awt.Font("Times New Roman", 0, 16));
			table.setBackground(new java.awt.Color(51, 153, 255));
       		table.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
			table.setSelectionBackground(new Color(255, 0, 51));
        	table.setSelectionForeground(new Color(0, 0, 0));
        	table.setRowHeight(20);
        
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
		if(s.equals("PRINT"))
		{
			
		}
		else
		if(s.equals("MORE"))
		{
			new more();
		}
		else
		if(s.equals("RECEIPT OF SINGLE CUSTOMER"))
		{
			new singlereceipt();			
		}
	}
}