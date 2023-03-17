package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

class more extends JFrame implements ActionListener
{
	int count=0;
	
	Connection con;
	ResultSet rs;
	Statement st;
	
	JButton bprint=new JButton("PRINT");
	JButton bhome;

	JPanel jpanel=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();

	JLabel label=new JLabel("Customer  Information");

	public more()
	{
		super("Reports  of  CUSTOMERS");
		setSize(1024,768);
		Container c=getContentPane();
		
		jpanel.setBounds(280,5,430,60);
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

		bhome=new JButton("BACK",new ImageIcon(more.class.getResource("../../../images/back.gif")));
    	bhome.setBackground(Color.black);
		bhome.setBounds(500,630,100,50);
		p2.add(bhome);
		bhome.addActionListener(this);
		
		try
		{
//			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//			con=DriverManager.getConnection("jdbc:odbc:transportationDSN");
			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
			st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			String[] colheads={"Customer No","Customer Name","Customer Adrress","Vehicle No","Driver No","From Date","To Date","From Place","To Place","Distance"};
			
			rs=st.executeQuery("SELECT c_no,c_name,c_addr,v_no,d_no,from_date,to_date,from_place,to_place,distance FROM customer ORDER BY c_no");
			
			while(rs.next())
			{
				count++;
			}
			
			Object [][]results=new Object[count][10];
			
			rs.first();
			
			for(int i=0;i<count;i++)
			{
				results[i][0]=rs.getInt(1);
				results[i][1]=rs.getString(2);
				results[i][2]=rs.getString(3);
				results[i][3]=rs.getInt(4);
				results[i][4]=rs.getInt(5);
				results[i][5]=rs.getString(6);
				results[i][6]=rs.getString(7);
				results[i][7]=rs.getString(8);
				results[i][8]=rs.getString(9);
				results[i][9]=rs.getInt(10);
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
		if(s.equals("BACK"))
		{
			dispose();
		}
		else
		if(s.equals("PRINT"))
		{
			
		}
	}
}