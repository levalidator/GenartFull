package com.genart.beans;

import java.util.Date;

import commons.DateExtension;

public class Template 
{
	private int _id;
	private String _name;
	private Date _date;
	private String _description;
	private int _idArtist;
	private float _montant;
	private Date _created_at;
	private String _image;

	public Template(){}
	
	public Template(int id, String name, String date, String description, int idArtist, float montant, String createdAt, String image)
	{
		this._id = id;
		this._name = name;
		this._date = DateExtension.toDate(date);
		this._description = description;
		this._idArtist = idArtist;
		this._montant = montant;
		this._created_at = DateExtension.toDate(createdAt);
		this._image = image;
	}
	
	public Template(int id, String name, Date date, String description, int idArtist, float montant, Date createdAt, String image)
	{
		this._id = id;
		this._name = name;
		this._date = date;
		this._description = description;
		this._idArtist = idArtist;
		this._montant = montant;
		this._created_at = createdAt;
		this._image = image;
	}
	
	public int getId() { return _id; }
	public String getName() { return _name; }
	public Date getDate() { return _date; }
	public String getDescription() { return _description; }
	public int getIdArtist() { return _idArtist; }
	public float getMontant() { return _montant; }
	public Date getCreatedAt() { return _created_at; }
	public String getImage() { return _image; }

	public void setId(int id) { this._id = id; }
	public void setName(String name) { this._name = name; }
	public void setDate(Date date) { this._date = date; }
	public void setDateString(String date) { this._date = DateExtension.toDate(date); }
	public void setDescription(String description) { this._description = description; }
	public void setIdArtist(int idartist) { this._idArtist = idartist; }
	public void setMontant(float montant) { this._montant = montant; }
	public void setCreatedAt(Date createdat) { this._created_at = createdat; }
	public void setCreatedAtString(String createdat) { this._created_at = DateExtension.toDate(createdat); }
	public void setImage(String image) { this._image = image; }
}
