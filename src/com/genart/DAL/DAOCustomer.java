package com.genart.DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Customer;

public class DAOCustomer {
	public static boolean InsertCustomer(Customer custo){
		try{
			String query = "INSERT INTO Customer (mailCustomer, passwordCustomer) VALUES " +
				   "('"+custo.getMailCustomer()
				   +"', '"+custo.getPasswordCustomer()+"');";
			
			AccesBDD.getStatement().execute(query);			
			return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public static Customer GetCustomerByMail(String mail){
		try{
			String query = "select * from Customer where mailCustomer = '"+mail+"'";
			ResultSet result = AccesBDD.getStatement().executeQuery(query);
			boolean exists = result.first();
			Customer custo;
			if (exists){
				custo = new Customer(Integer.parseInt(result.getString("id Customer")), result.getString("mailCustomer"), result.getString("passwordCustomer"));
			} else {
				custo = null;
			}
			
			return custo;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static List<Customer> GetListCustomer(int limit){
		List<Customer> listCustomers = null;
		
		String query = "SELECT * FROM Customer";
		query += limit == 0 ? "" :  "LIMIT 0," + limit;
		try
		{
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			listCustomers = new ArrayList<Customer>();
			
    		while (results.next())
    		{
    		 	Customer customer = new Customer(
    		 			Integer.parseInt(results.getString("id Customer")),
    		 			results.getString("mailCustomer"),
    		 			results.getString("passwordCustomer")
    		 	);
    		 	
    		 	listCustomers.add(customer);
    		}
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    	}
		return listCustomers;
	}
	
	public static int GetNextId(){
		try 
		{	
			String query = "select max(id customer) as max from Customer";
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			boolean exists = results.first();
			int maxId; 
			if (exists){
				maxId = Integer.parseInt(results.getString("max")) + 1;
			} else {
				maxId = 0;
			}
			return maxId;
    	}
		catch (Exception e)
    	{
    		System.out.println(e.getMessage());
    		return 0;
    	}
	}
}
