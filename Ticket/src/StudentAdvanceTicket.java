
public class StudentAdvanceTicket extends AdvanceTicket {
	public StudentAdvanceTicket (int number, int daysUntilEvent){
		super(number, daysUntilEvent);
		setPrice(getPrice() * .5);
	}
}
