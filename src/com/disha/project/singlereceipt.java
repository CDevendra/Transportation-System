package com.disha.project;   

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

public class singlereceipt extends JFrame implements ActionListener
{
	Connection con;
	Statement st;
	ResultSet rs;
	
	JLabel singlereceipt=new JLabel("Receipt");
	JLabel label_c_no=new JLabel("Customer No");
	JLabel label_c_name=new JLabel("Customer Name");
	JLabel label_c_addr=new JLabel("Customer Address");
	JLabel label_c_phone=new JLabel("Contact No");
	
	JLabel label_party_name=new JLabel("Party Name");
	JLabel label_party_addr=new JLabel("Party Address");
	JLabel label_p_phone=new JLabel("Contact No");
	
	JLabel label_i_name=new JLabel("Item Name");
	JLabel label_i_quantity=new JLabel("Quantity");
	JLabel label_i_rate=new JLabel("Rate");
	JLabel label_total_amount=new JLabel("Total Amount");
	
	JLabel label_f_date=new JLabel("From Date");
	JLabel label_t_date=new JLabel("To Date");
	JLabel label_f_place=new JLabel("From Place");
	JLabel label_t_place=new JLabel("To Place");
	
	JLabel label_d_no=new JLabel("Driver No");
	JLabel label_d_phone=new JLabel("Contact No");
	JLabel label_d_name=new JLabel("Driver Name");
	
	JLabel label_v_no=new JLabel("Vehicle No");
	JLabel label_v_capacity=new JLabel("Capacity");
	JLabel label_box=new JLabel("Boxes");
	
	JLabel text_c_no;
	JLabel text_c_phone;
	JLabel text_c_name;
	JLabel text_c_addr;
	
	JLabel text_p_name;
	JLabel text_p_addr;
	JLabel text_p_phone;
	
	JLabel text_i_name;
	JLabel text_i_quantity;
	JLabel text_i_rate;
	JLabel text_total_amount;
	
	JLabel text_f_date;
	JLabel text_t_date;
	JLabel text_f_place;
	JLabel text_t_place;
	
	JLabel text_d_no;
	JLabel text_d_phone;
	JLabel text_d_name;
	
	JLabel text_v_no;
	JLabel text_v_capacity;
	
	JButton bprint=new JButton("BACK");
	JButton bclose=new JButton("CLOSE");

