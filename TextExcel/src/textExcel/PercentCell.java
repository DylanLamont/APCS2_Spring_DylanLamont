package textExcel;

public class PercentCell extends RealCell {
	
	@Override
	public String abbreviatedCellText() {
		// TODO Auto-generated method stub
		return super.abbreviatedCellText();
	}

	@Override
	public String fullCellText() {
		// TODO Auto-generated method stub
		return super.fullCellText();
	}
	
	public PercentCell(String initialValue){
		super(initialValue);
	}
	
	public double getDoubleValue(){
		return Double.parseDouble(fullCellText().substring(0, fullCellText().length()-1));
	}

}
