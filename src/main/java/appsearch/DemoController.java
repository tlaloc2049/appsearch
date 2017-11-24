package appsearch;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DemoController {

    @RequestMapping(path={"/test"},method=RequestMethod.GET)
    @ResponseBody
    public Map sayHello() {
        return new HashMap<String, String>();
    }
}
