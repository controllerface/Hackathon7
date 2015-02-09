package hack.hashing.data;

/**
 * Created by Controllerface on 2/9/2015.
 */
public class BinaryStringGridArray {
    private final BinaryStringGrid[] data;
    private final int width;
    private final int height;

    public BinaryStringGridArray(BinaryStringGrid[] data, int width, int height) {
        this.data = data;
        this.width = width;
        this.height = height;
    }

    public BinaryStringGrid get(int index){
        return data[index];
    }

    public int getMaxWidth(){return width;}
    public int getMaxHeight(){return height;}
    public int entries(){return data.length;}
}
