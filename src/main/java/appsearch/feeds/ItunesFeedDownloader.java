package appsearch.feeds;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.appengine.api.urlfetch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

@Component
public class ItunesFeedDownloader {

    @Autowired ObjectMapper objectMapper;
    @Autowired ItunesRepository itunesRepository;

    protected Map fetchQuery(String term, String country, String lang) {
        Map itunesResponse = null;
        try {
            URLFetchService urlFetchService = URLFetchServiceFactory.getURLFetchService();
            String url = "https://itunes.apple.com/search?entity=software&" +
                    "term=" + URLEncoder.encode(term, "UTF-8") + "&" +
                    "country=" + country + "&" +
                    "lang=" + lang;
            HTTPRequest request = new HTTPRequest(new URL(url), HTTPMethod.GET);
            HTTPResponse response =	urlFetchService.fetch(request);
            if (response.getResponseCode() == 200) {
                itunesResponse = objectMapper.readValue(response.getContent(), Map.class);
            }
        } catch (Exception e) {
            // TODO:  add logger
        }
        return itunesResponse;
    }

    public List<Map> query(String term, String country, String lang) {
        Map response = fetchQuery(term, country, lang);
        return (List<Map>) response.get("results");
    }

    public List saveQueryResults(String term, String country, String lang) {
        List<Map> results = query(term, country, lang);
        for (Map result: results) {
            String key = String.valueOf(result.get("trackId"));
            String json = null;
            try {
                json = objectMapper.writeValueAsString(result);
            } catch (Exception e) {
                // TODO: add logger
            }
            itunesRepository.save(key, country, json);
        }
        return results;
    }

}
