package hack.hashing.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * Created by Controllerface on 2/5/2015.
 */
public class WebPage {
    private final Document dom;

    @FunctionalInterface
    public interface DomSerializer{
        String serialize(Document dom);
    }

    public WebPage(String html) {
        Document parsed = Jsoup.parse(html);//, "http://localhost", Parser.xmlParser());
        this.dom = parsed;
    }

    public BufferedImage[] domImage(){
        String[] lines = domString().split("\n");
        ArrayList<BufferedImage> images = new ArrayList<>(lines.length);
        int maxWidth = 0;
        for (String line : lines)
        {
            BufferedImage nextImage = generateImage(line);
            if (maxWidth<nextImage.getWidth()) maxWidth = nextImage.getWidth();
            images.add(nextImage);
        }

        for (int i =0; i < images.size(); i++)
        {
            BufferedImage thisImage = images.get(i);
            if (thisImage.getWidth() < maxWidth)
            {
                BufferedImage expanded = expandImage(thisImage, maxWidth, thisImage.getHeight(), thisImage.getType());
                images.set(i, expanded);
            }
        }

        return images.toArray(new BufferedImage[images.size()]);
    }

    public BinaryStringGridArray generateDOMGrids(){
        String[] lines = domString().split("\n");
        ArrayList<BinaryStringGrid> output = new ArrayList<>(lines.length);
        int maxWidth = 0;
        int maxHeight = 0;

        // generate initial grids for all lines, with varying widths
        for (String line : lines)
        {
            // generate the text image
            BufferedImage currentImage = generateImage(line);

            // update max width and height
            if (maxWidth < currentImage.getWidth()) maxWidth = currentImage.getWidth();
            if (maxHeight < currentImage.getHeight()) maxHeight = currentImage.getHeight();


            // create a buffer to hold the grid data
            boolean[][] rawData = new boolean[currentImage.getWidth()][currentImage.getHeight()];

            // loop through all the pixels in the image and update the raw data
            for (int x = 0; x < currentImage.getWidth(); x++)
            {
                for (int y = 0; y < currentImage.getHeight(); y++)
                {
                    rawData[x][y] = currentImage.getRGB(x,y) == 0xFF000000;
                }
            }
            output.add(new BinaryStringGrid(currentImage.getWidth(), currentImage.getHeight(), rawData));
        }
        return new BinaryStringGridArray(output.toArray(new BinaryStringGrid[lines.length]),maxWidth, maxHeight);
    }

    public String domString(){
        return dom.toString();
    }

    public String domString(DomSerializer serializer)
    {
        return serializer.serialize(dom);
    }

    private BufferedImage generateImage(String line)
    {
        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphicsContext = image.createGraphics();
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 10);
        graphicsContext.setFont(font);
        FontMetrics fontMetrics = graphicsContext.getFontMetrics();
        int width = fontMetrics.stringWidth(line);
        int height = fontMetrics.getHeight();
        graphicsContext.dispose();
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        graphicsContext = image.createGraphics();
        graphicsContext.setFont(font);
        fontMetrics = graphicsContext.getFontMetrics();
        graphicsContext.setColor(Color.WHITE);
        graphicsContext.fillRect(0, 0, image.getWidth(), image.getHeight());
        graphicsContext.setColor(Color.BLACK);
        graphicsContext.drawString(line, 0, fontMetrics.getAscent());
        graphicsContext.dispose();
//        try {
//            ImageIO.write(image, "png", new File("Text.png"));
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
        return image;
    }

    private BufferedImage expandImage(BufferedImage source, int width, int height, int type)
    {
        BufferedImage expandedImage = new BufferedImage(width, height, type);
        Graphics graphicsContext = expandedImage.getGraphics();
        graphicsContext.setColor(Color.white);
        graphicsContext.fillRect(0, 0, width, source.getHeight());
        graphicsContext.drawImage(source,0,0,null);
        graphicsContext.dispose();
        return expandedImage;
    }
}
