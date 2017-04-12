package textExcel;

public interface Cell
{
	public String abbreviatedCellText(); // text for spreadsheet cell display, must be exactly length 10
	public String fullCellText(); // text for individual cell inspection, not truncated or padded
	public String getType(); //returns type of cell in order to form spreadsheet
	public double getDoubleValue(); // method used in realCells, but needed to be used through Cell array, also allows for option to add with EmptyCell and TextCell in range
}
