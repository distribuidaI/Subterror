package ar.edu.undav.subterror.rest;

/**
 * Created by leo on 6/11/17.
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @RequestMapping("/")
    String hello()
    {
        return "Hello World!";
    }
}