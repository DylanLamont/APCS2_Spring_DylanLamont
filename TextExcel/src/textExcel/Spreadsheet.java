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
	public String processCommand(String command)
	{
		String[] commandBreakdown = command.split(" ");
		if (commandBreakdown[1].equals("=")){
			String location = commandBreakdown[0];
			SpreadsheetLocation cellLocation = new SpreadsheetLocation(location);
			int rowNum = cellLocation.getRow();
			int columnNum = cellLocation.getCol();
			
		}
		return command;
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
		// TODO Auto-generated method stub
		return null;
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
