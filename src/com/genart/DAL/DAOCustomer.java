package com.genart.DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Artist;
import com.genart.beans.Customer;
/**
 * DAO for Customer class
 * @author The GenArt Team
 *
 */
public class DAOCustomer {
	/**
	 * Insert a Customer in database 
	 */
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
	
	/**
	 * Get a Customer by his mail 
	 */
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
	
	/**
	 * Returns the customers list 
	 */
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
	
	/**
	 * Get the max idCustomer in the Customer table 
	 */
	public static int GetNextId(){
		try 
		{	
			String query = "select max(`id Customer`) as max from Customer";
			ResultSet results = AccesBDD.getStatement().executeQuery(query);
			boolean exists = results.first();
			int maxId; 
			if (exists){
				maxId = Integer.parseInt(results.getString("max"));
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
	/**
	 * Update a customer
	 */
	public static boolean UpdateCustomer(Customer customer)
	{
		try{
			String query = "UPDATE Customer SET " 
						   + "mailCustomer = '"+customer.getMailCustomer()+"', "
						   + "passwordCustomer = '"+customer.getPasswordCustomer()+"' "
						   + "WHERE `id Customer` = '"+ customer.getIdCustomer() +"'";
			
			AccesBDD.getStatement().execute(query);			
			return true;
		} catch (Exception e){
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	/**
	 * Delete a customer 
	 */
	public static boolean DeleteCustomer(int idCustomer)
	{
		try {
			
			String query = "DELETE from Customer where `id Customer` = '"+ idCustomer +"'";
			AccesBDD.getStatement().execute(query);			
			
			return true;
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}
}
