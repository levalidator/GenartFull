package com.genart.beans;

public class Sketch {
	private int _id;
	private int _idTemplate;
	private String _image;
	
	public Sketch() {}
	public Sketch(int id,int idTemplate, String image)
	{
		this._id = id;
		this._idTemplate = idTemplate;
		this._image = image;
	}
	
	public int getId() { return _id;}
	public int getIdTemplate() { return _idTemplate; }
	public String getImage() { return _image; }

	public void setId(int id) { this._id = id; }
	public void setIdTemplate(int idTemplate) { this._idTemplate = idTemplate; }
	public void setImage(String image) { this._image = image; }
}
