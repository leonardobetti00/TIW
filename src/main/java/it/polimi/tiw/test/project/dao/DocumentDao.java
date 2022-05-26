package it.polimi.tiw.test.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import it.polimi.tiw.test.project.beans.*;

import it.polimi.tiw.test.project.beans.User;

public class DocumentDao {
	private Connection con;
	public DocumentDao(Connection connection) {
		this.con = connection;
	}

	public ArrayList<document> loadDocument(String usrn, String folder,String subfolder ) throws SQLException {
		String query = "SELECT  owner,name, date, type FROM document  WHERE owner= ? AND folder=? AND subfolder=?";
		try (PreparedStatement pstatement = con.prepareStatement(query);) {
			pstatement.setString(1, usrn);
			pstatement.setString(2, folder);
			pstatement.setString(3, subfolder);
			try (ResultSet result = pstatement.executeQuery();) {
				if (!result.isBeforeFirst()) // no results, credential check failed
					return null;
				else {
					ArrayList<document> documenti=new ArrayList<document>();
					while (result.next()) {
					document documento = new document();
					documento.setOwner(result.getString("owner"));
					documento.setdate(result.getString("date"));
					documento.setname(result.getString("name"));
					documento.setType(result.getString("type"));
					}
					return documenti;
				}
			}
		}
	}

}
