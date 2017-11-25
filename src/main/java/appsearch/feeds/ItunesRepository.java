package appsearch.feeds;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Text;
import com.google.appengine.repackaged.org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class ItunesRepository {

    final static String kind = "ItunesFeed";

    public void save(String key, String country, String jsonString) {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        // TODO: inject datastore instance per request
        Entity entity = new Entity(kind + country.toUpperCase(), key);
        Text json = new Text(jsonString);
        entity.setUnindexedProperty("json", json);
        Date created = DateTime.now().toDate();
        entity.setUnindexedProperty("created", created);
        datastore.put(entity);
    }

}
