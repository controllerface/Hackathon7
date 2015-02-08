package hack.hashing.sarah;


import hack.hashing.interfaces.Hash;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * Created by Fancy on 2/5/15.
 */
public class SarahsHash implements Hash {
    int size;
    double darkness;
    //for 20 slices through the data
    int[][] pixelHash=new int[20][];
    int whiteCount=0;
    int blackCount=0;

    public SarahsHash(int size, double darkness, int[] compare) {
        this.size = size;
        this.darkness = darkness;
        this.pixelHash = compare;
    }

    public SarahsHash(){
    }

    public double getDarkness() {
        //this is going to actually work as a dependency of getPixelHash.
          //as pixel hash needs to go through every element.

    }
//
    public Hash getPixelHash(BufferedImage[] image){
        //only colors present.
        int WHITE=0xFFFFFFFF;
        int BLACK=0xFF000000;
        int x=0;
        int y=0;

        //walk through each line image by image. adding size of image to total.
        for(int i=0;i<size;i++){

            BufferedImage thisLine=image[i];
            int thisWidth=thisLine.getWidth();
            int thisHeight=thisLine.getHeight();
            int thisLength=thisWidth*thisHeight;
            int[] lastPixelLine=new int[thisWidth];
            int[] thisPixelLine=new int[thisWidth];
            //this might not work
            int[][] wholeLines= new int[thisLength][];
            size=thisLength+size;
            //this loops through the entire image and increases blackCount and whiteCount.
            //I need to change this so it sticks one line into a variable, and another line into a variabl
            //and then XORs the pants off of them.
            for(int j=0;j<thisLength;j++){
                int thisPixel=thisLine.getRGB(x,y);
                x++;
                if(thisPixel==BLACK){
                    blackCount++;
                    thisPixelLine[thisPixelLine.length]=0;
                }
                else{
                    whiteCount++;
                    thisPixelLine[thisPixelLine.length]=1;
                }
                //if we've reached the end of the line, we need to set x back to 0
                //add 1 to y. check to see if this is the first line in the image.
                //XOR this line from the last line, and replace last line.
                if(x==(thisWidth+1)){
                    x=0;
                    y=y+1;
                    if(lastPixelLine.length!=0) {
                        for(int k=0;k<thisWidth;k++){
                            lastPixelLine[k]=thisPixelLine[k] ^ lastPixelLine[k];
                        }
                    }
                }
                //if we have reached the end the image, add the XORd line to the list of whole lines.
                if(y==(thisHeight+1)){
                    wholeLines[wholeLines.length]=lastPixelLine;

                }
                //ok we have gone through all the images.
                //need to take wholeLines down to 20 lines.
                int numLines=image.length;
                int numPerSection=numLines/20;
                for(int m=0;m<numLines;m++){
                    //keeping track of lines being xord
                    int z=0;
                    //go through the lines, xor through numPerSection and throw them in the relevant part of pixelHash
                }
            }




//            //getRGB returns an int TYPE_INT_ARGB, it needs x and y coords. but I have what I need to get that.
//            //size should be the total number of pixels. when x reaches width, increase y++ and bring x to 0.
//            image.getRGB(x,y)
        }
    }






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
