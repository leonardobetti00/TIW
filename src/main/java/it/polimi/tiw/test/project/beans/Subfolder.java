package it.polimi.tiw.test.project.beans;

import java.util.ArrayList;
import java.util.List;

public class Subfolder {
	private String name;
	private ArrayList<document> documents = new ArrayList();
	private User u ;
	private folder f;


	public String  getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name =name;
	}
	public void setUser(User u) {
		this.u = u;
	}
	public void setFolder(folder f) {
		this.f =f;
	}

	public ArrayList<document> getdocument() {
		return this.documents;
	}

	public void setSurname(document fold) {
		this.documents.add(fold);
	}

	public void addDocument(document newDocument) {
		documents.add(newDocument);
	}
}
