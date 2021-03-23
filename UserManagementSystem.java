package Systems;
import java.util.*;

public class UserManagementSystem {
	static Scanner command = new Scanner(System.in);
	static String text = "";
	static char civil = '\0';
	static ArrayList<String> firstnamelist = new ArrayList<String>();
	static ArrayList<String> lastnamelist = new ArrayList<String>();
	static ArrayList<String> addresslist = new ArrayList<String>();
	static ArrayList<Integer> agelist = new ArrayList<Integer>();
	static ArrayList<String> civilstatlist = new ArrayList<String>();
	
	public static void main(String[]args) {
		while(!text.equals("exit")) {
		System.out.println("What would you like to do?");
		System.out.println("Type Help for list of commands");
		text = command.nextLine();
		if(text.equalsIgnoreCase("help"))
			help();
		else if(text.equalsIgnoreCase("add")) 
			add();
		else if(text.equalsIgnoreCase("view")) 
			view();
		else if(text.equalsIgnoreCase("update"))
			update();
		else if(text.equalsIgnoreCase("delete"))
			delete();
		else if(text.equalsIgnoreCase("exit"))
			break;
			}
	}
	static void help() {
		System.out.println("List of Commands");
		System.out.println("add - to add another user");
		System.out.println("view - to view the data of a user ");
		System.out.println("delete - to delete a user");
		System.out.println("update - to update the data of a user");
		System.out.println("exit - to terminate the system ;(");
	}
	static void add() {
		System.out.println("First Name: ");
		text = command.nextLine();
		firstnamelist.add(text);
		
		System.out.println("Last Name: ");
		text = command.nextLine();
		lastnamelist.add(text);
		
		System.out.println("Address: ");
		text = command.nextLine();
		addresslist.add(text);
		
		System.out.println("Age: ");
		try {
			int b = Integer.parseInt(command.nextLine());
			agelist.add(b);
		} catch(NumberFormatException e){
			System.out.println("Please type a number:");
			String b = command.nextLine();
			while(intchecker(b) == false) {
				System.out.println("Please type a number:");
				b = command.nextLine();
			}
			int c = Integer.parseInt(b);
			agelist.add(c);
		}
		
		System.out.println("Civil Status: ");
		System.out.println("Please choose from (M/S/D/W)");
		civil = command.next().charAt(0);
		while(CivilString(civil).equals("undefined")) {
			System.out.println("Please choose from (M/S/D/W)");
			civil = command.next().charAt(0);
		}
		text = command.nextLine();
		civilstatlist.add(CivilString(civil));
	}
	
	static void view() {
		System.out.println("Which would user would you like view?");
		System.out.println("Type the number on the left");
		showall();
				
		try {
		int n = Integer.parseInt(command.nextLine());
		System.out.println("First Name: " + firstnamelist.get(n));
		System.out.println("Last Name: " + lastnamelist.get(n));
		System.out.println("Address: "+addresslist.get(n));
		System.out.println("Age: "+agelist.get(n));
		System.out.println("Civil Status: "+civilstatlist.get(n));
		}catch(Exception e) {
			tryagain();
		}
	}

	static void update() {
		System.out.println("Which user would you like to update?");
		showall();
		try{int b = Integer.parseInt(command.nextLine());		
		
		System.out.println("First Name: ");
		text = command.nextLine();
		firstnamelist.set(b,text);
		
		System.out.println("Last Name: ");
		text = command.nextLine();
		lastnamelist.set(b, text);
		
		System.out.println("Address: ");
		text = command.nextLine();
		addresslist.set(b,text);
		
		System.out.println("Age: ");
		try {
			int d = Integer.parseInt(command.nextLine());
			agelist.set(b,d);
		} catch(NumberFormatException e){
			System.out.println("Please type a number:");
			String d = command.nextLine();
			while(intchecker(d) == false) {
				System.out.println("Please type a number:");
				d = command.nextLine();	}
			int c = Integer.parseInt(d);
			agelist.set(b,c); 
		}
		
		System.out.println("Civil Status:");
		civil = command.next().charAt(0);
		while(CivilString(civil).equals("undefined")) {
			System.out.println("Please choose from (M/S/D/W)");
			civil = command.next().charAt(0);
			text = command.nextLine();

		}
		civilstatlist.set(b,CivilString(civil));
		}catch(Exception e) {
			tryagain();
		}
	}

	static void delete() {
		System.out.println("Which user would you like to delete?");
		showall();
		try{int b = Integer.parseInt(command.nextLine());
		firstnamelist.remove(b);
		addresslist.remove(b);
		agelist.remove(b);
		civilstatlist.remove(b);
		}catch(Exception e) 
		{tryagain();}
	}
	

	static void showall() {
		for(int i = 0 ; i <= firstnamelist.size() - 1; i++) {
			System.out.println(i +": " + firstnamelist.get(i));
		}
		
	}
	 
	static void tryagain() {
		System.out.println("Try again");
	}
	static boolean intchecker(String b) {
		try {
			int c = Integer.parseInt(b);
			return true;
		} catch(Exception e) {	
			return false;
		}
	}

	static String CivilString(char a) {
		String b = Character.toString(a);
		if(b.equalsIgnoreCase("M"))
			return "Married";
		else if(b.equalsIgnoreCase("S"))
			return "Single";
		else if(b.equalsIgnoreCase("D"))
			return "Divorced";
		else if(b.equalsIgnoreCase("W"))
			return "Widowed";
		else
			return "undefined";
		
	}

}