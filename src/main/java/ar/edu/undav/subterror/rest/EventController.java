package ar.edu.undav.subterror.rest;

/**
 * Created by leo on 6/11/17.
 */
import ar.edu.undav.subterror.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/allevent")
public class HelloController
{
    EventRepository eventRepository;

    @Autowired
    public 
}