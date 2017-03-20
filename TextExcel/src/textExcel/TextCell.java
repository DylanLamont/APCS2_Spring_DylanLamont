package textExcel;

public class TextCell implements Cell {
	
	private String cellContents;
	
	public TextCell (String contents){
		cellContents = contents; 
	}
	@Override
	public String abbreviatedCellText() {
		String returnStr = cellContents;
		int cellValueLength = cellContents.length();
		if (cellContents.length() < 10){
			while (returnStr.length() < 10){
				returnStr += " ";
			}
			return returnStr;
		} else if (cellContents.length() > 10){
			returnStr = returnStr.substring(0, 10);
			return returnStr;
		}else{
			return cellContents;
		}
	}

	@Override
	public String fullCellText() {
		return "\"" + cellContents + "\"";
	}

	public String getType(){
		return "TextCell";
	}
}
