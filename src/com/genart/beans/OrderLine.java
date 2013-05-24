package com.genart.beans;

public class OrderLine {
	private int _idItem;
	private int _idCommande;
	private float _montant;
	private int _idSketch;
	private int _idSupport;

	public int getIdItem() { return _idItem; }
	public int getIdCommande() { return _idCommande; }
	public float getMontant() { return _montant; }
	public int getIdSketch() { return _idSketch; }
	public int getIdSupport() { return _idSupport; }

	public void setIdItem(int idItem) { _idItem = idItem; }
	public void setIdCommande(int idCommande) { _idCommande = idCommande; }
	public void setMontant(float montant) { _montant = montant; }
	public void setIdSketch(int idSketch) { _idSketch = idSketch; }
	public void setIdSupport(int idSupport) { _idSupport = idSupport; }
}
