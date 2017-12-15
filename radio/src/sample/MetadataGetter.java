package sample;

import net.moraleboost.streamscraper.ScrapeException;
import net.moraleboost.streamscraper.Scraper;
import net.moraleboost.streamscraper.Stream;
import net.moraleboost.streamscraper.scraper.IceCastScraper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class MetadataGetter {
    Scraper scraper = new IceCastScraper();
    List<Stream> streams = scraper.scrape(new URI("http://wnuq.pl:8000/radio.44100"));

    public MetadataGetter() throws URISyntaxException, ScrapeException {
    }

    public String CurrentSong() {
        String response = null;
        for (Stream stream : streams){
            response = stream.getCurrentSong();
        }
        return response;
    }
}
