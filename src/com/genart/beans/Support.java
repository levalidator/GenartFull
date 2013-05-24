package com.genart.beans;

public class Support {
	private int _id;
	private float _dimention_x;
	private float _dimention_y;
	private float _dimention_z;
	private String _name;
	private String _description;
	private float _montant;
	
	/**
	 * Default constructor for Support
	 */
	public Support() {}
	/**
	 * Constructor for Support
	 * @param id
	 * @param dimension_x
	 * @param dimension_y
	 * @param dimension_z
	 * @param name
	 * @param description
	 * @param montant
	 */
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

	/**
	 * Getter for _id
	 * @return
	 */
	public int getId() { return _id;}
	/**
	 * Getter for _dimension_x
	 * @return
	 */
	public float getDimensionX() { return _dimention_x; }
	/**
	 * Getter for _dimension_y
	 * @return
	 */
	public float getDimensionY() { return _dimention_y; }
	/**
	 * Getter for _dimension_z
	 * @return
	 */
	public float getDimensionZ() { return _dimention_z; }
	/**
	 * Getter for _name
	 * @return
	 */
	public String getName() { return _name; }
	/**
	 * Getter for _description
	 * @return
	 */
	public String getDescription() { return _description; }
	/**
	 * Getter for _montant
	 * @return
	 */
	public float getMontant() { return _montant; }

	/**
	 * Setter for _id
	 * @param id
	 */
	public void setId(int id) { this._id = id ; }
	/**
	 * Setter for _dimension_x
	 * @param dimension_x
	 */
	public void setDimensionX(float dimension_x) { this._dimention_x = dimension_x ; }
	/**
	 * Setter for _dimension_y
	 * @param dimension_y
	 */
	public void setDimensionY(float dimension_y) { this._dimention_y = dimension_y ; }
	/**
	 * Setter for _dimension_z
	 * @param dimension_z
	 */
	public void setDimensionZ(float dimension_z) { this._dimention_z = dimension_z ; }
	/**
	 * Setter for _name
	 * @param name
	 */
	public void setName(String name) { this._name = name ; }
	/**
	 * Setter for _description
	 * @param description
	 */
	public void setDescription(String description) { this._description = description ; }
	/**
	 * Setter for _montant
	 * @param montant
	 */
	public void setMontant(float montant) { this._montant = montant ; }
}
