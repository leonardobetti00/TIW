package it.polimi.tiw.test.project.beans;

import java.util.*;
import java.util.ArrayList;

public class User {

	private int id;
	private String username;
	private String name;
	private String surname;
	private  ArrayList<folder> folders = new ArrayList(); 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public ArrayList<folder> getfolder() {
		return this.folders;
	}
	public void addFolder (folder f){this.folders.add(f);}

	public void setSurname(folder fold) {
		this.folders.add(fold);
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
