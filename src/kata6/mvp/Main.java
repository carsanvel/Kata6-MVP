package kata6.mvp;

import Model.Rectangle;
import View.RectangleDisplay;
import Presenter.RectanglePresenter;

public class Main {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(0, 0, 50, 25);
        MainFrame frame = new MainFrame();
        RectangleDisplay display = frame.getRectangleDisplay();
        RectanglePresenter presenter = new RectanglePresenter(rectangle, display); 
        frame.execute();
    }
    
}
