package utilities;

public class Rectangle extends Sortable {
	int uLX, uLY, lRX, lRY;
	private int area;
	
	public Rectangle(int upperLeftX, int upperLeftY, int lowerRightX, int lowerRightY){
		uLX = upperLeftX;
		uLY = upperLeftY;
		lRX = lowerRightX;
		lRY = lowerRightY;
		setArea();
	}

	private void setArea(){
		area = (lRX - uLX) * (lRY - uLY);
	}
	
	public int getArea(){
		return area;
	}
	
	@Override
	public int compareTo(Sortable b) {
		Rectangle oneToCompare = (Rectangle)b;
		if (getArea() < oneToCompare.getArea()) return -1; // this one is smaller
		if (getArea() > oneToCompare.getArea()) return 1; //this is the larger
		return 0; //they are the same
	}

}
