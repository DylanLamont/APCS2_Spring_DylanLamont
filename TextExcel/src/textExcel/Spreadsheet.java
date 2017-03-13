package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] spreadsheetArr = new Cell[20][12];
	
	public Spreadsheet(){
		for( int i = 0; i < spreadsheetArr.length; i++){
			for (int j = 0; j<spreadsheetArr[i].length; j++){
				spreadsheetArr[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command){
		if(command.equalsIgnoreCase("")){
			return "";
		}
		if (command.indexOf(" ") > 0){
			String[] commandBreakdown = command.split(" ", 3);
			if (commandBreakdown.length > 1){
				if (commandBreakdown[1].equals("=")){
					String location = commandBreakdown[0];
					SpreadsheetLocation cellLocation = new SpreadsheetLocation(location);
					int rowNum = cellLocation.getRow();
					int columnNum = cellLocation.getCol();
					if (commandBreakdown[2].substring(commandBreakdown[2].length()-1).equals("%")){
						spreadsheetArr[rowNum][columnNum] = new PercentCell(commandBreakdown[2]);
					} else if(commandBreakdown[2].charAt(0) == '"' && commandBreakdown[2].charAt(commandBreakdown[2].length()-1) == '"'){
						spreadsheetArr[rowNum][columnNum] = new TextCell(commandBreakdown[2].substring(1, commandBreakdown[2].length()-1));
					} else if (commandBreakdown[2].indexOf(".") > 0){
						spreadsheetArr[rowNum][columnNum] = new ValueCell(commandBreakdown[2]);
					}else if (commandBreakdown[2].charAt(0) == '(' && commandBreakdown[2].charAt(commandBreakdown[2].length()-1) == ')'){
						spreadsheetArr[rowNum][columnNum] = new FormulaCell(commandBreakdown[2]);
					}
					return (getGridText());
				} else if (commandBreakdown[0].equalsIgnoreCase("clear")){
					SpreadsheetLocation cellLocation = new SpreadsheetLocation(commandBreakdown[1]);
					spreadsheetArr[cellLocation.getRow()][cellLocation.getCol()] = new EmptyCell();
					return (getGridText());
				}
			}
		}else if (command.equalsIgnoreCase("clear")){
			for( int i = 0; i < spreadsheetArr.length; i++){
				for (int j = 0; j<spreadsheetArr[i].length; j++){
					spreadsheetArr[i][j] = new EmptyCell();
				}
			}
			return (getGridText());
		} else if(command.length() < 5){
			SpreadsheetLocation cellLocation = new SpreadsheetLocation(command);
			return (getCell(cellLocation).fullCellText());
		}
		return "";
	}



	@Override
	public int getRows()
	{
		return 20;
	}

	@Override
	public int getCols()
	{
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return spreadsheetArr[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String grid = "";
		grid += "   |";
		char columnLet = 'A';
		for(int i = 0; i < 12; i++){
			grid += ((char)(columnLet)) + "         |";
			columnLet += 1;
		}
		grid += "\n";
		
		for (int i = 0; i < 20; i++){
			if(i<9){
				grid += (i+1) + "  |";
			} else {
				grid += (i+1) + " |";
			}
			for(int j = 0; j<12 ; j++){
				grid += spreadsheetArr[i][j].abbreviatedCellText() + "|";
			}
			grid += "\n";
		}
		
		return grid;
	}

}
