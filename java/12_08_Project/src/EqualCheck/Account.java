package EqualCheck;


public class Account {
	private int amount;
	private String name;
	
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Account p = (Account)obj;
		
		if(this.getAmount()==p.getAmount() && this.getName() == p.getName())
			return true;
		else
			return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public static void main(String[] args) {
		Account e=new Account();
		e.setAmount(200);
		e.setName("Ajeet");
		
		Account a = new Account();
		a.setAmount(200);
		a.setName("Ajeet");
		System.out.println(a.equals(e));
		
	}
	

}
