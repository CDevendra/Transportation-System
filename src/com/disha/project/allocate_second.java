package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class allocate_second extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	PreparedStatement pst;
	ResultSet rs;
	
	Calendar cal;
	
	JPanel jpanel1;
	JPanel jpanel2;
	JPanel jpanel3;
	JPanel jpanel4;
	
	JLabel jlabelvehiclelabel;
	JLabel jlabelvehicle_no;
	JLabel jlabelvehicle_name;
	JLabel jlabelvehicle_capacity;
	JLabel jlabeltones;
	JLabel jlabeldriverlabel;
	JLabel jlabeldriver_no;
	JLabel jlabeldriver_name;
	JLabel jlabeldriver_phone;
    JLabel jlabelfrom_date;   
    JLabel jlabeldatelabel;
    JLabel jlabelto_date;
    JLabel jlabelfrom_place;    
	JLabel jlabelto_place;
    JLabel jlabeldistance;
    JLabel jlabelkm;
    JLabel jlabelamount;
	
	JTextField jtextvehicle_name;
	JTextField jtextvehicle_capacity;
	JTextField jtextdriver_name;
	JTextField jtextdriver_phone;
	JTextField jtextfrom_date;
	JTextField jtextto_date;
	JTextField jtextfrom_place;   
	JTextField jtextto_place; 
	JTextField jtextdistance;
    JTextField jtextamount;
    JTextField c_name;
    JTextField c_addr;
    JTextField c_phone;
    JTextField p_name;
    JTextField p_addr;
    JTextField p_phone;
    JTextField i_name;
    JTextField i_quantity;
    JTextField rate;
    
	JComboBox jcomboboxvehicle_no;
    JComboBox jcomboboxdriver_no;

	JButton jbuttonsave;
	JButton jbuttonreset;
	
	public allocate_second(String customer_name1,String customer_addr1,String customer_phone_no1,String party_name1,String party_addr1,String party_phone_no1,String item_name1,int item_quantity1,int rate1,int total)
	{	
		setTitle("Allocation Process [Step ---> 2 of 2]");
		setBounds(150,10,710,705);
		setLayout(null);
		setResizable(false);
		
		c_name=new JTextField();
    	c_addr=new JTextField();
    	c_phone=new JTextField();
    
    	p_name=new JTextField();
    	p_addr=new JTextField();
    	p_phone=new JTextField();
    
    	i_name=new JTextField();
    	i_quantity=new JTextField();
    	rate=new JTextField();
		
		c_name.setText(customer_name1);
    	c_addr.setText(customer_addr1);
	    c_phone.setText(customer_phone_no1);
    
    	p_name.setText(party_name1);
    	p_addr.setText(party_addr1);
    	p_phone.setText(party_phone_no1);
    
    	i_name.setText(item_name1);
    	
    	String a=Integer.toString(item_quantity1);
    	String b=Integer.toString(rate1);
    	
    	i_quantity.setText(a);
    	rate.setText(b);

		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 10, 675, 170);
		
		jlabelvehiclelabel=new JLabel();
        jlabelvehiclelabel.setFont(new Font("MS Sans Serif", 1, 24));
        jlabelvehiclelabel.setText("VEHICLE  DETAIL");
        jlabelvehiclelabel.setBounds(200 ,-20, 500, 100);
        jpanel1.add(jlabelvehiclelabel); 
		
		jlabelvehicle_no=new JLabel();
        jlabelvehicle_no.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelvehicle_no.setText("VEHICLE  NO");
        jlabelvehicle_no.setBounds(20 ,20, 150, 100);
        jpanel1.add(jlabelvehicle_no);
		
		jcomboboxvehicle_no = new JComboBox();

		try
		{
			setconnection();
		
			String sql1="SELECT v_no FROM vehicle WHERE v_available='yes' ORDER BY v_no";
			st.executeQuery(sql1);
			rs=st.getResultSet();
			
			jcomboboxvehicle_no.addItem("SELECT  VEHICLE  NUMBER");
			while(rs.next())
			{
				jcomboboxvehicle_no.addItem(rs.getInt("v_no"));
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
	
        jpanel1.add(jcomboboxvehicle_no);
        jcomboboxvehicle_no.setBounds(120, 60, 250, 25);
        
        jtextvehicle_name=new JTextField(20);
        jtextvehicle_name.setFont(new Font("Courier New", 1, 16));
        jtextvehicle_name.setEditable(false);
        jpanel1.add(jtextvehicle_name);
        jtextvehicle_name.setBounds(120,110,250,30);
		
		jlabelvehicle_name=new JLabel();
        jlabelvehicle_name.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelvehicle_name.setText("VEHICLE  NAME");
        jlabelvehicle_name.setBounds(20 ,70, 150, 100);
        jpanel1.add(jlabelvehicle_name);
    
		jlabelvehicle_capacity=new JLabel();
        jlabelvehicle_capacity.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelvehicle_capacity.setText("CAPACITY");
        jlabelvehicle_capacity.setBounds(400 ,70, 100, 100);
        jpanel1.add(jlabelvehicle_capacity);
      
        jtextvehicle_capacity=new JTextField(20);
        jtextvehicle_capacity.setFont(new Font("Courier New", 1, 16));
        jtextvehicle_capacity.setEditable(false);
        jpanel1.add(jtextvehicle_capacity);
        jtextvehicle_capacity.setBounds(480,110,100,30);
        
        jlabeltones=new JLabel();
        jlabeltones.setFont(new Font("MS Sans Serif", 1, 12));
        jlabeltones.setText("Tones");
        jlabeltones.setBounds(590 ,100, 50, 50);
        jpanel1.add(jlabeltones);
		
		jpanel2=new JPanel();
		jpanel2.setLayout(null);
		jpanel2.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel2);
        jpanel2.setBounds(10, 195, 675, 220);
        
        jlabeldriverlabel=new JLabel();
        jlabeldriverlabel.setFont(new Font("MS Sans Serif", 1, 24));
        jlabeldriverlabel.setText("DRIVER  DETAIL");
        jlabeldriverlabel.setBounds(200 ,-10, 500, 100);
        jpanel2.add( jlabeldriverlabel); 
		
		jlabeldriver_no=new JLabel();
        jlabeldriver_no.setFont(new Font("MS Sans Serif", 1, 12));
        jlabeldriver_no.setText("DRIVER NO");
        jlabeldriver_no.setBounds(20 ,40, 150, 100);
        jpanel2.add(jlabeldriver_no);
        
		jcomboboxdriver_no = new JComboBox();
		
		try
		{
			setconnection();

			String sql2="SELECT d_no FROM driver WHERE d_available='yes' ORDER BY d_no";
			st.executeQuery(sql2);
			rs=st.getResultSet();
			
			jcomboboxdriver_no.addItem("SELECT  DRIVER  NUMBER");
			while(rs.next())
			{
				jcomboboxdriver_no.addItem(rs.getInt("d_no"));
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
		
        jpanel2.add(jcomboboxdriver_no);
        jcomboboxdriver_no.setBounds(160,75, 250, 25);
		
		jlabeldriver_name=new JLabel();
        jlabeldriver_name.setFont(new Font("MS Sans Serif", 1, 12));
        jlabeldriver_name.setText("DRIVER NAME");
        jlabeldriver_name.setBounds(20 ,80, 150, 100);
        jpanel2.add(jlabeldriver_name);
       
        jtextdriver_name=new JTextField(20);
        jtextdriver_name.setFont(new Font("Courier New", 1, 16));
        jtextdriver_name.setEditable(false);
        jpanel2.add(jtextdriver_name);
        jtextdriver_name.setBounds(160,115,400,30);
		
		jlabeldriver_phone=new JLabel();
        jlabeldriver_phone.setFont(new Font("MS Sans Serif", 1, 12));
        jlabeldriver_phone.setText("DRIVER PHONE NO");
        jlabeldriver_phone.setBounds(20 ,125, 150, 100);
        jpanel2.add(jlabeldriver_phone);
    
        jtextdriver_phone=new JTextField(20);
        jtextdriver_phone.setFont(new Font("Courier New", 1, 16));
        jtextdriver_phone.setEditable(false);
        jpanel2.add(jtextdriver_phone);
        jtextdriver_phone.setBounds(160,155,400,30);
		
		jpanel3=new JPanel();
		jpanel3.setLayout(null);
		jpanel3.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel3);
        jpanel3.setBounds(10, 430, 675, 130);
				
		jlabelfrom_date=new JLabel();
        jlabelfrom_date.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelfrom_date.setText("FROM  DATE");
        jlabelfrom_date.setBounds(30 ,5, 150, 50);
        jpanel3.add(jlabelfrom_date);
        
        cal=Calendar.getInstance();
    	String sdate =String.valueOf(cal.get(Calendar.DATE)) + "-" + (String.valueOf(cal.get(Calendar.MONTH)+1) )+ "-" + String.valueOf(cal.get(Calendar.YEAR));
    
        jtextfrom_date=new JTextField(20);
        jtextfrom_date.setFont(new Font("Courier New", 1, 16));
        jtextfrom_date.setText(sdate);
        jpanel3.add(jtextfrom_date);
        jtextfrom_date.setBounds(165,15,150,25);
        
        jlabelto_date=new JLabel();
        jlabelto_date.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelto_date.setText("TO DATE");
        jlabelto_date.setBounds(365 ,5, 150, 50);
        jpanel3.add(jlabelto_date);
    
        jtextto_date=new JTextField(20);
        jtextto_date.setFont(new Font("Courier New", 1, 16));
        jpanel3.add(jtextto_date);
        jtextto_date.setBounds(485,15,150,25);
        
        jlabelfrom_place=new JLabel();
        jlabelfrom_place.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelfrom_place.setText("FROM PLACE");
        jlabelfrom_place.setBounds(30 ,45, 150, 50);
        jpanel3.add(jlabelfrom_place);
    
        jtextfrom_place=new JTextField(20);
        jtextfrom_place.setFont(new Font("Courier New", 1, 16));
        jtextfrom_place.setText(customer_addr1);
        jpanel3.add(jtextfrom_place);
        jtextfrom_place.setBounds(165,55,150,25);
        
        jlabelto_place=new JLabel();
        jlabelto_place.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelto_place.setText("TO PLACE");
        jlabelto_place.setBounds(365 ,45, 150, 50);
        jpanel3.add(jlabelto_place);
    
        jtextto_place=new JTextField(20);
        jtextto_place.setFont(new Font("Courier New", 1, 16));
        jtextto_place.setText(party_addr1);
        jpanel3.add(jtextto_place);
        jtextto_place.setBounds(485,55,150,25);
        
        jlabeldistance=new JLabel();
        jlabeldistance.setFont(new Font("MS Sans Serif", 1, 12));
        jlabeldistance.setText("TOTAL DISTANCE");
        jlabeldistance.setBounds(30 ,80, 150, 50);
        jpanel3.add(jlabeldistance);
    
        jtextdistance=new JTextField(20);
        jtextdistance.setFont(new Font("Courier New", 1, 16));
        jpanel3.add(jtextdistance);
        jtextdistance.setBounds(165,95,150,25);
        
        jlabelkm=new JLabel();
        jlabelkm.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelkm.setText("Km");
        jlabelkm.setBounds(320 ,80, 100, 50);
        jpanel3.add(jlabelkm);
		
		jlabelamount=new JLabel();
        jlabelamount.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelamount.setText("TOTAL AMOUNT");
        jlabelamount.setBounds(365 ,80, 100, 50);
        jpanel3.add(jlabelamount);
        
        jtextamount=new JTextField(20);
        jtextamount.setFont(new Font("Courier New", 1, 28));
        jtextamount.setEditable(false);
        jpanel3.add(jtextamount);
        jtextamount.setBounds(485,85,150,35);
		
		String amount=Integer.toString(total);
		jtextamount.setText(amount);
		
		jpanel4=new JPanel();
		jpanel4.setLayout(null);
		jpanel4.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel4);
        jpanel4.setBounds(10, 575, 675, 80);
        
		jbuttonsave=new JButton();
        jbuttonsave.setText("SAVE");
        jbuttonsave.setToolTipText("Goes to next form.");
        jpanel4.add(jbuttonsave);
        jbuttonsave.setBounds(150, 10, 150, 60);
        jbuttonsave.addActionListener(this);
     
        jbuttonreset=new JButton();
        jbuttonreset.setText("RESET");
        jbuttonreset.setToolTipText("Clears the information filled in the form.");
        jpanel4.add(jbuttonreset);
        jbuttonreset.setBounds(400, 10, 150, 60);
        jbuttonreset.addActionListener(this);
        
        jcomboboxvehicle_no.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
             {
				try
				{
					setconnection();

					String sql3="SELECT v_name,capacity FROM vehicle WHERE v_no="+jcomboboxvehicle_no.getSelectedItem();
					st.executeQuery(sql3);
					rs=st.getResultSet();
		
					while(rs.next())
					{
						jtextvehicle_name.setText(rs.getString("v_name"));
						jtextvehicle_capacity.setText(rs.getString("capacity"));
					}
					con.commit();
					con.close();
				}
				catch(Exception e)
				{
					jtextvehicle_name.setText("");
					jtextvehicle_capacity.setText("");
				}
            }
        });	
        
    
        jcomboboxdriver_no.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
             {
				try
				{
					setconnection();
					
					String sql4="SELECT d_name,d_phone_no FROM driver WHERE d_no="+jcomboboxdriver_no.getSelectedItem();
					st.executeQuery(sql4);
					rs=st.getResultSet();
		
					while(rs.next())
					{
						jtextdriver_name.setText(rs.getString("d_name"));
						jtextdriver_phone.setText(rs.getString("d_phone_no"));
					}
					con.commit();
					con.close();
				}
				catch(Exception e)
				{
					jtextdriver_name.setText("");
					jtextdriver_phone.setText("");
				}
            }
        });		
	
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        if(source.equals(jbuttonsave))
        {
        	String customer_name1=c_name.getText();
        	String customer_addr1=c_addr.getText();
        	String customer_phone_no1=c_phone.getText();

			String party_name1=p_name.getText();
			String party_addr1=p_addr.getText();
			String party_phone_no1=p_phone.getText();

			String item_name1=i_name.getText();
			
			int item_quantity1=Integer.parseInt(i_quantity.getText());
			int rate1=Integer.parseInt(rate.getText());
        
        	int total_amount=Integer.parseInt(jtextamount.getText());
        	
        	String from_date=jtextfrom_date.getText();
        	String to_date=jtextto_date.getText();
        	
        	String from_place=jtextfrom_place.getText();
        	String to_place=jtextto_place.getText();
        	
        	int distance=Integer.parseInt(jtextdistance.getText());
        	
        	if(from_date.matches("") || to_date.matches("")|| from_place.matches("")|| to_place.matches(""))
        	{
        		String dt="ERROR";
				String dm="ALL FIELDS ARE NECCESSARY!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        	}
        	else
        	{
        	if(distance<0)
        	{
        		String dt="ERROR";
				String dm="PLEASE... CHECK THE DISTANCE FIELD!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        	}
        	else
        	{
        	try
        	{
//        		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//    			con=DriverManager.getConnection("jdbc:odbc:transportationDSN","","");
    			con=DriverManager.getConnection("jdbc:mysql://localhost/transportation?user=root&password=");
        		pst=con.prepareStatement("INSERT INTO customer(c_name,c_addr,c_phone_no,front_party_name,front_party_addr,front_party_phone_no,i_name,quantity,rate,total_amount,v_no,d_no,from_date,to_date,from_place,to_place,distance,order_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");	
        		
        		pst.setString(1,customer_name1);
        		pst.setString(2,customer_addr1);
        		pst.setString(3,customer_phone_no1);
        		pst.setString(4,party_name1);
        		pst.setString(5,party_addr1);
        		pst.setString(6,party_phone_no1);
        		pst.setString(7,item_name1);
        		pst.setInt(8,item_quantity1);
        		pst.setInt(9,rate1);
        		pst.setInt(10,total_amount);
        		pst.setObject(11,jcomboboxvehicle_no.getSelectedItem());
        		pst.setObject(12,jcomboboxdriver_no.getSelectedItem());
        		pst.setString(13,from_date);
        		pst.setString(14,to_date);
        		pst.setString(15,from_place);
        		pst.setString(16,to_place);
        		pst.setInt(17,distance);	
        		pst.setString(18,"Out For Delivery");
        		pst.executeUpdate();

        		Statement st1,st2;
        		String s1,s2;
        		
        		s1="UPDATE vehicle SET v_available='no' WHERE v_no="+jcomboboxvehicle_no.getSelectedItem();
        		s2="UPDATE driver SET d_available='no' WHERE d_no="+jcomboboxdriver_no.getSelectedItem();
        		
        		st1=con.createStatement();
        		st2=con.createStatement();
        		
        		st1.executeUpdate(s1);
        		st2.executeUpdate(s2);

        		con.setAutoCommit(false);
        		con.commit();
        		con.close();
        		
        		String dt="SUCCESS";
				String dm="RECORD INSERTED SUCCESSFULLY";
				int dtype=JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
				
				dispose();
				new receipt();
        	}
        	catch(Exception e)
        	{
        		String dt="ERROR";
				String dm="ERROR";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        	}
           }
          } 	
        }        
        else if(source.equals(jbuttonreset))
        {
        	resetrecord();
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
//		jtextdriver_name.setText("");
//		jtextdriver_phone.setText("");
		jtextfrom_date.setText("");
		jtextto_date.setText("");
//		jtextfrom_place.setText("");
//		jtextto_place.setText("");
		jtextdistance.setText("");
	}
}



