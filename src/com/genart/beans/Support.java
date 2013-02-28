package com.genart.beans;

public class Support {
	private int _id;
	private float _dimention_x;
	private float _dimention_y;
	private float _dimention_z;
	private String _name;
	private String _description;
	private float _montant;
	
	public Support() {}
	public Support(int id, float dimension_x, float dimension_y, float dimension_z, String name, String description, float montant)
	{
		this._id = id;
		this._dimention_x = dimension_x;
		this._dimention_y = dimension_y;
		this._dimention_z = dimension_z;
		this._name = name;
		this._description = description;
		this._montant = montant;
	}

	public int getId() { return _id;}
	public float getDimensionX() { return _dimention_x; }
	public float getDimensionY() { return _dimention_y; }
	public float getDimensionZ() { return _dimention_z; }
	public String getName() { return _name; }
	public String getDescription() { return _description; }
	public float getMontant() { return _montant; }

	public void setId(int id) { this._id = id ; }
	public void setDimensionX(float dimension_x) { this._dimention_x = dimension_x ; }
	public void setDimensionY(float dimension_y) { this._dimention_y = dimension_y ; }
	public void setDimensionZ(float dimension_z) { this._dimention_z = dimension_z ; }
	public void setName(String name) { this._name = name ; }
	public void setDescription(String description) { this._description = description ; }
	public void setMontant(float montant) { this._montant = montant ; }
}
