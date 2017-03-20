package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private String locationValue;
    @Override
    public int getRow()
    {
        int rowNum = (Integer.parseInt(locationValue.substring(1)));
        return rowNum -1;
    }

    @Override
    public int getCol()
    {
    	int colNum;
    	if (locationValue.charAt(0)>90){
    		colNum = locationValue.charAt(0) - 97;
    	}else{
            colNum = locationValue.charAt(0) - 65;
    	}
        return colNum;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    		locationValue = cellName;
    }

}
