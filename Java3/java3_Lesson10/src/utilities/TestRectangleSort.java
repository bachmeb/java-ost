package utilities;

public class TestRectangleSort {

	public static void main (String[] args){
		TestRectangleSort newExample = new TestRectangleSort();
		newExample.sortRectangles();
		
	}
	
	public void sortRectangles(){
		// we create an array of Rectangles 
		Rectangle[] figures = new Rectangle[5];
		
		// fill it with three Rectangle objects 
		figures[0] = new Rectangle(60,30,160,100);
		figures[1] = new Rectangle(10,120,40,150);
		figures[2] = new Rectangle(90,125,143,163);
		figures[3] = new Rectangle(90,125,143,163);
		figures[4] = new Rectangle(90,200,143,163);
		
		// and then display their values, in order
		System.out.println("Before shellSort:");
		for (int i=0; i < figures.length; i++){
			System.out.println("Area is " + figures[i].getArea() );
		}
		
		// Once that's done, we call the Sortable.shellSort() method, 
		//passing the array and figures to the method. 
		Sorts.shellSort(figures);
		
		// Then we display the array in order again
		System.out.println("\nAfter shellSort:");
		for (int i = 0; i < figures.length; i++){
			System.out.println("Area is " + figures[i].getArea());
		}
	}
	
}
