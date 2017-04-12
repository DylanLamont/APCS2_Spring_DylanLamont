package textExcel;

public class EmptyCell implements Cell {

	@Override
	public String abbreviatedCellText() {
		return "          ";		//return ten spaced string
	}

	@Override
	public String fullCellText() {
		return "";					//return empty value of a cell
	}
	public String getType(){
		return "EmptyCell";			//implemented method from interface, although never used, placed for certainty
	}

	public double getDoubleValue(){
		return 0.0;					//Way to allow for more versitile adding, so one can have EmptyCells in range for sum or avg without errors
	}
}
