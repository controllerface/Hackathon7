package hack.hashing.data;

/**
 * Created by Controllerface on 2/9/2015.
 */
public class BinaryStringGrid {
    private int width;
    private int height;
    private boolean[][] data;

    public BinaryStringGrid(int width, int height, boolean[][] data) {
        this.width = width;
        this.height = height;
        this.data = data;
    }

    public boolean get(int x, int y)
    {
        return !(x >= width || y >= height) && data[x][y];
    }
    //public int getWidth(){return width;}
    //public int getHeight(){return height;}

}
