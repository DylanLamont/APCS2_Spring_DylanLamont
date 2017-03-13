package textExcel;

public class ValueCell implements Cell {
	private double value;
	private String valueStr;
	@Override
	public String abbreviatedCellText() {
		String returnStr = valueStr;
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
		// TODO Auto-generated method stub
		return value + "";
	}
	
	public ValueCell (String enteredVal){
		valueStr = enteredVal;
		value = Double.parseDouble(enteredVal);
	}

}
