package textExcel;
//import java.math.*;

public class PercentCell extends RealCell {
	
	@Override
	public String abbreviatedCellText() {
		String returnStr = ((int)(getDoubleValue())) + "%";
		//String returnStr = value;
		if (returnStr.length() < 10){
			while (returnStr.length() < 10){
				returnStr += " ";
			}
			return returnStr;
		} else if (returnStr.length() > 10){
			returnStr = returnStr.substring(0, 10);
			return returnStr;
		}else{
			return returnStr;
		}

	}

	@Override
	public String fullCellText() {
		return (getDoubleValue()/100.0) + "";
	}
	
	public PercentCell(String initialValue){
		super(initialValue);
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(super.fullCellText().substring(0, super.fullCellText().length()-1));
	}

	public String getType(){
		return "PercentCell";
	}
}
