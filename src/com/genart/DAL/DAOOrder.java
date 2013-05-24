package com.genart.DAL;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.genart.bdd.AccesBDD;
import com.genart.beans.Order;
import com.genart.beans.OrderLine;

public class DAOOrder {
	public static List<Order> getListOrder(int idCustomer) {
		List<Order> result = new ArrayList<Order>();

		try {
			String query = "SELECT * FROM command c "
					+ "LEFT JOIN item i ON i.idCommand = c.idCommand "
					+ "WHERE c.idCustomer = " + idCustomer
					+ "ORDER BY idCommand";

			ResultSet resultset = AccesBDD.getStatement().executeQuery(query);

			int idCommand = 0;
			Order order = null;

			while (resultset.next()) {
				if (idCommand != resultset.getInt("idCommand")) {
					order = new Order();
					order.setIdCommand(idCommand = resultset
							.getInt("idCommand"));
					order.setIdCustomer(resultset.getInt("idCustomer"));
					order.setLignes(new ArrayList<OrderLine>());
					result.add(order);
				}

				OrderLine line = new OrderLine();
				line.setIdCommande(idCommand);
				line.setIdItem(resultset.getInt("idItem"));
				line.setIdSketch(resultset.getInt("idSketch"));
				line.setIdSupport(resultset.getInt("idSupport"));
				line.setMontant(resultset.getFloat("montant"));
				order.getLignes().add(line);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result.isEmpty() ? null : result;
	}

	public static boolean insertOrder(Order order) {
		try {
			String query = "INSERT INTO command(idCustomer, montant, created_at) VALUES("
					+ order.getIdCustomer()
					+ ","
					+ 0
					+ ","
					+ new SimpleDateFormat("yyyyMMdd").format(new Date())
					+ ");";

			AccesBDD.getStatement().execute(query);

			query = "SELECT LAST_INSERT_ID();";
			ResultSet result = AccesBDD.getStatement().executeQuery(query);
			result.first();
			int idCommand = result.getInt(1);

			query = "";

			for (OrderLine line : order.getLignes()) {

				query = "INSERT INTO sketch(idTemplate, imageSketch) VALUES("
						+ line.getIdSketch() + ",'');\r\n";
				
				AccesBDD.getStatement().execute(query);
				
				query = "SELECT LAST_INSERT_ID();";
				result = AccesBDD.getStatement().executeQuery(query);
				result.first();
				int idSketch = result.getInt(1);

				query = "INSERT INTO item(idCommand, idSketch, idSupport) VALUES("
						+ idCommand
						+ ","
						+ idSketch
						+ ","
						+ line.getIdSupport() + ");\r\n";
				
				AccesBDD.getStatement().execute(query);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
