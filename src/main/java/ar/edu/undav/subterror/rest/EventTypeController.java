package ar.edu.undav.subterror.rest;

import ar.edu.undav.subterror.domain.EventType;
import ar.edu.undav.subterror.domain.EventTypeRepository;
import ar.edu.undav.subterror.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by leo on 6/11/17.
 */

@RestController
@RequestMapping(value = "/eventtype")
public class EventTypeController {

    private EventTypeService eventTypeService;

    @Autowired
    public EventTypeController(EventTypeService eventTypeService){
        this.eventTypeService = eventTypeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<EventType> getAllEventType(){
        return this.eventTypeService.getAllEventType();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EventType getEventType(@PathVariable Long id){
        return this.eventTypeService.getEventTypeById(id);
    }

}
