import java.util.LinkedList;
import model.Students;

public class Student implements Students{
	
	int  id;
	int[] ports;
	
	public Student() {
		this.ports=new int[2];
	}
	
	public Student(int id, int[] ports) {
		this.id=id;
		this.ports=new int[2];
		this.ports=ports;
	}

	@Override
	public int getID() {
		return this.id;
	}

	@Override
	public void setID(int id) {
		this.id=id;
	}

	@Override
	public int[] getPorts() {
		return this.ports;
	}

	@Override
	public void setPorts(LinkedList<Integer> ports) {
		int n=0; //to check how many ports needed
		/*
		 * randomly pick up two numbers and delete them from the array
		 * */
		while(n<=1) {
			int random=(int)(Math.random()*ports.size()-1);
			this.ports[n]=ports.get(random);
			for(int i=0; i<=ports.size()-1; i++) {
				if(ports.get(i)==ports.get(random)) {
					ports.remove(i);
					break;
				}
			}
			n++;
		}
	}

	@Override
	public String displayPorts() {
		String printing = "";
		for(int i=0; i<=this.ports.length-1; i++) {
			printing+=this.ports[i]+". ";
		}	
		return printing;
	}
	
}
