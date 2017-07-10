package ar.edu.undav.subterror.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sol on 7/9/17.
 */
@Controller
public class MainController {
    @RequestMapping(path="/", method= RequestMethod.GET)
    public String goHome(){
        return "index";
    }
}