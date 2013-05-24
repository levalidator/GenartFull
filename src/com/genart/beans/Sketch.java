package com.genart.beans;

public class Sketch {
	private int _id;
	private int _idTemplate;
	private String _image;
	private int _numero;
	
	/**
	 * Default constructor for Sketch
	 */
	public Sketch() {}
	/**
	 * Constructor for Sketch
	 * @param id
	 * @param idTemplate
	 * @param image
	 * @param numero
	 */
	public Sketch(int id,int idTemplate, String image, int numero)
	{
		this._id = id; 
		this._idTemplate = idTemplate;
		this._image = image;
		this._numero = numero;
	}
	
	/**
	 * Getter for _id
	 * @return
	 */
	public int getId() { return _id;}
	/**
	 * Getter for _idTemplate
	 * @return
	 */
	public int getIdTemplate() { return _idTemplate; }
	/**
	 * Getter for _image
	 * @return
	 */
	public String getImage() { return _image; }
	/**
	 * Getter for _numero
	 * @return
	 */
	public int getNumero() { return _numero; }

	/**
	 * Setter for _id
	 * @param id
	 */
	public void setId(int id) { this._id = id; }
	/**
	 * Setter for _idTemplate
	 * @param idTemplate
	 */
	public void setIdTemplate(int idTemplate) { this._idTemplate = idTemplate; }
	/**
	 * Setter for _image
	 * @param image
	 */
	public void setImage(String image) { this._image = image; }
}
