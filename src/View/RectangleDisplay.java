package View;

public interface RectangleDisplay {

    void display(int x0, int y0, int width, int height);
    int oX();
    int oY();
    void addListener(Listener listener);
    
    public interface Listener {
        void moveRectangle(int x, int y);
    }
}
