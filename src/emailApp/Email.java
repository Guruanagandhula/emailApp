
package emailApp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private int defaultpasswordLength=10;
	private String alternateEmail;
	private String companySuffix= "xyzcompany.com";
	
	//constructor
	public Email(String firstname,String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
		//System.out.println("Email Created: "+this.firstname+" "+this.lastname);
		//method for department
		this.department = setDepartment();
		//System.out.println("Department: " +this.department);
		//random password method
		this.password = randomPassword(defaultpasswordLength);
		System.out.println("Your Password is: " +this.password);
		//generate a email
		email = firstname.toLowerCase()+"."+lastname.toLowerCase()+"@"+department+"."+companySuffix;
		//System.out.println("Your email :" + email);
	}
	
	//department
	private String setDepartment() {
		System.out.print("New Worker: " +firstname+". Department Codes\n 1.sales \n 2.Development \n 3.Accounting \n 0.None \nEnter the Department Code: ");
		Scanner in=new Scanner(System.in);
		int depChoice = in.nextInt();
		if(depChoice == 1) return "sales";
		else if(depChoice == 2) return "dev"; 
		else if(depChoice == 3) return "acc"; 
		else return "";
	}
	
	//random password
	private String randomPassword(int length) {
		String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#$%";
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int rand=(int)(Math.random()*passwordSet.length());
			password[i]=passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity=capacity;
	}
	
	//alternate email
	public void setAlternateEmial(String altEmail) {
		this.alternateEmail =altEmail;
	}
	//password change
	public void changePassword(String password) {
		this.password=password;
	}
	public int getMailboxCapacity (){ return mailboxCapacity;}
	public String getAlternateEmail() { return alternateEmail;}
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "Display Name:" +firstname+" "+lastname+
				"\nComapany Email: " +email+
				"\nMailbox Capacity: "+mailboxCapacity + "mb";
	}

}