	public singlereceipt()
	{	
		String custid=JOptionPane.showInputDialog("ENTER THE CUSTOMER NO :");
		if(custid==null)
		{
			setVisible(false);
		}
		else
		{	
		setTitle("Receipt...");
		setBounds(200,0,620,700);
		setLayout(null);
		setResizable(false);
		
		getContentPane().setBackground(new Color(255,255,204));
		
	    singlereceipt.setFont(new Font("Monotype corsiva",Font.ITALIC, 38));
        singlereceipt.setBounds(220 ,10, 150, 50);
        getContentPane().add(singlereceipt); 
        
        label_c_no.setFont(new Font("Mootype Corsiva", 0, 16));
        label_c_no.setBounds(10 ,75, 200, 50);
        getContentPane().add(label_c_no); 
        
        text_c_no=new JLabel();
        text_c_no.setFont(new Font("Courier New", 1, 16));
//        text_c_no.setEditable(false);
        text_c_no.setBounds(150,90,100,20);
        getContentPane().add(text_c_no);
        
        label_c_phone.setFont(new Font("Mootype Corsiva", 0, 16));
        label_c_phone.setBounds(300 ,75, 200, 50);
        getContentPane().add(label_c_phone); 
        
        text_c_phone=new JLabel();
        text_c_phone.setFont(new Font("Courier New", 1, 16));
//        text_c_phone.setEditable(false);
        text_c_phone.setBounds(400,90,200,20);
        getContentPane().add(text_c_phone);
        
        label_c_name.setFont(new Font("Mootype Corsiva", 0, 16));
        label_c_name.setBounds(10 ,105, 200, 50);
        getContentPane().add(label_c_name); 
        
        text_c_name=new JLabel();
        text_c_name.setFont(new Font("Courier New", 1, 16));
//        text_c_name.setEditable(false);
        text_c_name.setBounds(150,120,450,20);
        getContentPane().add(text_c_name);
        
        label_c_addr.setFont(new Font("Mootype Corsiva", 0, 16));
        label_c_addr.setBounds(10 ,135, 200, 50);
        getContentPane().add(label_c_addr); 
        
        text_c_addr=new JLabel();
        text_c_addr.setFont(new Font("Courier New", 1, 16));
//        text_c_addr.setEditable(false);
        text_c_addr.setBounds(150,150,450,20);
        getContentPane().add(text_c_addr);
        
        label_party_name.setFont(new Font("Mootype Corsiva", 0, 16));
        label_party_name.setBounds(10 ,195, 200, 50);
        getContentPane().add(label_party_name);
        
        text_p_name=new JLabel();
        text_p_name.setFont(new Font("Courier New", 1, 16));
//        text_p_name.setEditable(false);
        text_p_name.setBounds(150,210,450,20);
        getContentPane().add(text_p_name);
        
        label_party_addr.setFont(new Font("Mootype Corsiva", 0, 16));
        label_party_addr.setBounds(10 ,225, 200, 50);
        getContentPane().add(label_party_addr);
        
        text_p_addr=new JLabel();
        text_p_addr.setFont(new Font("Courier New", 1, 16));
//        text_p_addr.setEditable(false);
        text_p_addr.setBounds(150,240,450,20);
        getContentPane().add(text_p_addr);
        
        label_p_phone.setFont(new Font("Mootype Corsiva", 0, 16));
        label_p_phone.setBounds(10 ,255, 200, 50);
        getContentPane().add(label_p_phone);
        
        text_p_phone=new JLabel();
        text_p_phone.setFont(new Font("Courier New", 1, 16));
//        text_p_phone.setEditable(false);
        text_p_phone.setBounds(150,270,450,20);
        getContentPane().add(text_p_phone);
        
        label_i_name.setFont(new Font("Mootype Corsiva", 0, 16));
        label_i_name.setBounds(10 ,315, 200, 50);
        getContentPane().add(label_i_name);
        
        text_i_name=new JLabel();
        text_i_name.setFont(new Font("Courier New", 1, 16));
//        text_i_name.setEditable(false);
        text_i_name.setBounds(150,330,450,20);
        getContentPane().add(text_i_name);
        
        label_i_quantity.setFont(new Font("Mootype Corsiva", 0, 16));
        label_i_quantity.setBounds(10 ,345, 200, 50);
        getContentPane().add(label_i_quantity);
        
        text_i_quantity=new JLabel();
        text_i_quantity.setFont(new Font("Courier New", 1, 16));
//        text_i_quantity.setEditable(false);
        text_i_quantity.setBounds(150,360,80,20);
        getContentPane().add(text_i_quantity);
        
        label_i_rate.setFont(new Font("Mootype Corsiva", 0, 16));
        label_i_rate.setBounds(250 ,345, 200, 50);
        getContentPane().add(label_i_rate); 
        
        text_i_rate=new JLabel();
        text_i_rate.setFont(new Font("Courier New", 1, 16));
//        text_i_rate.setEditable(false);
        text_i_rate.setBounds(300,360,80,20);
        getContentPane().add(text_i_rate);
        
        label_total_amount.setFont(new Font("Mootype Corsiva", 0, 16));
        label_total_amount.setBounds(400 ,345, 200, 50);
        getContentPane().add(label_total_amount);
        
        text_total_amount=new JLabel();
        text_total_amount.setFont(new Font("Courier New", 1, 16));
//        text_total_amount.setEditable(false);
        text_total_amount.setBounds(510,360,90,20);
        getContentPane().add(text_total_amount);
       
        label_f_date.setFont(new Font("Mootype Corsiva", 0, 16));
        label_f_date.setBounds(10 ,405, 200, 50);
        getContentPane().add(label_f_date);
        
        text_f_date=new JLabel();
        text_f_date.setFont(new Font("Courier New", 1, 16));
//        text_f_date.setEditable(false);
        text_f_date.setBounds(150,420,150,20);
        getContentPane().add(text_f_date);
        
        label_t_date.setFont(new Font("Mootype Corsiva", 0, 16));
        label_t_date.setBounds(350 ,405, 200, 50);
        getContentPane().add(label_t_date);
        
        text_t_date=new JLabel();
        text_t_date.setFont(new Font("Courier New", 1, 16));
//        text_t_date.setEditable(false);
        text_t_date.setBounds(450,420,150,20);
        getContentPane().add(text_t_date);
        
        label_f_place.setFont(new Font("Mootype Corsiva", 0, 16));
        label_f_place.setBounds(10 ,435, 200, 50);
        getContentPane().add(label_f_place);
        
        text_f_place=new JLabel();
        text_f_place.setFont(new Font("Courier New", 1, 16));
//        text_f_place.setEditable(false);
        text_f_place.setBounds(150,450,150,20);
        getContentPane().add(text_f_place);
		
		label_t_place.setFont(new Font("Mootype Corsiva", 0, 16));
        label_t_place.setBounds(350 ,435, 200, 50);
        getContentPane().add(label_t_place);
        
        text_t_place=new JLabel();
        text_t_place.setFont(new Font("Courier New", 1, 16));
//        text_t_place.setEditable(false);
        text_t_place.setBounds(450,450,150,20);
        getContentPane().add(text_t_place);
        
        label_v_no.setFont(new Font("Mootype Corsiva", 0, 16));
        label_v_no.setBounds(10 ,495, 150, 50);
        getContentPane().add(label_v_no);
        
        text_v_no=new JLabel();
        text_v_no.setFont(new Font("Courier New", 1, 16));
//        text_v_no.setEditable(false);
        text_v_no.setBounds(150,510,150,20);
        getContentPane().add(text_v_no);
        
        label_v_capacity.setFont(new Font("Mootype Corsiva", 0, 16));
        label_v_capacity.setBounds(350 ,495, 200, 50);
        getContentPane().add(label_v_capacity);
        
        text_v_capacity=new JLabel();
        text_v_capacity.setFont(new Font("Courier New", 1, 16));
//        text_v_capacity.setEditable(false);
        text_v_capacity.setBounds(450,510,75,20);
        getContentPane().add(text_v_capacity);
        
        label_box.setFont(new Font("Mootype Corsiva", 0, 16));
        label_box.setBounds(540 ,495, 200, 50);
        getContentPane().add(label_box);
	
		label_d_no.setFont(new Font("Mootype Corsiva", 0, 16));
        label_d_no.setBounds(10 ,525, 200, 50);
        getContentPane().add(label_d_no);
        
        text_d_no=new JLabel();
        text_d_no.setFont(new Font("Courier New", 1, 16));
//        text_d_no.setEditable(false);
        text_d_no.setBounds(150,540,150,20);
        getContentPane().add(text_d_no);
        
        label_d_phone.setFont(new Font("Mootype Corsiva", 0, 16));
        label_d_phone.setBounds(350 ,525, 200, 50);
        getContentPane().add(label_d_phone);
        
        text_d_phone=new JLabel();
        text_d_phone.setFont(new Font("Courier New", 1, 16));
//        text_d_phone.setEditable(false);
        text_d_phone.setBounds(450,540,150,20);
        getContentPane().add(text_d_phone);
        
        label_d_name.setFont(new Font("Mootype Corsiva", 0, 16));
        label_d_name.setBounds(10 ,555, 200, 50);
        getContentPane().add(label_d_name);
        
        text_d_name=new JLabel();
        text_d_name.setFont(new Font("Courier New", 1, 16));
//        text_d_name.setEditable(false);
        text_d_name.setBounds(150,570,450,20);
        getContentPane().add(text_d_name);
        
        try
		{
			setconnection();
			
			String sql2="SELECT * FROM customer WHERE c_no="+custid;
			st.executeQuery(sql2);
			
			rs=st.getResultSet();
			Object driver_no=0,vehicle_no=0;
			
			while(rs.next())
			{
				text_c_no.setText(Integer.toString(rs.getInt("c_no")));
				text_c_phone.setText(rs.getString("c_phone_no"));
				text_c_name.setText(rs.getString("c_name"));
				text_c_addr.setText(rs.getString("c_addr"));
				
				text_p_name.setText(rs.getString("front_party_name"));
				text_p_addr.setText(rs.getString("front_party_addr"));
				text_p_phone.setText(rs.getString("front_party_phone_no"));
				
				text_i_name.setText(rs.getString("i_name"));
				text_i_quantity.setText(Integer.toString(rs.getInt("quantity")));
				text_i_rate.setText(Integer.toString(rs.getInt("rate")));
				text_total_amount.setText(Integer.toString(rs.getInt("total_amount")));
				
				text_f_date.setText(rs.getString("from_date"));
				text_t_date.setText(rs.getString("to_date"));
				text_f_place.setText(rs.getString("from_place"));
				text_t_place.setText(rs.getString("to_place"));
				
				text_v_no.setText(Integer.toString(rs.getInt("v_no")));
				text_d_no.setText(Integer.toString(rs.getInt("d_no")));
				driver_no=text_d_no.getText();
				vehicle_no=text_v_no.getText();
	    	}
			
			String sql3="SELECT d_name,d_phone_no FROM driver WHERE d_no="+driver_no;
			st.executeQuery(sql3);
			
			rs=st.getResultSet();
			
			while(rs.next())
			{
				text_d_phone.setText(rs.getString("d_phone_no"));
				text_d_name.setText(rs.getString("d_name"));
			}
			
			String sql4="SELECT capacity FROM vehicle WHERE v_no="+vehicle_no;
			st.executeQuery(sql4);
			
			rs=st.getResultSet();
			
			while(rs.next())
			{
				text_v_capacity.setText(Integer.toString(rs.getInt("capacity")));
			}
			
			con.commit();
        	con.close();
		}
		catch(Exception e)
		{
			String dt="ERROR";
			String dm="PLEASE ENTER CUSTOMER NO.";
			int dtype=JOptionPane.INFORMATION_MESSAGE;
			JOptionPane.showMessageDialog((Component)null,dm,dt,dtype);
		}
        
        bprint.setBounds(180,620,100,40);		
		getContentPane().add(bprint);
		bprint.addActionListener(this);
		
		bclose.setBounds(370,620,100,40);		
		getContentPane().add(bclose);
		bclose.addActionListener(this);

		setVisible(true);
	} 		
}
	
	public void actionPerformed(ActionEvent event)
    {
    	Object source = event.getSource();
        if(source.equals(bprint))
        {
        	dispose();
        }
        else
        if(source.equals(bclose))
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
}