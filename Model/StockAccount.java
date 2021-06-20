package stockaccount.model;
/**
 * StockAccount -- Defining properties of stock
 * 				   & method to get & set values of properties
 * 
 * @author Abhishek Shigavan
 *
 */
public class StockAccount {
	//properties of stock
	private String share_Name;
	private int no_OfShare;
	private int share_Price;
	
	public StockAccount() {
		
	}

	public StockAccount(String share_Name, int no_OfShare, int share_Price) {
		
		this.share_Name = share_Name;
		this.no_OfShare = no_OfShare;
		this.share_Price = share_Price;
	}
	//to get share name
	public String getShare_Name() {
		return share_Name;
	}
	// to set share name
	public void setShare_Name(String share_Name) {
		this.share_Name = share_Name;
	}

	public int getNo_OfShare() {
		return no_OfShare;
	}

	public void setNo_OfShare(int no_OfShare) {
		this.no_OfShare = no_OfShare;
	}

	public int getShare_Price() {
		return share_Price;
	}

	public void setShare_Price(int share_Price) {
		this.share_Price = share_Price;
	}
	//print format of StockAccount object
	@Override
	public String toString() {
		return "StockAccount : "+share_Name +" [Share Name = " + share_Name + ", Total No Of Share = " + no_OfShare + ", Share Price = " + share_Price
				+ "]";
	}
	
}
