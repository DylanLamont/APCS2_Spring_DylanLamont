package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{
	private Cell[][] SpreadsheetArr = new Cell[19][11];
	
	public Spreadsheet(){
		for( int i = 0; i < SpreadsheetArr.length; i++){
			for (int j = 0; j<SpreadsheetArr[i].length; j++){
				SpreadsheetArr[i][j] = new EmptyCell();
			}
		}
	}

	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
