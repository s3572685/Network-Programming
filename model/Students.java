package model;

import java.util.LinkedList;

public interface Students {
	//return the student id 
	public abstract int getID();
	//set the student id 
	public abstract void setID(int id);
	//return the ports
	public abstract int[] getPorts();
	//set the ports
	public abstract void setPorts(LinkedList<Integer> ports);
	//display the ports
	public abstract String displayPorts();
}
