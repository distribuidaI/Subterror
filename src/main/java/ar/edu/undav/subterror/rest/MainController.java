package ar.edu.undav.subterror.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
    @RequestMapping(path="/", method= RequestMethod.GET)
    public String goHome(){
        return "index";
    }

    @RequestMapping(path="/mapa", method= RequestMethod.GET)
    public String goMapa(){
        return "mapa";
    }

    @RequestMapping(path="/about", method= RequestMethod.GET)
    public String goAbout(){
        return "about";
    }

}
