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
	
	public Artist(){};
	
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
	
	public int getId() {return _id;}
	public String getMail() {return _mail;}
	public String getPassword() {return _password;}
	public String getPhone() {return _phone;}
	public String getWebSite() {return _webSite;}
	public String getName() {return _name;}
	public String getFullName() {return _firstName + " " + _name;}
	public String getDescription() {return _description;}
	public String getFirstName() {return _firstName;}
	public String getPathAvatar() {return _pathAvatar;}
	
	public void setId(int _id) {this._id = _id;}
	public void setMail(String mail) {this._mail = mail;}
	public void setPassword(String password) {this._password = password;}
	public void setPhone(String phone) {this._phone = phone;}
	public void setWebSite(String webSite) {this._webSite = webSite;}
	public void setName(String name) {this._name = name;}
	public void setDescription(String description) {this._description = description;}
	public void setFirstName(String firstName) {this._firstName = firstName;}
	public void setPathAvatar(String pathAvatar) {this._pathAvatar = pathAvatar;}
}
