package ui.applet;

import interfaces.Resettable;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

import event.ShapeMouseHandler;
import shapes.Rectangle;
import shapes.Shape;
import ui.panels.MainPanel;
import model.Model;

public class GUIDemo extends Applet implements Resettable {
    MainPanel mainPanel;
    Model model;
  
    public void init() {
    	//set the applet window size
        resize(600,400);
        //make a Model object
        model = new Model(this);
        //make a MainPanel object
        mainPanel = new MainPanel(model);
        //add the MainPanel to this Applet
        add(mainPanel);
        //make a ShapeMouseHandler
        ShapeMouseHandler mouseHandler = new ShapeMouseHandler(model);
        //add the ShapeMouseHandler to this applet as a MouseListener
        addMouseListener(mouseHandler);
        //add the ShapeMouseHandler to this applet as a MouseMotionListener
        addMouseMotionListener(mouseHandler);
        //set the default colors
        model.setCurrentFillColor(Color.BLUE);
        model.setCurrentLineColor(Color.BLUE);
    }
  
    public void paint(Graphics g) {
    	//Declare a Shape
        Shape shape;
        //See how many shapes are in the model.shapes array
        int many = model.shapes.length;
        //Instantiate the Shape from the Model
        for (int i=0; i<many; i++){
            //shape = model.getCurrentShape();
        	shape = model.shapes[i];
            //If the Model provided a Shape, then draw() it
            if(shape != null) {
            	//set the shape colors
            	shape.setLineColor(model.getCurrentLineColor());
                if (shape instanceof Rectangle) {
                	//set the fill Color
                	((Rectangle) shape).setFillColor(model.getCurrentFillColor());
                    //set the shape isFill property
                    ((Rectangle) shape).setFill(model.isFill());
                }
              shape.draw(g);
            }
            //Log the Model and Shape to the console
            System.out.println(model);
            System.out.println(shape);
        	
            //Homework 9
            //Then if two figures have been drawn and the two objects drawn can be compared,
            //have the objects compared using the model's compareShapes() method.
            //The applet output should show the two drawings and also specify which one 
            //is larger than the other, or if they are the same area.
            if (model.shapes[1] != null){
            	int comparison = model.compareShapes();
            	switch (comparison){
            	case -1:
        			g.drawString("The shapes cannot be compared", 200, 200);
            		break;
            	case 0:
        			g.drawString("The shapes are the same size", 200, 200);
            		break;
        		case 1:
        			g.drawString("The first shape is bigger than the second shape", 200, 200);
            		break;
        		case 2:
        			g.drawString("The second shape is bigger than the first shape", 200, 200);
            		break;
            	}
            }
            
        }
    }
  
    public void resetComponents() {
    	//call the resetComponents() method of the MainPanel object
        mainPanel.resetComponents();
    }
}