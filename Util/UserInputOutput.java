package stockaccount.util;

import java.util.Scanner;
/**
 * UserInputOutput -- Defining methods to read
 * 					  user input from console
 * 
 * @author Abhishek Shigavan
 *
 */
public class UserInputOutput {
	
	static final Scanner sc = new Scanner(System.in);
/**
 * This method print menu
 * & take input from user
 * 	
 * @return Chosen Option
 */
	public static int getUserChoice() {
		
		System.out.println();
		System.out.println("**** Stock Account Management ****");
		System.out.println("1. Add Stock");
		System.out.println("2. View Individual Share Stock");
		System.out.println("3. View All Share Stock");
		System.out.println("4. Add Dollar to Account");
		System.out.println("5. Check Account Balance");
		System.out.println("6. User Share Record");
		System.out.println("7. Buy Share");
		System.out.println("8. Sell Share");
		System.out.println("9. Exit");
		return sc.nextInt();
	}
/**
 * This method takes share name
 *  from user
 *  	
 * @return share name
 */
	public static String getShareName() {
		
		System.out.println("Enter Share Name : ");
		return sc.next();
	}
/**
 * This method takes share quantity
 *  from user
 *  	
 * @return share quantity
 */	
	public static int getShareQuantity() {
		
		System.out.println("Enter Share Quantity : ");
		return sc.nextInt();
	}
/**
 * This method takes share price
 *  from user
 *  	
 * @return share price
 */	
	public static int getSharePrice() {
		
		System.out.println("Enter Share Price : ");
		return sc.nextInt();
	}
/**
 * This method takes No of
 * Dollar to add into account
 * 
 * @return No Dollar 
 */
	public static int getAccountBalance() {
		
		System.out.println("Enter Dollar To Add To Account : ");
		return sc.nextInt();
	}
/**
 * This method takes name of
 * share to buy
 * 	
 * @return share name
 */
	public static String buyShareName() {
		
		System.out.println("Enter Name Of Share To Buy : ");
		return sc.next();
	}
/**
 * This method takes quantity
 * of share to buy
 * 	
 * @return quantity of share
 */
	public static int buyShareQuantity() {
		
		System.out.println("Enter Quantity of Share To Buy : ");
		return sc.nextInt();
	}
/**
 * This method takes name of
 * share to sell
 * 	
 * @return share name
 */	
	public static String sellShareName() {
		
		System.out.println("Enter Name of Share To Sell : ");
		return sc.next();
	}
/**
 * This method takes quantity
 * of share to sell
 * 	
 * @return quantity of share
 */
	
	public static int sellShareQuantity() {
		
		System.out.println("Enter Quantity of Share To Sell : ");
		return sc.nextInt();
	}
}
