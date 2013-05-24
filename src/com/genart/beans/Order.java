package com.genart.beans;

import java.util.List;

public class Order {
	private List<OrderLine> _lignes;
	private int _idCommand;
	private int _idCustomer;

	public int getIdCommand() {
		return _idCommand;
	}

	public int getIdCustomer() {
		return _idCustomer;
	}

	public List<OrderLine> getLignes() {
		return _lignes;
	}

	public void setLignes(List<OrderLine> lignes) {
		_lignes = lignes;
	}

	public void setIdCommand(int idCommand) {
		_idCommand = idCommand;
	}

	public void setIdCustomer(int idCustomer) {
		_idCustomer = idCustomer;
	}
}
