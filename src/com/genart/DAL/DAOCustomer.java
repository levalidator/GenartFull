package com.genart.DAL;

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
}
