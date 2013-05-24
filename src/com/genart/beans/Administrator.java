package com.genart.beans;

public class Administrator {
	private int _idAdministrator;
	private String _mailAdministrator;
	private String _passwordAdministrator;
	
	public Administrator(){};
	public Administrator(int idAdministrator, String mailAdministrator, String passwordAdministrator){
		this.setIdAdministrator(idAdministrator);
		this.setMailAdministrator(mailAdministrator);
		this.setPasswordAdministrator(passwordAdministrator);
	}
	 
	public int getIdAdministrator() {return _idAdministrator;}
	public String getMailAdministrator() {return _mailAdministrator;}
	public String getPasswordAdministrator() {return _passwordAdministrator;}
	
	public void setIdAdministrator(int _idAdministrator) {this._idAdministrator = _idAdministrator;}
	public void setMailAdministrator(String _mailAdministrator) {this._mailAdministrator = _mailAdministrator;}
	public void setPasswordAdministrator(String _passwordAdministrator) {this._passwordAdministrator = _passwordAdministrator;}
}
