package it.polimi.tiw.test.project.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.polimi.tiw.test.project.beans.*;
import java.util.*;

public class FSdao {
	private Connection con;

	public FSdao(Connection connection) {
		this.con = connection;
	}
	
	public ArrayList<folder> loadfolder(String usrn) {
		ArrayList<folder> cartelle= new ArrayList<>();
		String query = "SELECT  name FROM folder  WHERE user = ?";
		try (PreparedStatement pstatement = con.prepareStatement(query);) {
			pstatement.setString(1, usrn);
			try (ResultSet result = pstatement.executeQuery();) {
				if (!result.isBeforeFirst()) // no results, no folder avaible
					{return null;}
				else {
					while(result.next()) {//per ogni folder
						folder cartella = new folder();
						cartella.setname(result.getString("name"));	
						String query2 = "SELECT  name FROM subfolder  WHERE user = ? AND folder =?";
						try (PreparedStatement pstatement2 = con.prepareStatement(query);) {
							pstatement2.setString(1, usrn);
							pstatement2.setString(1, cartella.getname());
							try (ResultSet result2 = pstatement2.executeQuery();) {
								if (!result2.isBeforeFirst()) // no results, no subfolder avaible
									return null;
								else {
									while (result2.next()){//per ogni subfolder
										Subfolder sottocartella = new Subfolder();
										sottocartella.setname(result2.getString("name"));
										cartella.addfolder(sottocartella);}}}}
						cartelle.add(cartella);}}}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cartelle;
		}}


