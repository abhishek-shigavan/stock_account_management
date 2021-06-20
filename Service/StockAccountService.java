package stockaccount.service;

import stockaccount.dao.StockAccountDAO;
import stockaccount.model.StockAccount;
/**
 * InventoryService -- This class contains defination
 * 					   of methods
 * 
 * 
 * @author Abhishek Shigavan
 *
 */
public class StockAccountService implements StockAccountServiceInterface {

	StockAccountDAO stockAccountDAO = new StockAccountDAO();
	
	@Override
	public void addStock(StockAccount stockAccount) {
		
		stockAccountDAO.addStock(stockAccount);
	}

	@Override
	public void viewIndividualStock(String share_Name) {
		
		stockAccountDAO.viewIndividualStock(share_Name);
	}

	@Override
	public void viewAllStock() {
		
		stockAccountDAO.viewAllStock();
	}

	@Override
	public void saveAccountBalance(int account_balance) {
		
		stockAccountDAO.saveAccountBalance(account_balance);
	}

	@Override
	public int checkAccountBalance() {
		
		return stockAccountDAO.checkAccountBalance();
		
	}

	@Override
	public void buyShare(int account_Balance, String share_Name, int buy_Quantity) {
		
		stockAccountDAO.buyShare(account_Balance, share_Name, buy_Quantity);
	}

	@Override
	public void sellShare(String share_Name, int sell_Quantity) {
		
		stockAccountDAO.sellShare(share_Name, sell_Quantity);
	}

	@Override
	public void showUserShare() {
		
		stockAccountDAO.showUserShare();
	}

}
