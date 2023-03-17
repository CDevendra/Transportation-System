package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class allocate_first extends JFrame implements ActionListener
{
	public static void main(String sdsdp[])
	{
		new allocate_first();
	}
	Connection con;
	Statement st;
	ResultSet rs;
	
	JPanel jpanel1;
	JPanel jpanel2;
	JPanel jpanel3;
	JPanel jpanel4;
	
	JLabel label;
	JLabel jlabelcust_name;
	JLabel jlabelcust_addr;
	JLabel jlabelcust_phone;
	JLabel jlabelparty_name;
	JLabel jlabelparty_addr;
	JLabel jlabelparty_phone;
	JLabel jlabelitemlabel;
	JLabel jlabelcustlabel;
	JLabel jlabelpartylabel;
	JLabel jlabelitem_name;
	JLabel jlabelquantity;
	JLabel jlabelbox;
	JLabel jlabelrate;	
    JLabel jlabelper;
	
	JTextField jtextcust_name;
	JTextField jtextcust_addr;
	JTextField jtextcust_phone;
	JTextField jtextparty_name;
	JTextField jtextparty_addr;
	JTextField jtextparty_phone;
	JTextField jtextitem_name;
	JTextField jtextweight;
	JTextField jtextrate;
	
	JButton jbuttonnext;
	JButton jbuttonreset;

	public allocate_first()
	{	
		setTitle("Allocation Process [Step ---> 1 of 2]");
		setBounds(150,20,710,705);
		setLayout(null);
		setResizable(false);
		
		jpanel1=new JPanel();
		jpanel1.setLayout(null);
		jpanel1.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel1);
        jpanel1.setBounds(10, 10, 675, 200);
 
		jlabelcustlabel=new JLabel();
        jlabelcustlabel.setFont(new Font("MS Sans Serif", 1, 18));
        jlabelcustlabel.setText("CUSTMOER  DETAILS");
        jlabelcustlabel.setBounds(200 ,-35, 500, 100);
        jpanel1.add(jlabelcustlabel); 
                
        label=new JLabel();
        label.setFont(new Font("MS Sans Serif", 1, 12));
        label.setText("*All Fields are neccessary... Please fill them correctly.");
        label.setForeground(Color.RED);
        label.setBounds(20 ,5, 500, 100);
        jpanel1.add(label);
      
        jlabelcust_name=new JLabel();
        jlabelcust_name.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelcust_name.setText("CUSTOMER NAME");
        jlabelcust_name.setBounds(20 ,45, 150, 100);
        jpanel1.add(jlabelcust_name);
       
        jtextcust_name=new JTextField(20);
        jtextcust_name.setFont(new Font("Courier New", 1, 16));
        jpanel1.add(jtextcust_name);
        jtextcust_name.setBounds(160,80,400,30);
        
        jlabelcust_addr=new JLabel();
        jlabelcust_addr.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelcust_addr.setText("CUSTOMER ADDRESS");
        jlabelcust_addr.setBounds(20 ,85, 150, 100);
        jpanel1.add(jlabelcust_addr);
       
        jtextcust_addr=new JTextField(20);
        jtextcust_addr.setFont(new Font("Courier New", 1, 16));
        jpanel1.add(jtextcust_addr);
        jtextcust_addr.setBounds(160,120,400,30);
        
        jlabelcust_phone=new JLabel();
        jlabelcust_phone.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelcust_phone.setText("CUSTOMER PHONE NO");
        jlabelcust_phone.setBounds(20 ,130, 150, 100);
        jpanel1.add(jlabelcust_phone);
    
        jtextcust_phone=new JTextField(20);
        jtextcust_phone.setFont(new Font("Courier New", 1, 16));
        jpanel1.add(jtextcust_phone);
        jtextcust_phone.setBounds(160,160,400,30);
          
        jpanel2=new JPanel();
		jpanel2.setLayout(null);
		jpanel2.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel2);
        jpanel2.setBounds(10, 220, 675, 160);
        
        jlabelpartylabel=new JLabel();
        jlabelpartylabel.setFont(new Font("MS Sans Serif", 1, 18));
        jlabelpartylabel.setText("FRONT  PARTY  DETAILS");
        jlabelpartylabel.setBounds(200 ,-35, 500, 100);
        jpanel2.add(jlabelpartylabel); 
   
        jlabelparty_name=new JLabel();
        jlabelparty_name.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelparty_name.setText("PARTY  NAME");
        jlabelparty_name.setBounds(20 ,0, 150, 100);
        jpanel2.add(jlabelparty_name);
       
        jtextparty_name=new JTextField(20);
        jtextparty_name.setFont(new Font("Courier New", 1, 16));
        jpanel2.add(jtextparty_name);
        jtextparty_name.setBounds(160,35,400,30);
      
        jlabelparty_addr=new JLabel();
        jlabelparty_addr.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelparty_addr.setText("PARTY ADDRESS");
        jlabelparty_addr.setBounds(20 ,40, 150, 100);
        jpanel2.add(jlabelparty_addr);
       
        jtextparty_addr=new JTextField(20);
        jtextparty_addr.setFont(new Font("Courier New", 1, 16));
        jpanel2.add(jtextparty_addr);
        jtextparty_addr.setBounds(160,75,400,30);
        
        jlabelparty_phone=new JLabel();
        jlabelparty_phone.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelparty_phone.setText("PARTY PHONE NO");
        jlabelparty_phone.setBounds(20 ,85, 150, 100);
        jpanel2.add(jlabelparty_phone);
    
        jtextparty_phone=new JTextField(20);
        jtextparty_phone.setFont(new Font("Courier New", 1, 16));
        jpanel2.add(jtextparty_phone);
        jtextparty_phone.setBounds(160,115,400,30);
      
        jpanel3=new JPanel();
		jpanel3.setLayout(null);
		jpanel3.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel3);
        jpanel3.setBounds(10, 390, 675, 155);
        
        jlabelitemlabel=new JLabel();
        jlabelitemlabel.setFont(new Font("MS Sans Serif", 1, 18));
        jlabelitemlabel.setText("GOODS  DETAIL");
        jlabelitemlabel.setBounds(200 ,-30, 500, 100);
        jpanel3.add(jlabelitemlabel); 
        
        jlabelitem_name=new JLabel();
        jlabelitem_name.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelitem_name.setText("ITEM NAME");
        jlabelitem_name.setBounds(20 ,10, 150, 100);
        jpanel3.add(jlabelitem_name);
        
        jtextitem_name = new JTextField();
        jtextitem_name.setFont(new Font("MS Sans Serif", 1, 18));
        jpanel3.add(jtextitem_name);
        jtextitem_name.setBounds(120,45,200,30);
        
        jlabelquantity=new JLabel();
        jlabelquantity.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelquantity.setText("TOTAL QUANTITY");
        jlabelquantity.setBounds(350 ,10, 150, 100);
        jpanel3.add(jlabelquantity);
       
        jtextweight=new JTextField(20);
        jtextweight.setFont(new Font("Courier New", 1, 16));
        jpanel3.add(jtextweight);
        jtextweight.setBounds(470,45,100,30);
        
        jlabelbox=new JLabel();
        jlabelbox.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelbox.setText("Boxes");
        jlabelbox.setBounds(575 ,30, 50, 50);
        jpanel3.add(jlabelbox);
        
        jlabelrate=new JLabel();
        jlabelrate.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelrate.setText("RATE");
        jlabelrate.setBounds(20 ,60, 150, 100);
        jpanel3.add(jlabelrate);
       
        jtextrate=new JTextField(20);
        jtextrate.setFont(new Font("Courier New", 1, 16));
        jpanel3.add(jtextrate);
        jtextrate.setBounds(120,100,200,30);
        
        jlabelper=new JLabel();
        jlabelper.setFont(new Font("MS Sans Serif", 1, 12));
        jlabelper.setText("Per Box [in Rupee]");
        jlabelper.setBounds(325 ,90, 150, 50);
        jpanel3.add(jlabelper);
  
        jpanel4=new JPanel();
		jpanel4.setLayout(null);
		jpanel4.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(jpanel4);
        jpanel4.setBounds(10, 560, 675, 100);
        
        jbuttonnext=new JButton();
        jbuttonnext.setText("NEXT");
        jbuttonnext.setToolTipText("Goes to next form.");
        jpanel4.add(jbuttonnext);
        jbuttonnext.setBounds(180, 25, 150, 60);
        jbuttonnext.addActionListener(this);
        
        jbuttonreset=new JButton();
        jbuttonreset.setText("RESET");
        jbuttonreset.setToolTipText("Clears the information filled in the form.");
        jpanel4.add(jbuttonreset);
        jbuttonreset.setBounds(360, 25, 150, 60);
        jbuttonreset.addActionListener(this);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        if(source.equals(jbuttonreset))
        {
        		resetrecord();
        }
        else
        if(source.equals(jbuttonnext))
        {
        	String customer_name=jtextcust_name.getText();
        	String customer_addr=jtextcust_addr.getText();
        	String customer_phone_no=jtextcust_phone.getText();
        	String party_name=jtextparty_name.getText();
        	String party_addr=jtextparty_addr.getText();
        	String party_phone_no=jtextparty_phone.getText();
        	String item_name=jtextitem_name.getText();
        	int item_quantity=Integer.parseInt(jtextweight.getText());
        	int rate=Integer.parseInt(jtextrate.getText());
        	int total=item_quantity*rate;
        	
        	
        	if(customer_name.matches("") || customer_addr.matches("") ||  customer_phone_no.matches("") || party_name.matches("")|| party_addr.matches("")|| party_phone_no.matches("")|| item_name.matches(""))  
        	{
        		String dt="ERROR";
				String dm="ALL FIELDS ARE NECESSARY!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        	}
        	else   
            if(!(customer_phone_no.matches("[0-9]*")) )
            {
            	String dt="ERROR";
				String dm="INVALID CUSTOMER PHONE NUMBER!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
            }    
            else 	
            if(!(party_phone_no.matches("[0-9]*")))
            {
            	String dt="ERROR";
				String dm="INVALID PARTY PHONE NUMBER!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
            }
            else
        	if(item_quantity<0 || rate<0)
        	{
        		String dt="ERROR";
				String dm="QUANTITY & RATE MUST BE POSITIVE!";
				int dtype=JOptionPane.ERROR_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        	}
        	else
        	{
        	try
        	{
        		new allocate_second(customer_name,customer_addr,customer_phone_no,party_name,party_addr,party_phone_no,item_name,item_quantity,rate,total);
        		setVisible(false);
        	}
        	catch(Exception e)
        	{
        		String dt="ERROR";
				String dm="ERROR"+e;
				int dtype=JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
        	}
       	}
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
		jtextcust_name.setText(""); 
		jtextcust_addr.setText(""); 
		jtextcust_phone.setText(""); 
		jtextparty_name.setText(""); 
		jtextparty_addr.setText(""); 
		jtextparty_phone.setText(""); 
		jtextitem_name.setText(""); 
		jtextweight.setText("");
		jtextrate.setText("");  
    }
}