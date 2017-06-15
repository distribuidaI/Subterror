package ar.edu.undav.subterror.rest;

/**
 * Created by leo on 6/11/17.
 */
import ar.edu.undav.subterror.domain.Event;
import ar.edu.undav.subterror.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/event")
public class EventController
{
    private EventService eventService;

    @Autowired
    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Event> getAllEvent(){
        return this.eventService.getAllEvent();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Event getEvent(@PathVariable Long id){
        return this.eventService.getEvent(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void addEvent(@RequestBody Event event){
        eventService.addEvent(event);
    }

}