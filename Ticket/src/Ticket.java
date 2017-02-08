
abstract class Ticket {
	private int number;
	private double price;
	
	public Ticket (int number){
		this.number = number;
	}
	
	public double getPrice(){
		return price;
	}

	public String toString (){
		return ("Number: " + number + ", Price: " + price);
	}
	
	public void setPrice (double p){
		this.price = p;
	}
}
