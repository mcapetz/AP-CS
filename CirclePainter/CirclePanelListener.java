// *** Your name: Margaret Capetz
package ch6webcat;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class CirclePanelListener implements MouseListener, MouseMotionListener{
	
	private CirclePanel circlePanel;
	private Circle currentlyDraggedCircle = null;
	private int offsetX;
	private int offsetY;
	private Color colorOfNewlyCreatedCircles = Color.red;
	private int radiusOfNewlyCreatedCircles = 30;
	
	public CirclePanelListener(CirclePanel panel) {
		circlePanel = panel;
		circlePanel.addMouseListener(this);
		circlePanel.addMouseMotionListener(this);
	}
	
	public void setColorOfNewlyCreatedCircles(Color color) {
		colorOfNewlyCreatedCircles = color;
	}
	
	public void setRadiusOfNewlyCreatedCircles(int radius) {
		radiusOfNewlyCreatedCircles = radius;
	}

	@Override
	public void mouseClicked(MouseEvent ev) {
		//implement this method to add a circle to circlePanel
		//the circle should have the color and radius specified by
		//colorOfNewlyCreatedCircles and radiusOfNewlyCreatedCircles
		//the center of the created circle should be at the click location
		circlePanel.addCircle(new Circle(ev.getX()-radiusOfNewlyCreatedCircles, ev.getY()-radiusOfNewlyCreatedCircles, radiusOfNewlyCreatedCircles, colorOfNewlyCreatedCircles));
		circlePanel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent ev) { }

	@Override
	public void mouseExited(MouseEvent ev) { 
	}

	@Override
	public void mousePressed(MouseEvent ev) {
		//implement this method in conjunction with the mouseDragged
		//method to be able to drag circles in the circlePanel
		currentlyDraggedCircle = circlePanel.containsPoint(ev.getX(), ev.getY());
		if(currentlyDraggedCircle != null && currentlyDraggedCircle.containsPoint(ev.getX(), ev.getY())) {
			offsetX = ev.getX() - currentlyDraggedCircle.getX();
			offsetY = ev.getY() - currentlyDraggedCircle.getY();
			mouseDragged(ev);
		}
	}

	@Override
	public void mouseReleased(MouseEvent ev) { 
		currentlyDraggedCircle = null;
	}

	@Override
	public void mouseDragged(MouseEvent ev) {
		//implement this method in conjunction with the mousePressed
		//method to be able to drag circles in the circlePanel
		if(currentlyDraggedCircle != null) {
			currentlyDraggedCircle.setX(ev.getX() - offsetX);
			currentlyDraggedCircle.setY(ev.getY() - offsetY);
			circlePanel.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent ev) { }

}
