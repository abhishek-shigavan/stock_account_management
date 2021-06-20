package stockaccount.model;
/**
 * UserAccount -- Defining properties of stock
 * 				  user is buying
 * 
 * @author Abhishek Shigavan
 *
 */
public class UserAccount {
	//properties of user stock
	private String share_Name;
	private int no_OfShare;
	private int share_Price;
	
	public UserAccount() {
		
	}

	public UserAccount(String share_Name, int no_OfShare, int share_Price) {
		
		this.share_Name = share_Name;
		this.no_OfShare = no_OfShare;
		this.share_Price = share_Price;
	}

	public String getShare_Name() {
		return share_Name;
	}

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
	//print format of UserAccount object
	@Override
	public String toString() {
		return "UserAccount [Share Name = " + share_Name + ", Quantity Of Share = " + no_OfShare + ", Price Of Share = " + share_Price +"]";
	}
}
