package textExcel;

public class FormulaCell extends RealCell{

	@Override
	public String abbreviatedCellText() {
		String cellText = fullCellText().substring(fullCellText().indexOf("("), fullCellText().indexOf(")"));
		String[] cellTextBreakdown = cellText.split(" ");
		return cellTextBreakdown.toString();
		/*
		if (cellText.length() > 10){
			return cellText.substring(0,10);  //shorten's formula to being a 10 spaced value

		}else {
			String returnStr = cellText;
			while (returnStr.length() < 10){		// adds spaces in order to fill 10 chars, also if length is 10, falls to printing value
				returnStr += " ";
			}
			return returnStr;
		}*/
	}

	@Override
	public String fullCellText() {
		return super.fullCellText();				//returns true value of formula cell using super method
	}
	
	public FormulaCell (String enteredForm){
		super(enteredForm);							//constructor to fill super's String field (accesses by fullCellText)
	}

	public String getType(){
		return "FormulaCell";						//returns type of cell
	}
}
