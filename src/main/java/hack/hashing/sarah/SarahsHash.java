package hack.hashing.sarah;


import hack.hashing.interfaces.Hash;
import java.awt.image.BufferedImage;


/**
 * Created by Fancy on 2/5/15.
 */
public class SarahsHash implements Hash {
    int size;
    double darkness;
    int[] pixelHash={0};
    int whiteCount=0;
    int blackCount=0;

    public SarahsHash(int size, double darkness, boolean compare) {
        this.size = size;
        this.darkness = darkness;
        //this.pixelHash = compare;
    }

    public SarahsHash(){
    }

//    public getDarkness() {
//        //this is going to actually work as a dependency of pixelHash. as pixel hash needs to go through every element.
//
//    }
//
//    public getPixelHash(BufferedImage image){
//        for(int i=0;i<size;i++){
//            int x=0;
//            int y=0;
//
//
//            //getRGB returns an int TYPE_INT_ARGB, it needs x and y coords. but I have what I need to get that.
//            //size should be the total number of pixels. when x reaches width, increase y++ and bring x to 0.
//            image.getRGB(x,y)
//        }
//    }






    //size data
    //int size(){
    //    return 0;
   // }
    //darkness density
    //double percentDark(){
    //    return 0;
    //}

    //results of xor of xor
    //boolean[] compareResult(){
    //  return null;
    //}

    //BufferedImage pageImage=webpage.domImage();
    //int pageHeight=pageImage.getHeight();
}
