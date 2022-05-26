package it.polimi.tiw.test.project.beans;

import java.util.ArrayList;
import java.util.List;

public class Subfolder {
	private String name;
	private ArrayList<document> documents = new ArrayList(); 

	public String  getname() {
		return this.name;
	}

	public void setname(String name) {
		this.name =name;
	}

	public ArrayList<document> getdocument() {
		return this.documents;
	}

	public void setSurname(document fold) {
		this.documents.add(fold);
	}

}
