package it.polimi.tiw.test.project.beans;

import java.util.ArrayList;
import java.util.List;

public class document {

	private int id;
	private String Owner;
	private String name;
	private String date;
	private String type;
	private folder f;
	private Subfolder sf;
	private User u;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return Owner;
	}

	public void setOwner(String username) {
		this.Owner = username;
	}
	
	public void setname(String username) {
		this.name = username;
	}

	public String getName() {
		return name;
	}

	public void setdate(String date) {
		this.date = date;
	}

	public String getdate() {
		return date;
	}

	public void setFolder (folder f){
		this.f = f;
	}
	public void setSubfolder (Subfolder sf){
		this.sf = sf;
	}
	public void setUser (User  u){
		this.u = u;
		this.Owner = u.getName();
	}


	public void setType(String type ) {
		this.type=type;
	}
	public String getType() {
		return this.type;
	}

}
