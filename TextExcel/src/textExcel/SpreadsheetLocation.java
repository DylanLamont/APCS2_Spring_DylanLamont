package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String locationValue = "";
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return 0;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    		locationValue = cellName;
    }

}
