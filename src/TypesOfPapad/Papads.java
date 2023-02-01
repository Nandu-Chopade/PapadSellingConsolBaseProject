package TypesOfPapad;
import java.util.Scanner;

public class Papads{
	 Scanner sc = new Scanner(System.in);
	 int revenue;
	 int quantity;
	 int condition;
	 int price;
	 int discount = 0;
	 int id;
	 int cases;
	 String name;
	 int latestQuantity;

	Papads(int quantity , int input , String name ,  int id){
		this.quantity = quantity;
		this.id = id;
        this.name = name;
	   if(input == 1) {
		   NagaliPapad(name, 1, quantity);
	   }else if(input == 2) {
		   JwaryPapad(name , 2, quantity);
	   }else if(input == 3) {
		   TandulPapad(name, 3, quantity);
	   }else if(input == 4) {
		   MakkaPapad(name, 4, quantity);
	   }

		try {
			Conn connection = new Conn();
			
			String sql = "update papadDetails" + " set quantity='"+quantity+"', price='"+price+"' , revenue ='"+revenue+"' , discount = '"+discount+"' " + " where id='"+id+"'";
	        int result =  connection.statement.executeUpdate(sql);
		
			if(result > 0) {
				System.out.println("query update successfully");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	 
		
	}
	
	public void NagaliPapad(String billingName, int cases , int quantity) {
		this.cases = cases;
		this.quantity = quantity;
		price = 130;
		calculations(price);
		System.out.println("\n Name :" +billingName +" \n Your Nagali Papad bill Amount is : " + revenue +  " and discont: " + discount);
		if(latestQuantity > 0) {
			System.out.println("you got discount " + discount);
		}
	}
	
	public void JwaryPapad(String billingName ,int cases , int quantity) {
		this.cases = cases;	
		this.quantity = quantity;
		price = 110;
		calculations(price);
		System.out.println("\n Name :" +billingName +"\n Your Jwary Papad bill Amount is : " + revenue + " and discont: " + discount);
		if(latestQuantity > 0) {
			System.out.println("you got discount " + discount);
		}
	}
	public void TandulPapad(String billingName, int cases , int quantity) {
		this.cases = cases;	
		this.quantity = quantity;
		price = 110;
		calculations(price);
		System.out.println("\n Name :" +billingName +"\n Your Tandul Papad bill Amount is : " + revenue +  " and discont: " + discount);
		if(latestQuantity > 0) {
			System.out.println("you got discount " + discount);
		}
	}
	public void MakkaPapad(String billingName , int cases , int quantity) {
		this.cases = cases;
		this.quantity = quantity;
		price = 110;
		calculations(price);
		System.out.println("\n Name : " +billingName +"\n Your Makka Papad bill Amount is : " + revenue +  " and discont: " + discount);
		if(latestQuantity > 0) {
			System.out.println("you got discount " + discount);
		}
	}
	
	 public void calculations( int price) {
			if(quantity >= 20) {
				discount = quantity * price* 2/100;
				int tempRevenue = quantity * price ;
				revenue = tempRevenue -discount;
				
			}else {
				revenue = quantity * price;
				 System.out.println("Buy 20 pk And Get 2 % Discount ");
				   System.out.println("would you like to  buy more Enter 1 - Yes or 2 - NO ");
				   condition  = sc.nextInt();
				  
				   switch(condition){
				   case 1: 
				     secondAttempt(cases, quantity );
				   break;
				   case 2 :
				   break;
				   default:
					   System.out.println("Invalid Input !");
				   break;	   
					   
			   }
		
				   
				   
			}
			
			
			
	  }
	 
	 public void secondAttempt(int cases , int latestQuantity){
		   if(cases > 0) {
			   
			   System.out.println("Enter more quantity to avail 2 % discount");
			   
			   latestQuantity = sc.nextInt();
			   
			   this.latestQuantity = latestQuantity;
			   
			   quantity = latestQuantity + quantity;
			   
			   NagaliPapad(name, 1 , quantity ); 
			   
		   }else if(cases > 0) {
			   
			   System.out.println("Enter more quantity to avail 2 % discount");
			   latestQuantity = sc.nextInt();
			   quantity = latestQuantity + quantity;
			   this.latestQuantity = latestQuantity;
			   JwaryPapad(name , 2, quantity);
			   
		   }else if(cases > 0) {
			   
			   System.out.println("Enter more quantity to avail 2 % discount");
			   latestQuantity = sc.nextInt();
			   quantity = latestQuantity + quantity;
			   this.latestQuantity = latestQuantity;
			   TandulPapad(name, 3, quantity);
			   
		   }else if(cases > 0) {
			   
			   System.out.println("Enter more quantity to avail 2 % discount");
			   latestQuantity = sc.nextInt();
			   quantity = latestQuantity + quantity;
			   this.latestQuantity = latestQuantity;
			   MakkaPapad(name, 4, quantity);
			   
		   }
	   }
}

