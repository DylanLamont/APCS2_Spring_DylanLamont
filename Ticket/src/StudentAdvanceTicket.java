
public class StudentAdvanceTicket extends AdvanceTicket {
	public StudentAdvanceTicket (int number, int daysUntilEvent){
		super(number, 0);
		if (daysUntilEvent>=10){
			setPrice(15);
		} else{
			setPrice(20);
		}
	}
}
