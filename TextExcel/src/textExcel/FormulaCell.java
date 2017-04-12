package textExcel;
import java.util.*;

public class FormulaCell extends RealCell{

	private String cellText = "";
	private Cell[][] sprdsheet;		//saves array from spreadsheet to access information
	
	@Override
	public String abbreviatedCellText() {
		String abbCellText = getDoubleValue() +"";
		
		if (abbCellText.length() > 10){
			return abbCellText.substring(0,10);  //shorten's formula to being a 10 spaced value

		}else {
			String returnStr = abbCellText;
			while (returnStr.length() < 10){		// adds spaces in order to fill 10 chars, also if length is 10, falls to printing value
				returnStr += " ";
			}
			return (returnStr);
		}
	}

	@Override
	public String fullCellText() {
		return super.fullCellText();				//returns true value of formula cell using super method
	}
	
	public FormulaCell (String enteredForm, Cell[][] calledSpreadSheet){
		super(enteredForm);							//constructor to fill super's String field (accesses by fullCellText)
		cellText = fullCellText().substring(2, fullCellText().length()-2);
		sprdsheet = calledSpreadSheet;
	}

	public String getType(){
		return "FormulaCell";						//returns type of cell
	}
	
	public double getDoubleValue (){
		ArrayList<String> operators = new ArrayList<String>();			//ArrayList with all operators of formula
		ArrayList<String> operands = new ArrayList<String>();			//ArrayList with all operands of formula

		if( cellText.length() > 3){
			if (cellText.substring(0,3).equalsIgnoreCase("AVG")){			//test to see if call to Average function
				String range = cellText.substring(cellText.indexOf(" "));	//pass in to method range given in call
				return processAvg(range);
			}else if (cellText.substring(0,3).equalsIgnoreCase("SUM")){		//test to see if call to Average function
				String range = cellText.substring(cellText.indexOf(" "));	//pass in to method range given in call
				return processSum(range);
			}
		}
		
		for (int i = 0; i < cellText.length(); i++){
			// test to see if an operator, especially a subtraction and not a negative
			if((cellText.charAt(i) == '+' ||(cellText.charAt(i) == '-' && cellText.charAt(i+1) == ' ')||cellText.charAt(i) == '*' ||cellText.charAt(i) == '/')){			// test to see if an operator, especially a subtraction and not a negative
				operators.add(cellText.charAt(i) + "");		//added to operators ArrayList
			} 
			else if (cellText.charAt(i) == ' ');			//Skip the times the character is a space
			else {
				char charAtCheckForCell = cellText.charAt(i);		
				String value = "";
				String cutString = cellText.substring(i);
				//test to see if the next character is nonnumeric and is part of a cell name
				if ((charAtCheckForCell >= 'a'&& charAtCheckForCell <= 'z') || (charAtCheckForCell >= 'A'&& charAtCheckForCell <= 'Z')){
					if (cutString.indexOf(" ") != -1){			//test to see if need to cut string for gathering after information
						value = cutString.substring(0, cutString.indexOf(" "));
						i += cutString.indexOf(" ");			//change loop variable to skip to end of segment of operand information, i.e. skip to read next important new item
					}else{								
						value = cutString;			//take rest of string
						i += cutString.length();	//causes falling out of loop
					}
					operands.add(value);			//adding information to operand ArrayList
				}else{
					if (cutString.indexOf(" ") != -1){		
						value = cutString.substring(0, cutString.indexOf(" "));		//taking non cell based information
						i += cutString.indexOf(" ");
					}else{
						value = cutString;
						i += cutString.length();
					}
					operands.add(value);
				}
			}
		}
	char charAtCheckForCell = operands.get(0).charAt(0);
	double returnVal;
	if ((charAtCheckForCell >= 'a'&& charAtCheckForCell <= 'z') || (charAtCheckForCell >= 'A'&& charAtCheckForCell <= 'Z')){		//check if in processing there's a need to call getdoublevalue of operand
		returnVal = cellCallInFunction(operands.get(0));
	}else{
		returnVal = Double.parseDouble(operands.get(0));
	}
	//both cases above there to cover chance of only one entered value
	
	for (int i = 0; i < operators.size(); i++){
		if (operators.get(i).equalsIgnoreCase("+")){			//process adding
			charAtCheckForCell = operands.get(i+1).charAt(0);			//getting char to check in following if statement if the next opration needs to be with a cell call
			if ((charAtCheckForCell >= 'a'&& charAtCheckForCell <= 'z') || (charAtCheckForCell >= 'A'&& charAtCheckForCell <= 'Z')){
				returnVal += cellCallInFunction(operands.get(i+1));			//process call to cell value
			}else {
				returnVal += Double.parseDouble(operands.get(i+1));			//simple value adding
			}
		} else if (operators.get(i).equalsIgnoreCase("-")){
			charAtCheckForCell = operands.get(i+1).charAt(0);			////getting char to check in following if statement if the next opration needs to be with a cell call
			if ((charAtCheckForCell >= 'a'&& charAtCheckForCell <= 'z') || (charAtCheckForCell >= 'A'&& charAtCheckForCell <= 'Z')){
				returnVal -= cellCallInFunction(operands.get(i+1));			//calling a cell that fills in the value for the operand
			}else {
				returnVal -= Double.parseDouble(operands.get(i+1));			//subtracting with a standard value
			}
		} else if (operators.get(i).equalsIgnoreCase("*")){
			charAtCheckForCell = operands.get(i+1).charAt(0);			//getting char to check in following if statement if the next opration needs to be with a cell call
			if ((charAtCheckForCell >= 'a'&& charAtCheckForCell <= 'z') || (charAtCheckForCell >= 'A'&& charAtCheckForCell <= 'Z')){
				returnVal *= cellCallInFunction(operands.get(i+1));			//multiplying with a cell value
			}else {
				returnVal *= Double.parseDouble(operands.get(i+1));		//simple value multiplication
			}
		} else if (operators.get(i).equalsIgnoreCase("/")){
			charAtCheckForCell = operands.get(i+1).charAt(0);		//getting char to check in following if statement if the next opration needs to be with a cell call
			if ((charAtCheckForCell >= 'a'&& charAtCheckForCell <= 'z') || (charAtCheckForCell >= 'A'&& charAtCheckForCell <= 'Z')){
				returnVal /= cellCallInFunction(operands.get(i+1));		//calling value of a cell to multiply the formula by
			}else {
				returnVal /= Double.parseDouble(operands.get(i+1));		//standard operand processing
			}
		}
	}
	return returnVal;
}
	
