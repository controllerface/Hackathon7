package hack.hashing.data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import java.awt.image.BufferedImage;

/**
 * Created by Controllerface on 2/5/2015.
 */
public class WebPage {
    private final Document dom;

    public WebPage(String html) {
        Document parsed = Jsoup.parse(html, "http://localhost", Parser.xmlParser());
        this.dom = parsed;
    }

    public BufferedImage[] domImage(){
        return null;
    }

    public String domString(){
        return dom.toString();
    }
}
