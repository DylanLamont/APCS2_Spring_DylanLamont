package textExcel;

public class ValueCell extends RealCell {
	private double valueDoub;

	@Override
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return super.fullCellText();
	}
	
	public ValueCell (String enteredVal){
		super (enteredVal);
		valueDoub = Double.parseDouble(super.fullCellText());		
	}
	
	public double getDoubleValue(){
		return valueDoub;
	}
	public String getType(){
		return "ValueCell";
	}

}
