package it.polimi.tiw.test.project.beans;

import java.util.ArrayList;
import java.util.List;

public class folder {
private String name;
private ArrayList<Subfolder> subfolders = new ArrayList(); 

public String  getname() {
	return this.name;
}

public void setname(String name) {
	this.name =name;
}

public ArrayList<Subfolder> getfolder() {
	return this.subfolders;
}

public void addfolder(Subfolder fold) {
	this.subfolders.add(fold);
}

}
