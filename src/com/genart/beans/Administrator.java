package com.genart.beans;

public class Administrator {
	private int _idAdministrator;
	private String _mailAdministrator;
	private String _passwordAdministrator;
	
	/**
	 * Default constructor for Administrator class
	 */
	public Administrator(){};
	/**
	 * Contructor for Administrator class
	 * @param idAdministrator
	 * @param mailAdministrator
	 * @param passwordAdministrator
	 */
	public Administrator(int idAdministrator, String mailAdministrator, String passwordAdministrator){
		this.setIdAdministrator(idAdministrator);
		this.setMailAdministrator(mailAdministrator);
		this.setPasswordAdministrator(passwordAdministrator);
	}
	
	/**
	 * Getter for _idAdministrator
	 * @return
	 */
	public int getIdAdministrator() {return _idAdministrator;}
	/**
	 * Getter for _mailAdministrator
	 * @return
	 */
	public String getMailAdministrator() {return _mailAdministrator;}
	/**
	 * Getter for _passwordAdministrator
	 * @return
	 */
	public String getPasswordAdministrator() {return _passwordAdministrator;}
	
	/**
	 * Setter for _idAdministrator
	 * @param _idAdministrator
	 */
	public void setIdAdministrator(int _idAdministrator) {this._idAdministrator = _idAdministrator;}
	/**
	 * Setter for _mailAdministrator
	 * @param _mailAdministrator
	 */
	public void setMailAdministrator(String _mailAdministrator) {this._mailAdministrator = _mailAdministrator;}
	/**
	 * Setter for _passwordAdministrator
	 * @param _passwordAdministrator
	 */
	public void setPasswordAdministrator(String _passwordAdministrator) {this._passwordAdministrator = _passwordAdministrator;}
}
