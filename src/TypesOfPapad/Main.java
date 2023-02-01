package TypesOfPapad;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	
	int id;
	String fname, lname;
	String papadtypes;
	int quantity;
	
	
	Main(){

		Scanner sc = new Scanner(System.in);
        System.out.println("<<<<<<<<<<<<<<<<<<<< Welcome To Chopade Papad Gruha Udyog >>>>>>>>>>>>>>>>>>>>");
        System.out.println("Buy 20 pk And Get 10 % Discount \n ");
        
        System.out.println("Enter your firstName");
		fname = sc.nextLine();
		
		System.out.println("Enter your Last Name");
		lname = sc.nextLine();
		
		String name = fname + " " + lname;
        
        System.out.println("Press 1 - Nagali Papad \n" + 
		"Press 2 - Jwary Papad\n" + "Press 3 - Tandul Papad \n" + "Press 4 - Makka Papad" );
        
		int papadType = sc.nextInt();
		
		
		
		switch(papadType) {
		case 1 :
			if(1 >0) {
				papadtypes = "Nagli Papad";
			}
			System.out.println("Enter Quantity ");
			quantity = sc.nextInt();
			details();
			new Papads(quantity, 1, name,id);
			
		break;
		case 2 :
			if(2 >0) {
				papadtypes = "Jwary Papad";
			}
			System.out.println("Enter Quantity ");
			quantity = sc.nextInt();
			details();
			new Papads(quantity, 2, name,id);
		break;
		case 3 :
			if(3 >0) {
				papadtypes = "Tadul Papad";
			}
			System.out.println("Enter Quantity ");
			quantity = sc.nextInt();
			details();
			new Papads(quantity, 3, name, id);
		break;
		case 4 :
			if(4 >0) {
				papadtypes = "Makka Papad";
			}
			System.out.println("Enter Quantity ");
			quantity = sc.nextInt();
			details();
			new Papads(quantity, 4, name, id);
		break;
		default :
			System.out.println("Invali Input !");
		}	
		
	
		
		System.out.println("\n <<<<<<<<<<<<<<<<<<<< Thanks for choosing us ! >>>>>>>>>>>>>>>>>>>>");	
	}
	
	  public void details() {
			try {
				Conn connection = new Conn();
				String query = "insert into papadDetails(id, fname, lname, papadType ) values('"+id+"', '"+this.fname+"', '"+this.lname+"', '"+this.papadtypes+"')";
				int result = connection.statement.executeUpdate(query , Statement.RETURN_GENERATED_KEYS);
				
				if(result > 0) {
					System.out.println("query-1 successully updated");
				}
				
				ResultSet resultId = connection.statement.getGeneratedKeys();
				if (resultId.next()) {
		             id = resultId.getInt(1);
		            System.out.println("ID of the last updated record: " + id);
		            resultId.close();
		        }
			
			}catch(Exception e){
				e.printStackTrace();
			}
	  }
	
	public static void main(String[] args) {
		
		new Main();
	}

}
