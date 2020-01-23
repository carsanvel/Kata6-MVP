package Presenter;

import Model.Rectangle;
import View.RectangleDisplay;

public class RectanglePresenter {

    private final Rectangle rectangle;
    private final RectangleDisplay rectangleDisplay;

    public RectanglePresenter(Rectangle rectangle, RectangleDisplay rectangleDisplay) {
        this.rectangle = rectangle;
        this.rectangleDisplay = rectangleDisplay;
        rectangleDisplay.display(rectangle.getX0(), rectangle.getY0(), rectangle.getWidth(), rectangle.getHeight());
        rectangleDisplay.addListener(new RectangleDisplay.Listener() {

            @Override
            public void moveRectangle(int x, int y) {
                rectangle.setPosition(x, y);
                rectangleDisplay.display(rectangle.getX0(), rectangle.getY0(), rectangle.getWidth(), rectangle.getHeight());
            }
            
        });
    }
            
    
}
