package hack.hashing.sarah;

import hack.hashing.data.BinaryStringGrid;
import hack.hashing.data.BinaryStringGridArray;
import hack.hashing.data.WebPage;
import hack.hashing.interfaces.Hash;
import hack.hashing.interfaces.Hasher;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fancy on 2/5/15.
 */
public class SarahsHasher implements Hasher {
    //we have made a singleton. There can be only one.
    private static SarahsHasher internalInstance;

    private SarahsHasher() {

    }

    ;

    public static SarahsHasher getInstance() {
        if (internalInstance == null) {
            internalInstance = new SarahsHasher();
        }
        return internalInstance;
    }

    ;

    boolean[] crunchGrid(BinaryStringGrid tobeCrunched, int height, int width) {
        boolean[] crunchedUp = new boolean[width];
        for(int i=0;i<width;i++){
            crunchedUp[i]=tobeCrunched.get(i,0);
        }
        for (int y = 1; y < height; y++) {
            for (int x = 0; x < width; x++) {
                crunchedUp[x] = tobeCrunched.get(x, y) ^ crunchedUp[x];

             }
        }
        return crunchedUp;
    }

    @Override
    public Hash hashMaker(WebPage webpage) {
        BinaryStringGridArray grids=webpage.generateDOMGrids();
        int blackCount=0;
        //might only keep track of one of these, if I have size.
        //int whiteCount=0;
        List<boolean[]> crunchedList=new ArrayList<boolean[]>();

        for(int i=0;i<grids.entries();i++){
            BinaryStringGrid currentGrid=grids.get(i);
            blackCount+=currentGrid.countBlack();
            crunchedList.add(crunchGrid(currentGrid,grids.getMaxHeight(),grids.getMaxWidth()));
        }

        return new SarahsHash((grids.getMaxHeight()*grids.getMaxHeight()*grids.entries()),blackCount,crunchedList);
    }

    @Override
    public Double compare(Hash hash1, Hash hash2) {
        return null;
    }

    @Override
    public boolean unique(Hash hash) {
        return false;
    }
}