package stockaccount.dao;

import java.util.ArrayList;
import java.util.List;

import stockaccount.model.StockAccount;
import stockaccount.model.UserAccount;
import stockaccount.service.StockAccountServiceInterface;
/**
 * StockAccountDAO -- This class contains all
 *                    CRED operations 
 *                    
 * @author Abhishek Shigavan
 *
 */
public class StockAccountDAO implements StockAccountServiceInterface{
	
	//list to keep track of stock
	List<StockAccount> stockList = new ArrayList<>();
	//list to keep track of buying and selling
	List<UserAccount> userList = new ArrayList<>();
	
	//To store account balance
	int[] account_Balance = {0};
/**
 * This method adding data to ArrayList
 * 
 * @return No return	
 */
	public void addStock(StockAccount stockAccount) {
		
		stockList.add(stockAccount);
		System.out.println();
		System.out.println("Stock Added Sucessfully");
	}
/**
 * This method prints individual stock
 * by matching share name with array list element
 * Also prints Total value of stock
 * 
 *  @return No return
 */
	@Override
	public void viewIndividualStock(String share_Name) {
		//checking share name is present / not
		boolean is_Present = isPresent(share_Name);

		if(is_Present == true) {
			 
			for(int i=0; i < stockList.size(); i++) {
				//matching share name with ArrayList element 
				if(stockList.get(i).getShare_Name().equals(share_Name)) {
					
					System.out.println();
					System.out.println(stockList.get(i));
					
					int totalStockValue = getStockValue(share_Name);
					System.out.println("Total Value of Stock : "+totalStockValue);
					System.out.println();
				}
			}
		}
		else {
			System.out.println("No Such Stock of "+share_Name+" in Stock Account");
		}
	}
/**
 * This method matches the given share name
 * with ArrayList share name
 * If match found return true
 * 	
 * @param share_Name
 * @return flag
 *         -- true -- if match found 
 *       
 */
	public boolean isPresent(String share_Name) {
		
		boolean flag = false;
		
		for(int i=0; i < stockList.size(); i++) {
			
			if(stockList.get(i).getShare_Name().equals(share_Name)) {
				flag = true;
			}
		}
		return flag;
	}
/**
 * This method match share name with ArrayList
 * element and fetches price & quantity of it.
 * 
 * Compute the total value & returns same.
 * 	
 * @param share_Name
 * @return totalStockValue
 */
	public int getStockValue(String share_Name) {
		
		int totalStockValue =0;
		for(int i=0; i < stockList.size(); i++) {
			
			if(stockList.get(i).getShare_Name().equals(share_Name)) {
				
				int quantity = stockList.get(i).getNo_OfShare();
				int price = stockList.get(i).getShare_Price();
				//computing stock value
				totalStockValue = quantity * price;
			}
		}
		
		return totalStockValue;
	}
/**
 * This method prints ArrayList (stockList) & 
 * total value of stock
 * 
 * @return No return
 */
	@Override
	public void viewAllStock() {
		
		int totalStockValue =0;
		
		for(int i=0; i < stockList.size();  i++) {
			
			System.out.println();
			System.out.println(stockList.get(i));
			
			String share_name = stockList.get(i).getShare_Name();
			//getting stock value of every share
			int stockValue = getStockValue(share_name);
			//computing total stock value
			totalStockValue += stockValue;
		}
		System.out.println();
		System.out.println("Total Stock Account Value : "+totalStockValue);
	}
/**
 * This method store account balance
 * into array
 * 
 * @return No return
 */
	@Override
	public void saveAccountBalance(int account_balance) {
		
		//fetching current available balance
		int remaining_Balance = getAccountBalance();
		//adding new balance to current balance & storing it
		this.account_Balance[0] = account_balance + remaining_Balance;
	}
/**
 * This method returns account balance
 * 	
 * @return account balance
 */
	public int getAccountBalance() {
		
		return account_Balance[0];
	}
/**
 * This method checks weather account
 * having balance or not
 * 
 * @return account_Balance
 */
	@Override
	public int checkAccountBalance() {
		
		int account_Balance = getAccountBalance();
		//prints account balance
		if(account_Balance > 0) {
			System.out.println();
			System.out.println("You have "+account_Balance+" Dollar in ur Account ");
		}
		else {
			System.out.println();
			System.out.println("You Dont Have Any Dollar In ur Account ");
		}
		
		return account_Balance;
	}
/**
 * This method matches share name
 * with ArrayList & returns price of that share
 * 	
 * @param share_Name
 * @return price of share
 */
	public int getSharePrice(String share_Name) {
		
		int share_Price =0;
		for(int i =0; i < stockList.size(); i++) {
			
			if(stockList.get(i).getShare_Name().equals(share_Name)) {
				//fetching share price
				share_Price = stockList.get(i).getShare_Price();
			}
		}
		return share_Price;
	}
/**
 * This method matches share name with
 * stockList and fetches quantity of that share
 * & returns the same
 * 	
 * @param share_Name
 * @return Quantity of share
 */
	public int getShareQuantity(String share_Name) {
		
		int share_Quantity =0;
		for(int i =0; i < stockList.size(); i++) {
			
			if(stockList.get(i).getShare_Name().equals(share_Name)) {
				//fetching share quantity
				share_Quantity = stockList.get(i).getNo_OfShare();
			}
		}
		return share_Quantity;
	}
/**
 * This methods checks buying capacity of user i.e
 * checks if account balance is sufficient or not
 * Checks if share of buying value are present in stock / not
 *  	
 * @param value_Of_Share_Buy
 * @param value_Of_Share_Present
 * @param account_Balance
 * @return flag
 */
	public boolean checkBuyingCapacity(int value_Of_Share_Buy, int value_Of_Share_Present, int account_Balance ) {
		
		boolean flag = true;
		//checking account balance is sufficient / not
		if(value_Of_Share_Buy > account_Balance) {
			
			flag = false;
			System.out.println("You Dont Have Sufficient Dollar To Buy Share ");
		}
		//checking if the share of buying value present in stock / not
		else if(value_Of_Share_Buy > value_Of_Share_Present) {
			
			flag =false;
			System.out.println("Sorry Dont Have This Much Share In Stock");
		}
		
		return flag;
	}
/**
 * Updating account balance after buying / selling
 * 	
 * @param updated_balance
 */
	public void updateAccountBalance(int updated_balance) {
		
		account_Balance[0] = updated_balance;
	}
/**
 * Updating share quantity of stock after buying 
 * 	
 * @param share_Name
 * @param share_Quantity
 */
	public void updateStock(String share_Name, int share_Quantity) {
		
		for(int i =0; i < stockList.size(); i++) {
			
			if(stockList.get(i).getShare_Name().equals(share_Name)) {
				
				stockList.get(i).setNo_OfShare(share_Quantity);
			}
		}
	}
/**
 * This method add stock details to userList
 * after buying & selling
 * 	
 * @param userAccount
 */
	public void addShare(UserAccount userAccount) {
	
		userList.add(userAccount);
	}
/**
 * Checking if the share name is present
 * in userList or not
 * 	
 * @param share_Name
 * @return flag
 */
	public boolean isSharePresent(String share_Name) {
		
		boolean flag =false;
		
		for(int i=0; i < userList.size(); i++) {
			//checking share name is present / not
			if(userList.get(i).getShare_Name().equals(share_Name)) {
				
				flag = true;
			}
		}
		return flag;
	}
/**
 * Checks share name is present in userList
 * If share present then update values
 * If not then add it to userList
 * 	
 * @param share_Name
 * @param share_Quantity
 * @param share_Price
 */
	public void addShareToUserAccount(String share_Name, int share_Quantity, int share_Price) {
		
		UserAccount userAccount = new UserAccount();
		
		boolean flag = isSharePresent(share_Name);
		//If share is already in user a/c then update values
		if(flag == true) {
		
			for(int i=0; i < userList.size(); i++) {
			
				if(userList.get(i).getShare_Name().equals(share_Name)) {
				
					//taking current share quantity from user a/c
					int old_Share_Quantity = userList.get(i).getNo_OfShare();
					//adding buy share into current share quantity
					int new_Share_Quantity = old_Share_Quantity + share_Quantity;
					//updating share quantity in a/c
					userList.get(i).setNo_OfShare(new_Share_Quantity);
				}
			}
		}
		//If share is new then add it to userList
		else {
			//setting value
			userAccount.setShare_Name(share_Name);
			userAccount.setNo_OfShare(share_Quantity);
			userAccount.setShare_Price(share_Price);
			//calling add method
			addShare(userAccount);
		}
	}
/**
 * This method checks all the prior condition
 * need to satisfy to buy share if all the condition
 * satisfied then initiate buy operation
 * 
 * @return No return	
 */
	@Override
	public void buyShare(int account_Balance, String share_Name, int buy_Quantity) {
		
		boolean is_Present = isPresent(share_Name);
		
		if(is_Present == true) {
			
			int share_Price = getSharePrice(share_Name);
			int share_Quantity = getShareQuantity(share_Name);
			//computing amount required to buy share 
			int value_Of_Share_Buy = share_Price * buy_Quantity;
			//total value of share present
			int value_Of_Share_Present = getStockValue(share_Name);
			
			boolean buying_Capacity = checkBuyingCapacity(value_Of_Share_Buy, value_Of_Share_Present, account_Balance);
			
			if(buying_Capacity == true) {
				
				int new_Balance = account_Balance - value_Of_Share_Buy; 
				int new_Share_Quantity = share_Quantity - buy_Quantity;
				
				updateAccountBalance(new_Balance);
				
				addShareToUserAccount(share_Name, buy_Quantity, share_Price);
				
				updateStock(share_Name, new_Share_Quantity);
				
				System.out.println();
				System.out.println("Done Buying Of Share Sucessfully...!!!");
			}
		}
		else {
			System.out.println("There Is No Such Stock of "+share_Name);
		}
	}
/**
 * This method prints userList
 * 
 * @return No return	
 */
	@Override
	public void showUserShare() {
		
		for(int i =0; i < userList.size(); i++) {
			
			System.out.println(userList.get(i));
			System.out.println();
		}
		
	}
/**
 * This method matches share name with
 * userList and fetches the Quantity of that share
 * 	
 * @param share_Name
 * @return Quantity of share
 */
	public int userShareQuantity(String share_Name) {
		
		int userShareQuantity =0;
		for(int i=0; i < userList.size(); i++) {
			
			if(userList.get(i).getShare_Name().equals(share_Name)) {
				
				userShareQuantity = userList.get(i).getNo_OfShare();
			}
		}
		return userShareQuantity;
	}
/**
 * This method gives share price of
 * given share
 * 	
 * @param share_Name
 * @return Share price
 */
	public int userSharePrice(String share_Name) {
	
		int userSharePrice =0;
		for(int i=0; i < userList.size(); i++) {
			
			if(userList.get(i).getShare_Name().equals(share_Name)) {
				
				userSharePrice = userList.get(i).getShare_Price();
			}
		}
		return userSharePrice;
	}
/**
 * This method checks if user is capable to sell share
 * i.e
 * Checks sell quantity is not exceeding available quantity
 * 	
 * @param share_Name
 * @param sell_Quantity
 * @return Flag
 */
	public boolean sellingCapacity(String share_Name, int sell_Quantity) {
		
		boolean flag = false;
		//available share to sell
		int userShareQuantity = userShareQuantity(share_Name);
		
		if(sell_Quantity <= userShareQuantity) {
			
			flag = true;
		}
		else {
			System.out.println("You have only "+userShareQuantity+" share to sell");
		}
		return flag;
	}
/**
 * This method update value quantity of share
 * after selling share	
 * @param share_Name
 * @param newShareQuantity
 */
	public void updateUserAccount(String share_Name, int newShareQuantity) {
	
		for(int i=0; i < userList.size(); i++) {
			
			if(userList.get(i).getShare_Name().equals(share_Name)) {
				
				userList.get(i).setNo_OfShare(newShareQuantity);
			}
		}
	}
/**
 * This method checks prior condition to 
 * sell share if condition meets then initiate
 * sell operation
 * 
 * @return No return	
 */
	@Override
	public void sellShare(String share_Name, int sell_Quantity) {
		//checking share is present in a/c 
		boolean flag = isSharePresent(share_Name);
		
		if(flag == true) {
			
			boolean sellingCapacity = sellingCapacity(share_Name, sell_Quantity);
			
			if(sellingCapacity == true) {
				
				int userSharePrice = userSharePrice(share_Name);
				//computing amount need to add into a/c after selling
				int balanceToAdd = userSharePrice * sell_Quantity;
				saveAccountBalance(balanceToAdd);
				
				int userShareQuantity = userShareQuantity(share_Name);
				//computing quantity after sell
				int newShareQuantity = userShareQuantity - sell_Quantity;
				
				updateUserAccount(share_Name, newShareQuantity);
				System.out.println();
				System.out.println("Selling of Share Sucessfull...!!!");
			}		
		}
		else {
			System.out.println("No such share of "+share_Name+" in ur Account");
		}
	}

}
