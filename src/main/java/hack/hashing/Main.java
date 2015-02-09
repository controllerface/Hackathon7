package hack.hashing;

import hack.hashing.data.BinaryStringGrid;
import hack.hashing.data.BinaryStringGridArray;
import hack.hashing.data.WebPage;
import hack.hashing.interfaces.Hash;
import hack.hashing.stephen.StephensHash;
import hack.hashing.stephen.StephensHasher;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.stream.Collectors;

/**
 * Created by Controllerface on 2/5/2015. And it is good
 */
public class Main {
    public static void main(String[] args)
    {
        WebPage google = new WebPage(getHtml("google.html"));
//        WebPage veracode = new WebPage(getHtml("veracode.html"));
//        WebPage yahoo = new WebPage(getHtml("yahoo.html"));
//        WebPage zappos = new WebPage(getHtml("zappos.html"));
//        WebPage zappos_boots_front = new WebPage(getHtml("zappos_boots_front.html"));
//        WebPage zappos_boots_back = new WebPage(getHtml("zappos_boots_back.html"));

        BinaryStringGridArray grids = google.generateDOMGrids();
    }

    private static String getHtml(String fileName)
    {
        String html = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/" + fileName)))
                .lines()
                .collect(Collectors.joining());
        return html;
    }
}
