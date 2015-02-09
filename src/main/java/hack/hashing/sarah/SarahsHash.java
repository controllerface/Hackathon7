package hack.hashing.sarah;


import hack.hashing.interfaces.Hash;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Fancy on 2/5/15.
 */
public class SarahsHash implements Hash {
    int size;
    int darkness;
    List<boolean[]> crunchyListThing;


    public SarahsHash(int size, int darkness, List<boolean[]> crunchyListThing) {
        this.size = size;
        this.darkness = darkness;
        this.crunchyListThing=crunchyListThing;
    }
}