	public double cellCallInFunction (String cellLocation){
		SpreadsheetLocation formulaCallLoc = new SpreadsheetLocation(cellLocation);			//initialize cellLocation to get access to getCol and getRow functions
		double cellCallValue = sprdsheet[formulaCallLoc.getRow()][formulaCallLoc.getCol()].getDoubleValue();	//getting value of a cell
		return cellCallValue;	
	}
	
	public double processAvg(String range){
		String[] rangeLoc = range.trim().split("-");				//splits string into two locations
		SpreadsheetLocation rangeStart = new SpreadsheetLocation(rangeLoc[0]);		//initializing location of the first location in the range
		SpreadsheetLocation rangeEnd = new SpreadsheetLocation(rangeLoc[1]);		//initializing location of the second location in the range
		return processSum(range)/(((rangeEnd.getRow() - rangeStart.getRow()) + 1)*((rangeEnd.getCol() - rangeStart.getCol())+ 1));	//taking sum of range and dividing by the total number of cells, even if in same row or column
		}

	public double processSum(String range){
		String[] rangeLoc = range.trim().split("-");				//processes range into a two locations that can be worked with
		SpreadsheetLocation rangeStart = new SpreadsheetLocation(rangeLoc[0]);
		SpreadsheetLocation rangeEnd = new SpreadsheetLocation(rangeLoc[1]);
		double sum = 0.0;
		if (rangeStart.getRow() == rangeEnd.getRow()){
			for (int i = rangeStart.getCol(); i <= rangeEnd.getCol(); i++){		//finds sum of a range in one column
				if (sprdsheet[rangeStart.getRow()][i] instanceof EmptyCell){
					sum += 0.0;
				}else {
					sum += sprdsheet[rangeStart.getRow()][i].getDoubleValue();
				}
			}
			return sum;
		}else{
			for (int i = rangeStart.getRow(); i <= rangeEnd.getRow(); i++){			//nested for loop to run through all of the cells and fins sum
				for (int j = rangeStart.getCol(); j <= rangeEnd.getCol(); j++){
					if (sprdsheet[i][j] instanceof EmptyCell){
						sum += 0.0;
					}else{
						sum += sprdsheet[i][j].getDoubleValue();
					}
				}
			}
			return sum;
		}
	}
}
