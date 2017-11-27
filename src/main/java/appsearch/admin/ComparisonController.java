package appsearch.admin;

import appsearch.feeds.ItunesFeedDownloader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ComparisonController {

    @Autowired
    ItunesFeedDownloader itunesFeedDownloader;

    @RequestMapping(path={"/compare"},method= RequestMethod.GET)
    @ResponseBody
    public Map compareResults(@RequestParam(name="term") String term,
                              @RequestParam(name="country") String country,
                              @RequestParam(name="lang", required = false) String lang) {
        Map<String, List> response = new HashMap<>();
        response.put("appsearch", null);
        response.put("itunes", itunesFeedDownloader.saveQueryResults(term, country, lang));
        return response;
    }

}
