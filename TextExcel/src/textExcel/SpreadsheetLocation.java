package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String locationValue = "";
    @Override
    public int getRow()
    {
        int rowNum = Integer.parseInt(locationValue.substring(1)) - 1;
        return rowNum;
    }

    @Override
    public int getCol()
    {
        int colNum = locationValue.charAt(0) - 65;
        return colNum;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    		locationValue = cellName;
    }

}
