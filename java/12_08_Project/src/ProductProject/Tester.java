package ProductProject;

public class Tester {

	public static void main(String[] args) {
		Product p = new Tv("Tv","2015","Sony",40000);
		
		System.out.println(p.getClass().getName());
		System.out.println(Product.getItem());
		
		p = new Electronic("Wahsing Machine","2015",20000);
		
		System.out.println(p.getClass().getName());
		System.out.println(Product.getItem());
		
		p = new Book("The Da Vinci Code","Rohit",500);
		
		System.out.println(p.getClass().getName());
		System.out.println(Product.getItem());
	}

}
