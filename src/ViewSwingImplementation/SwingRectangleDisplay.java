package ViewSwingImplementation;

import View.RectangleDisplay;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class SwingRectangleDisplay extends JPanel implements RectangleDisplay{

    private int x0;
    private int y0;
    private int width;
    private int height;
    private final List<Listener> listeners;

    public SwingRectangleDisplay() {
        listeners  = new ArrayList<>();
        CompleteMouseListener mouseListener = new CompleteMouseListener();
        addMouseListener(mouseListener);
        addMouseMotionListener(mouseListener);
    }
    
    @Override
    public void display(int x0, int y0, int width, int height) {
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
        repaint();
    }
    
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.white);
        g.fillRect(oX() + x0, oY() + y0, width, height);
    }
    
    @Override
    public int oX(){
        return getWidth()/2;
    } 
            
    @Override
    public int oY(){
        return getHeight()/2;
    } 

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    
    private boolean inRange(int x, int y) {
        if(x >= x0 + oX() && y >= y0 + oY() && x <= oX() + x0 + width && y <= oY() + y0 + height) {
            return true;
        }
        return false;
    }
    
    private class CompleteMouseListener implements MouseListener, MouseMotionListener {

        private boolean pressed = false;
        private int pressedXDifference;
        private int pressedYDifference;
        
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if(inRange(e.getX(), e.getY())) {
                pressed = true;
                pressedXDifference = e.getX() - (x0 + oX());
                pressedYDifference = e.getY() - (y0 + oY());
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            pressed = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(pressed) {
                int x = (e.getX() - pressedXDifference - oX());
                int y = (e.getY() - pressedYDifference - oY());
                if(x + oX() + width <= getWidth() &&  x + oX() >= 0 && y + oY() + height <= getHeight() && y + oY() >= 0) {
                    for (Listener listener : listeners) {
                        listener.moveRectangle(x, y);
                    }
                } else {
                    if(x + oX() + width > getWidth() ||  x + oX() < 0) {
                        for (Listener listener : listeners) {
                            listener.moveRectangle(x0, y);
                        }
                    }
                    else {
                        for (Listener listener : listeners) {
                            listener.moveRectangle(x, y0);
                        }
                    }
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
        
    }
                    
                  
}
