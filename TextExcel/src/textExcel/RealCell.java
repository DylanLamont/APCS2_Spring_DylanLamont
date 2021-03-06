package textExcel;

public abstract class RealCell implements Cell {

	private String value;
	
	public RealCell (String enteredVal){				//constructor that saves entered string to the string field
		value = enteredVal;
	}
	@Override
	public String abbreviatedCellText() {				//basic method to take the string and turn it into the ten char String
		String returnStr = getDoubleValue() + "";
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
		return value;								//acts as a getter and returns the string field
	}
	
	
	public double getDoubleValue(){
		return Double.parseDouble(value);			//returns cell type
	}

}
