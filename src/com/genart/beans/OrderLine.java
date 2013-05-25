package com.genart.beans;

public class OrderLine {
	private int _idItem;
	private int _idCommande;
	private float _montant;
	private int _idSketch;
	private int _idSupport;

	/**
	 * Getter for idItem
	 * 
	 * @return
	 */
	public int getIdItem() {
		return _idItem;
	}

	/**
	 * Getter for IdCommande
	 * 
	 * @return
	 */
	public int getIdCommande() {
		return _idCommande;
	}

	/**
	 * Getter for Montant
	 * 
	 * @return
	 */
	public float getMontant() {
		return _montant;
	}

	/**
	 * Getter for IdSketch
	 * 
	 * @return
	 */
	public int getIdSketch() {
		return _idSketch;
	}

	/**
	 * Getter for IdSupport
	 * 
	 * @return
	 */
	public int getIdSupport() {
		return _idSupport;
	}

	/**
	 * Setter for idItem
	 * 
	 * @return
	 */
	public void setIdItem(int idItem) {
		_idItem = idItem;
	}

	/**
	 * Setter for IdCommande
	 * 
	 * @return
	 */
	public void setIdCommande(int idCommande) {
		_idCommande = idCommande;
	}

	/**
	 * Setter for Montant
	 * 
	 * @return
	 */
	public void setMontant(float montant) {
		_montant = montant;
	}

	/**
	 * Setter for IdSketch
	 * 
	 * @return
	 */
	public void setIdSketch(int idSketch) {
		_idSketch = idSketch;
	}

	/**
	 * Setter for IdSupport
	 * 
	 * @return
	 */
	public void setIdSupport(int idSupport) {
		_idSupport = idSupport;
	}
}
