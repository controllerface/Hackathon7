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

    public int countBlack(){
        int blackCount=0;
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                if(data[x][y]){
                    blackCount++;
                }
            }
        }
        return blackCount;}
    //public int getHeight(){return height;}

}
