package stockaccount.service;

import stockaccount.model.StockAccount;

public interface StockAccountServiceInterface {

	void addStock(StockAccount stockAccount);
	
	void viewIndividualStock(String share_Name);
	
	void viewAllStock();
	
	void saveAccountBalance(int account_balance);
	
	int checkAccountBalance();
	
	void buyShare(int account_Balance, String share_Name, int buy_Quantity);
	
	void sellShare(String share_Name, int sell_Quantity);
	
	void showUserShare();
}
