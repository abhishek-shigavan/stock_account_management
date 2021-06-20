package stockaccount.controller;

import stockaccount.model.StockAccount;
import stockaccount.service.StockAccountService;
import stockaccount.util.UserInputOutput;
/**
 * StockAccountMain -- Showing UserMenu (i.e operation to perform)
 * 					   & according to user input doing operations
 * 
 * @author Abhishek Shigavan
 *
 */
public class StockAccountMain {

	public static void main(String[] args) {
		
		StockAccountService stockAccountService = new StockAccountService();
		
		boolean flag = true;
		
		while(flag) {
			
			int choice = UserInputOutput.getUserChoice();
			
			switch (choice) {
				case 1: {
					
					StockAccount stockAccount = readDataFromConsole();
					stockAccountService.addStock(stockAccount);
					break;
				}
				case 2: {
					
					System.out.println("**** Individual Stock ****");
					String share_Name = UserInputOutput.getShareName();
					stockAccountService.viewIndividualStock(share_Name);
					break;
				}
				case 3: {
					
					System.out.println("**** Stock Account ****");
					stockAccountService.viewAllStock();
					break;
				}
				case 4: {
					
					System.out.println("**** Add Dollar To Account ****");
					int account_Balance = UserInputOutput.getAccountBalance();
					stockAccountService.saveAccountBalance(account_Balance);
					break;
				}
				case 5: {
					
					System.out.println("**** Check Account Balance ****");
					stockAccountService.checkAccountBalance();
					break;
				}
				case 6: {
					
					System.out.println("**** User Share Record ****");
					stockAccountService.showUserShare();
					break;
				}
				case 7: {
					
					System.out.println("**** Buy Share ****");
					int acount_Balance=stockAccountService.checkAccountBalance();
					String share_Name = UserInputOutput.buyShareName();
					int buy_Quantity = UserInputOutput.buyShareQuantity();
					stockAccountService.buyShare(acount_Balance, share_Name, buy_Quantity);
					break;
				}
				case 8: {
					
					System.out.println("**** Sell Share ****");
					String share_Name = UserInputOutput.sellShareName();
					int sell_Quantity = UserInputOutput.sellShareQuantity();
					stockAccountService.sellShare(share_Name, sell_Quantity);
					break;
				}
				case 9: {
					
					flag = false;
					break;
				}
				default: {
					break;
				}
			}
			
		}	
	}
/**
 * This method takes value stock details
 * & setting it to variable
 * 	
 */
	public static StockAccount readDataFromConsole() {
        
		StockAccount stockAccount = new StockAccount();
		
        System.out.println("**** Share Details ****");

        String share_Name = UserInputOutput.getShareName();
        stockAccount.setShare_Name(share_Name);

        int no_OfShare = UserInputOutput.getShareQuantity();
        stockAccount.setNo_OfShare(no_OfShare);

        int share_Price = UserInputOutput.getSharePrice();
        stockAccount.setShare_Price(share_Price);

        return stockAccount;
    }
}
