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
		return valueDoub + "";
	}
	
	public ValueCell (String enteredVal){
		super (enteredVal);
		valueDoub = Double.parseDouble(super.fullCellText());		
	}
	
	public double getDoubleValue(){
		return valueDoub;
	}

}
