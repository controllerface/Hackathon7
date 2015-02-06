package hack.hashing.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
        for (String line : lines)
        {
            images.add(generateImage(line));
        }
        return images.toArray(new BufferedImage[images.size()]);
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
}
