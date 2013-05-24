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
	private String _pdePath;
	private String _namePde;

	/**
	 * Default constructor for Template
	 */
	public Template(){}
	
	/**
	 * Constructor for Template
	 * @param id
	 * @param name
	 * @param date
	 * @param description
	 * @param idArtist
	 * @param montant
	 * @param createdAt
	 * @param image
	 * @param pdePath
	 * @param namePde
	 */
	public Template(int id, String name, String date, String description, int idArtist, float montant, String createdAt, String image, String pdePath, String namePde)
	{
		this._id = id; 
		this._name = name;
		this._date = DateExtension.toDate(date);
		this._description = description;
		this._idArtist = idArtist;
		this._montant = montant;
		this._created_at = DateExtension.toDate(createdAt);
		this._image = image;
		this.setPdePath(pdePath);
		this._namePde = namePde;
	}
	
	/**
	 * Constructor for Template
	 * @param id
	 * @param name
	 * @param date
	 * @param description
	 * @param idArtist
	 * @param montant
	 * @param createdAt
	 * @param image
	 */
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
	
	/**
	 * Getter for _id
	 * @return
	 */
	public int getId() { return _id; }
	/**
	 * Getter for _name
	 * @return
	 */
	public String getName() { return _name; }
	/**
	 * Getter for _date
	 * @return
	 */
	public Date getDate() { return _date; }
	/**
	 * Getter for _description
	 * @return
	 */
	public String getDescription() { return _description; }
	/**
	 * Getter for _idArtist
	 * @return
	 */
	public int getIdArtist() { return _idArtist; }
	/**
	 * Getter for _montant
	 * @return
	 */
	public float getMontant() { return _montant; }
	/**
	 * Getter for _created_at
	 * @return
	 */
	public Date getCreatedAt() { return _created_at; }
	/**
	 * Getter for _image
	 * @return
	 */
	public String getImage() { return _image; }

	/**
	 * Setter for _id
	 * @param id
	 */
	public void setId(int id) { this._id = id; }
	/**
	 * Setter for _name
	 * @param name
	 */
	public void setName(String name) { this._name = name; }
	/**
	 * Setter for _date
	 * @param date
	 */
	public void setDate(Date date) { this._date = date; }
	/**
	 * Setter for _date from a string
	 * @param date
	 */
	public void setDateString(String date) { this._date = DateExtension.toDate(date); }
	/**
	 * Setter for _description
	 * @param description
	 */
	public void setDescription(String description) { this._description = description; }
	/**
	 * Setter for _idArtist
	 * @param idartist
	 */
	public void setIdArtist(int idartist) { this._idArtist = idartist; }
	/**
	 * Setter for _montant
	 * @param montant
	 */
	public void setMontant(float montant) { this._montant = montant; }
	/**
	 * Setter for _created_at
	 * @param createdat
	 */
	public void setCreatedAt(Date createdat) { this._created_at = createdat; }
	/**
	 * Setter for _created_at from a string
	 * @param createdat
	 */
	public void setCreatedAtString(String createdat) { this._created_at = DateExtension.toDate(createdat); }
	/**
	 * Setter for _image
	 * @param image
	 */
	public void setImage(String image) { this._image = image; }

	/**
	 * Getter for _pdePath
	 * @return
	 */
	public String getPdePath() {
		return _pdePath;
	}

	/**
	 * Setter for _pdePath
	 * @param _pdePath
	 */
	public void setPdePath(String _pdePath) {
		this._pdePath = _pdePath;
	}
	
	/**
	 * Return the path of the current form
	 * @return
	 */
	public String getFormPath(){
      String chaine = "../forms/form_newyork-";
      chaine += this.getId();
      chaine += ".jsp";
      return chaine;
	}

	/**
	 * Getter for _namePde
	 * @return
	 */
	public String getNamePde() {
		return _namePde;
	}

	/**
	 * Setter for _namePde
	 * @param _namePde
	 */
	public void setNamePde(String _namePde) {
		this._namePde = _namePde;
	}
}
