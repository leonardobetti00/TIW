package it.polimi.tiw.test.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import it.polimi.tiw.test.project.beans.*;
//import it.polimi.tiw.test.project.beans.User;

public class creaDAO {
    private Connection con;
    private int cosaCrea;  // ->0 = folder, 1 = subfolder ->2 = file
    private User u;
    private folder f;
    private Subfolder sf;
    public  String name;
    public creaDAO(Connection connection) {
        this.con = connection;
    }


    public void cosaCrea (int cosaCrea) throws SQLException {
    switch (cosaCrea){
        case 0: creaFolder(name,u);
        case 1: creaSubFolder(name, u, f);
        case 2: creaDocument(name,sf,u,f);
    }
   }

   public void creaFolder (String name, User user)throws SQLException{
       String query = "INSERT INTO folder (name, user) VALUES (?,?)";
       folder newFolder = new folder();
       try (PreparedStatement pstatement = con.prepareStatement(query);) {
           pstatement.setString(1, name);
           pstatement.setString(2, user.getName());
           try (ResultSet result = pstatement.executeQuery();) {
                newFolder.setname(name);
                newFolder.setUser(user.getName());
                user.addFolder(newFolder);

           }
       }

   }


    public void creaSubFolder (String name, User user, folder f)throws SQLException{
        String query = "INSERT INTO subfolder (name, folder, user) VALUES (?,?,?)";
        Subfolder newSubFolder = new Subfolder();
        try (PreparedStatement pstatement = con.prepareStatement(query);) {
            pstatement.setString(1, name);
            pstatement.setString(2, f.getname());
            pstatement.setString(3, user.getName());
            try (ResultSet result = pstatement.executeQuery();) {
                newSubFolder.setname(name);
                newSubFolder.setFolder(f);
                newSubFolder.setUser(user);
                f.addSubFolder(newSubFolder);

            }
        }
    }

    public void creaDocument (String name, Subfolder sf, User user, folder f)throws SQLException{
        String query = "INSERT INTO document (name,sf, folder, user) VALUES (??,?,?)";
        document newDocument = new document();
        try (PreparedStatement pstatement = con.prepareStatement(query);) {
            pstatement.setString(1, name);
            pstatement.setString(2, sf.getname());
            pstatement.setString(3, f.getname());
            pstatement.setString(4, user.getName());
            try (ResultSet result = pstatement.executeQuery();) {
                newDocument.setname(name);
                newDocument.setFolder(f);
                newDocument.setSubfolder(sf);
                newDocument.setUser(user);
                sf.addDocument(newDocument);

            }
        }
    }
}

