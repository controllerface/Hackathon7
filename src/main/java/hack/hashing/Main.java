package hack.hashing;

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
        String html = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("/google.html")))
                .lines()
                .collect(Collectors.joining());
        WebPage test = new WebPage(html);

        Hash hash = StephensHasher.getInstance().hashMaker(test);
        ((StephensHash) hash).shingleSet().stream().forEach(System.out::println);

        BufferedImage[] images = test.domImage();

        try {
            ImageIO.write(images[10], "png", new File("Text.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
