package shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class PolyOctagon extends Shape {
	
	Color fillColor;
	int width; 
	int height;
	boolean fill;
	
	Point A;
	Point B;
	Point C;
	Point D;
	Point E;
	Point F;
	Point G;
	Point H;

	double ratioAX;
	double ratioBX;
	double ratioCX;
	double ratioDX;
	double ratioEX;
	double ratioFX;
	double ratioGX;
	double ratioHX;
	
	double ratioAY;
	double ratioBY;
	double ratioCY;
	double ratioDY;
	double ratioEY;
	double ratioFY;
	double ratioGY;
	double ratioHY;
		
	int sides;
	Polygon p;

	public PolyOctagon(
			Color lineColor, 
			int x, 
			int y,
			int w,
			int h,
    		Color fillColor, 
    		boolean fill
			){
		
		// Super constructor
		super(lineColor, x, y);
		
		A = new Point(lineColor,x,y);
		B = new Point(lineColor,x,y);
		C = new Point(lineColor,x,y);
		D = new Point(lineColor,x,y);
		E = new Point(lineColor,x,y);
		F = new Point(lineColor,x,y);
		G = new Point(lineColor,x,y);
		H = new Point(lineColor,x,y);

		this.width = w;
		this.height = h;

		this.fillColor = fillColor;
		this.fill = fill;
		
		sides = 8;
		
		ratioAX = 0.293333;
		ratioBX = 0.706667;
		ratioCX = 1;
		ratioDX = 1;
		ratioEX = 0.706667;
		ratioFX = 0.293333;
		ratioGX = 0;
		ratioHX = 0;
		
		ratioAY = 0;
		ratioBY = 0;
		ratioCY = 0.293333;
		ratioDY = 0.706667;
		ratioEY = 1;
		ratioFY = 1;
		ratioGY = 0.706667;
		ratioHY = 0.293333;	
		
	}

	@Override
	public void draw(Graphics g) {

        // Be nice. Save the state of the object before changing it.
        Color oldColor = g.getColor();
        
		int [] polyx = new int [8];
		int [] polyy = new int [8];
		
		
//		Octagon numbers
//		0	0
//		62	0
//		106	44
//		106	106
//		62	150
//		0	150
//		-44	106
//		-44	44
		
//		44	0
//		106	0
//		150	44
//		150	106
//		106	150
//		44	150
//		0	106
//		0	44
		
//		0.293333	0
//		0.706667	0
//		1	0.293333
//		1	0.706667
//		0.706667	1
//		0.293333	1
//		0	0.706667
//		0	0.293333
	      
	      
		A.setX( super.x + (int)(width * ratioAX) );
		A.setY( super.y + (int)(width * ratioAY) );

		B.setX( super.x + (int)(width * ratioBX)  );
		B.setY( super.y + (int)(width * ratioBY)  );
		
		C.setX( super.x + (int)(width * ratioCX)  );
		C.setY( super.y + (int)(width * ratioCY)  ); 
		
		D.setX( super.x + (int)(width * ratioDX)  );
		D.setY( super.y + (int)(width * ratioDY)  );
		
		E.setX( super.x + (int)(width * ratioEX)  );
		E.setY( super.y + (int)(width * ratioEY)  );
		
		F.setX( super.x + (int)(width * ratioFX)  );
		F.setY( super.y + (int)(width * ratioFY)  );
		
		G.setX( super.x + (int)(width * ratioGX)  );
		G.setY( super.y + (int)(width * ratioGY)  );
		
		H.setX( super.x + (int)(width * ratioHX)  );
		H.setY( super.y + (int)(width * ratioHY)  );
		
		polyx[0]=A.getX(); 
		polyx[1]=B.getX(); 
		polyx[2]=C.getX();
		polyx[3]=D.getX();
		polyx[4]=E.getX();
		polyx[5]=F.getX();
		polyx[6]=G.getX();
		polyx[7]=H.getX();

		polyy[0]=A.getY(); 
		polyy[1]=B.getY(); 
		polyy[2]=C.getY();
		polyy[3]=D.getY();
		polyy[4]=E.getY();
		polyy[5]=F.getY();
		polyy[6]=G.getY();
		polyy[7]=H.getY();
		
		p = new Polygon(polyx, polyy, sides);
		
        if (isFill()) { //TODO: Add Fill property to PolyTri
            g.setColor(getFillColor());
            g.fillPolygon(p);
        }
        g.setColor(getLineColor());

        g.drawPolygon(p);
        // Set the state back when done.
        g.setColor(oldColor); 

	}

	// Override abstract method containsLocation in the Shape class.
	@Override
	public boolean containsLocation(int x, int y) {
		if ( p.contains(x,y) ){
			return true;
		}
		return false;
	}


	/**
	 * Returns a String representing this object.
	 * Overrides toString() in java.lang.Object
	 */
	@Override
	public String toString() {
		return "Octagon: " +
				"\n\tA = ( " + A.getX() + "," + A.getY() + " )" + 
				"\n\tB = ( " + B.getX() + "," + B.getY() + " )" + 
				"\n\tB = ( " + C.getX() + "," + C.getY() + " )" + 
				"\n\tB = ( " + D.getX() + "," + D.getY() + " )" + 
				"\n\tB = ( " + E.getX() + "," + E.getY() + " )" + 
				"\n\tB = ( " + F.getX() + "," + F.getY() + " )" + 
				"\n\tB = ( " + G.getX() + "," + G.getY() + " )" +  
				"\n\tC = ( " + H.getX() + "," + H.getY() + " )"  
				;
	}
	
	//getters and setters
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public Point getA() {
		return A;
	}

	public void setA(Point a) {
		A = a;
	}

	public Point getB() {
		return B;
	}

	public void setB(Point b) {
		B = b;
	}

	public Point getC() {
		return C;
	}

	public void setC(Point c) {
		C = c;
	}

	public Point getD() {
		return D;
	}

	public void setD(Point d) {
		D = d;
	}

	public Point getE() {
		return E;
	}

	public void setE(Point e) {
		E = e;
	}

	public Point getF() {
		return F;
	}

	public void setF(Point f) {
		F = f;
	}

	public Point getG() {
		return G;
	}

	public void setG(Point g) {
		G = g;
	}

	public Point getH() {
		return H;
	}

	public void setH(Point h) {
		H = h;
	}

}
