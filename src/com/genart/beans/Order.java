package com.genart.beans;

import java.util.Date;
import java.util.List;

public class Order {
	private List<OrderLine> _lignes;
	private int _idCommand;
	private int _idCustomer;
	private Date _date;

	/**
	 * Getter for idCommand
	 * 
	 * @return
	 */
	public int getIdCommand() {
		return _idCommand;
	}

	/**
	 * Getter for IdCustomer
	 * 
	 * @return
	 */
	public int getIdCustomer() {
		return _idCustomer;
	}

	/**
	 * Getter for Date
	 * 
	 * @return
	 */
	public Date getDate() {
		return _date;
	}

	/**
	 * Getter for order's lines
	 * 
	 * @return
	 */
	public List<OrderLine> getLignes() {
		return _lignes;
	}

	/**
	 * Setter for idCommand
	 * 
	 * @return
	 */
	public void setIdCommand(int idCommand) {
		_idCommand = idCommand;
	}

	/**
	 * Setter for IdCustomer
	 * 
	 * @return
	 */
	public void setIdCustomer(int idCustomer) {
		_idCustomer = idCustomer;
	}

	/**
	 * Setter for Date
	 * 
	 * @return
	 */
	public void setDate(Date date) {
		_date = date;
	}

	/**
	 * Setter for order's lines
	 * 
	 * @return
	 */
	public void setLignes(List<OrderLine> lignes) {
		_lignes = lignes;
	}
}
