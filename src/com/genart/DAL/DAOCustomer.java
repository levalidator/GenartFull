package com.genart.DAL;

import java.sql.ResultSet;

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
}
