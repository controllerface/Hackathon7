package hack.hashing.sarah;

import hack.hashing.data.WebPage;
import hack.hashing.interfaces.Hash;
import hack.hashing.interfaces.Hasher;
import java.awt.image.BufferedImage;

/**
 * Created by Fancy on 2/5/15.
 */
public class SarahsHasher implements Hasher {
    //we have made a singleton. There can be only one.
    private static SarahsHasher internalInstance;
    private SarahsHasher(){

    };
    public static SarahsHasher getInstance(){
        if(internalInstance==null){
            internalInstance=new SarahsHasher();
        }
        return internalInstance;
    };

    @Override
    public Hash hashMaker(WebPage webpage) {
        //webpage will have an element that is a buffered image.
        final int WHITE=0xFFFFFFFF;
        final int BLACK=0xFF000000;
        BufferedImage[] pageImage=webpage.domImage();
        SarahsHash myHash=new SarahsHash();
        myHash.size=pageImage.getHeight()*pageImage.getWidth();



        //three components to a hashMaker.
        //I've made a change

        //info I need to make my hash: white=0xFFFFFFFF  black=0xFF000000




        return null;
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