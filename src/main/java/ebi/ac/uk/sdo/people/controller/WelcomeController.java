package ebi.ac.uk.sdo.people.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

    /**
     * <p>Welcome page for the main root</p>
     */
    @RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String welcome() {
        return "<html><body><div>Welcome to SDO REST API</div></body></html>";
    }
}
