package com.genart.beans;

public class Customer {
	private int _idCustomer;
	private String _mailCustomer;
	private String _passwordCustomer;
	
	/**
	 *  Default constructor for Customer class
	 */
	public Customer(){};
	
	/**
	 *  Constructor with parameters for Customer class
	 */
	public Customer(int idCustomer, String mailCustomer, String passwordCustomer){
		this.setIdCustomer(idCustomer);
		this.setMailCustomer(mailCustomer);
		this.setPasswordCustomer(passwordCustomer);
	}
	
	/**
	 * Getter for idCustomer 
	 */
	public int getIdCustomer() {return _idCustomer;}
	
	/**
	 * Getter for mailCustomer
	 */
	public String getMailCustomer() {return _mailCustomer;}
	
	/**
	 * Getter for passwordCustomer
	 */
	public String getPasswordCustomer() {return _passwordCustomer;}
	
	/**
	 * Setter for idCustomer
	 */
	public void setIdCustomer(int _idCustomer) {this._idCustomer = _idCustomer;}
	
	/**
	 * Setter for mailCustomer
	 */
	public void setMailCustomer(String _mailCustomer) {this._mailCustomer = _mailCustomer;}
	
	/**
	 * Setter for passwordCustomer
	 */
	public void setPasswordCustomer(String _passwordCustomer) {this._passwordCustomer = _passwordCustomer;}
	
}
