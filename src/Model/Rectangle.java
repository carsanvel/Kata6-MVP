package Model;

public class Rectangle {

    private int x0;
    private int y0;
    private final int width;
    private final int height;

    public Rectangle(int x0, int y0, int width, int height) {
        this.x0 = x0;
        this.y0 = y0;
        this.width = width;
        this.height = height;
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }
    
    public void setPosition(int x, int y) {
        x0 = x;
        y0 = y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
}
