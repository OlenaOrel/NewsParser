package holders;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DocumentHolder {

    public Document getConnection(String url) throws IOException {
        return Jsoup.connect(url).get();
    }

}
