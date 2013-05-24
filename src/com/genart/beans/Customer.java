package com.genart.beans;

public class Customer {
	private int _idCustomer;
	private String _mailCustomer;
	private String _passwordCustomer;
	
	public Customer(){};
	public Customer(int idCustomer, String mailCustomer, String passwordCustomer){
		this.setIdCustomer(idCustomer);
		this.setMailCustomer(mailCustomer);
		this.setPasswordCustomer(passwordCustomer);
	}
	
	public int getIdCustomer() {return _idCustomer;}
	public String getMailCustomer() {return _mailCustomer;}
	public String getPasswordCustomer() {return _passwordCustomer;}
	
	public void setIdCustomer(int _idCustomer) {this._idCustomer = _idCustomer;}
	public void setMailCustomer(String _mailCustomer) {this._mailCustomer = _mailCustomer;}
	public void setPasswordCustomer(String _passwordCustomer) {this._passwordCustomer = _passwordCustomer;}
}
