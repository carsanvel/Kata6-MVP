package kata6.mvp;

import View.RectangleDisplay;
import ViewSwingImplementation.SwingRectangleDisplay;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    
    private RectangleDisplay rectangleDisplay;
           
    public MainFrame() {
        setTitle("Kata6-MVP");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(rectangleDisplay());
    }
    
    public void execute() {
        setVisible(true);
    }
    
    private JPanel rectangleDisplay() {
        SwingRectangleDisplay display = new SwingRectangleDisplay();
        rectangleDisplay = display;
        return display;
    }
    
    public RectangleDisplay getRectangleDisplay() {
        return rectangleDisplay;
    }

    
    
}
