package com.genart.beans;

public class Artist 
{
	private int _id;
	private String _mail;
	private String _password;
	private String _phone;
	private String _webSite;
	private String _name;
	private String _firstName;
	private String _description;
	private String _pathAvatar;
	
	/**
	 * Default contructor for Artist
	 */
	public Artist(){};
	
	/**
	 * Constructor for Artist
	 * @param id
	 * @param mail
	 * @param password
	 * @param phone
	 * @param webSite
	 * @param name
	 * @param firstName
	 * @param description
	 * @param pathAvatar
	 */
	public Artist(int id, String mail, String password, String phone, String webSite, String name, String firstName, String description, String pathAvatar)
	{
		this._id = id; 
		this._mail = mail;
		this._password = password;
		this._phone = phone;
		this._webSite = webSite;
		this._name = name;
		this._firstName = firstName;
		this._description = description;
		this._pathAvatar = pathAvatar;
	}
	
	/**
	 * Getter for _id
	 * @return
	 */
	public int getId() {return _id;}
	/**
	 * Getter for _mail
	 * @return
	 */
	public String getMail() {return _mail;}
	/**
	 * Getter for _password
	 * @return
	 */
	public String getPassword() {return _password;}
	/**
	 * Getter for _phone
	 * @return
	 */
	public String getPhone() {return _phone;}
	/**
	 * Getter for _website
	 * @return
	 */
	public String getWebSite() {return _webSite;}
	/**
	 * Getter for _name
	 * @return
	 */
	public String getName() {return _name;}
	/**
	 * Return the full name (_firstname + _name, separated by a space)
	 * @return
	 */
	public String getFullName() {return _firstName + " " + _name;}
	/**
	 * Getter for _description
	 * @return
	 */
	public String getDescription() {return _description;}
	/**
	 * Getter for _firstName
	 * @return
	 */
	public String getFirstName() {return _firstName;}
	/**
	 * Getter for _pathAvatar
	 * @return
	 */
	public String getPathAvatar() {return _pathAvatar;}
	
	/**
	 * Setter for _id
	 * @param _id
	 */
	public void setId(int _id) {this._id = _id;}
	/**
	 * Setter for _mail
	 * @param mail
	 */
	public void setMail(String mail) {this._mail = mail;}
	/**
	 * Setter for _password
	 * @param password
	 */
	public void setPassword(String password) {this._password = password;}
	/**
	 * Setter for _phone
	 * @param phone
	 */
	public void setPhone(String phone) {this._phone = phone;}
	/**
	 * Setter for _website
	 * @param webSite
	 */
	public void setWebSite(String webSite) {this._webSite = webSite;}
	/**
	 * Setter for _name
	 * @param name
	 */
	public void setName(String name) {this._name = name;}
	/**
	 * Setter for _description
	 * @param description
	 */
	public void setDescription(String description) {this._description = description;}
	/**
	 * Setter for _firstname
	 * @param firstName
	 */
	public void setFirstName(String firstName) {this._firstName = firstName;}
	/**
	 * Setter for _pathAvatar
	 * @param pathAvatar
	 */
	public void setPathAvatar(String pathAvatar) {this._pathAvatar = pathAvatar;}
}
