
public class AdvanceTicket extends Ticket {
	public AdvanceTicket (int number, int daysToEvent){
		super(number);
		if (daysToEvent >= 10){
			super.setPrice(40.0);
		}else{
			super.setPrice(30.0);
		}
	}
//	public AdvanceTicket (int number){
//		super(number);
//	}
}
