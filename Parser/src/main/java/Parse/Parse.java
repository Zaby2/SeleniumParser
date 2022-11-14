package Parse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parse {
    private int curTitle;
    //List<String> str = new ArrayList<String>();
    public void Parsing() throws IOException {
            Source src = new Source();
            Document doc = Jsoup.parse(src.getSource());
            for (int i = 1; i < 10001; i++) {
                curTitle = i;
                Elements listNews = doc.select("#anime-list-container > div:nth-child("+ curTitle + ") > div > div.media-body > div.h5.font-weight-normal.mb-1 > a");
                try (FileWriter wr = new FileWriter("Anime.txt", true)) {
                    wr.append(i + " " + listNews.text());
                    wr.append("\n");
                    wr.flush();
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
    }
}

