import java.util.LinkedList;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class test1 {

	public static void main(String[] args) {
		boolean continuing=true;
		LinkedList<Student> studentlist=new LinkedList<Student>();
		
		while(continuing==true) {
			@SuppressWarnings("resource")
			Scanner input=new Scanner(System.in);
			System.out.print("Enter the student ID:");
			String UserInput=input.nextLine();
			int id = 0;
			//check if the input is empty or not
			if(UserInput!=null&&!UserInput.isEmpty()) {
				
				try {
					id=Integer.parseInt(UserInput);
					
					Student user=new Student();
					user.setID(id);
					//check if he has been allocated before
					if(!studentlist.isEmpty()) {
						for(int i=0; i<=studentlist.size(); i++) {
							Student temp=studentlist.get(i);
							if(user.getID()==temp.getID()) {
								System.out.println("allocated already! Please check your email!");
							}else {
								//add the student into the list
								studentlist.add(user);
							}
						}
					}
					
					//initialize the ports array
					LinkedList<Integer> ports=new LinkedList<Integer>();

					for(int i=0; i<=300; i++) {
						ports.add(i+700);
					}
					user.setPorts(ports);
					System.out.print("Ports for "+user.id+": "+user.displayPorts());
					System.out.println();
					System.out.print("Enter the email address:");
					String to=input.nextLine();

					//Sending from my email address
					String from="shottopang0418@gmail.com";
					String password="pangxiaotao0418";
					
					//Get System properties
					Properties properties=System.getProperties();
					properties.put("mail.smtp.port", "587");
					properties.put("mail.smtp.auth", "true");
					properties.put("mail.smtp.starttls.enable", "true");
					properties.put("mail.smtp.host", "smtp.gmail.com");
					
					
					
					//Get default Session objects
					Session session=Session.getDefaultInstance(properties, new Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(from, password);
						}
					});
					try {
						//create a default MimeMessage object
						MimeMessage message=new MimeMessage(session);
						
						//Set from: header field of the header
						message.setFrom(new InternetAddress(from));
						
						//Set to : header field of the header
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
						
						//Set Subject: header field
						message.setSubject("This is the NP testing!");
						
						//set the actual message
						message.setText("Ports for "+user.id+": "+user.displayPorts());
						
						//Send message
						Transport.send(message);
						System.out.println("Sent mail successfully...");
					}catch(MessagingException mex){
						mex.printStackTrace();
					}
					System.out.print("Next Student? (Y/N):");
					String choice=input.nextLine();
					if(choice.compareTo("N")==0) {
						System.out.println("Thank you!");
						continuing=false;
					}
					
				}catch(NumberFormatException e) {
					System.out.println("Please enter the valid number!");
				}
				
			}else {
				System.out.println("please enter the id");
			}
		}
		
	}
}
